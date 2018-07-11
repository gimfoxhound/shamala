
package com.xerox.fidji.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


public class ConnectionPool {
private String driver;
private String url;
private int size=0;
private String username= new String("");
private String passworth= new String("");
private ArrayList pool=null;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String aValue) {
        if(aValue!=null)
        this.driver = aValue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String aValue) {
        if(aValue!=null)
        this.url = aValue;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int aValue) {
        if(aValue>1)
        this.size = aValue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String aValue) {
        if(aValue!=null)
        this.username = aValue;
    }

    public String getPassworth() {
        return passworth;
    }

    public void setPassworth(String aValue) {
        if(aValue!=null)
        this.passworth = aValue;
    }

    private Connection createConnection() throws Exception{
        //Crée tout simplement une connection
        Connection con=null;
        con= DriverManager.getConnection(url,username, passworth);
        
        return con;
    }

    //initialise le pool
    public synchronized void initializePool() throws Exception{
        if(driver==null){
            throw new Exception("Aucun Driver specifié");
        }
        if(url==null){
            throw new Exception("Pas d'URL DB specifiée");
        }
        if(size<1){
            throw new Exception("La taille du Pool est inferieur à 1");
        }
        //Crée les connections
        try{
            //charger le fichier classe du gestionnaire
            Class.forName(driver);
            //Cree les connections en fonction du nombre Size
            for(int x=0;x<size;x++){
                Connection con = createConnection();
                if(con!=null){
                    //Creation d'un pool de connections PooledConnection
                    PooledConnection pcon = new PooledConnection(con);
                    //Ajouter au pool de connection
                    addConnection(pcon);
                }
            }
        }catch(Exception exop){
            System.err.println(exop.getMessage());
            throw new Exception(exop.getMessage());
        }
    }
    private void addConnection(PooledConnection value){
        if(pool==null){
            pool = new ArrayList(size);
            pool.add(value);
        }
        
    }
public synchronized void releaseConnection(Connection con){
    for(int j=0;j<pool.size();j++){
        PooledConnection pcon =(PooledConnection)pool.get(j);
        if(pcon.getConnection()==con){
            System.err.println("Liberer la connection --->"+j);
            pcon.setInuse(false);
            break;
        }
    }
}    
//Trouver une connection disponible    
public synchronized Connection getConnection() throws Exception{
    PooledConnection pconn= null;
    Connection con=null;
    for(int j=0;j<pool.size();j++){
        pconn = (PooledConnection)pool.get(j);
        //Verifions si la connection est utilisée ?
        if(!pconn.isInuse()){
            pconn.setInuse(true);
            return pconn.getConnection();
        }
    }
    try{
        
        con= createConnection();
        pconn = new PooledConnection(con);
        pconn.setInuse(true);
        pool.add(pconn);
        
    }catch(Exception exop){
        System.err.println(exop.getMessage());
        exop.printStackTrace();
        throw new Exception(exop.getMessage());
        
    }
    return pconn.getConnection();
}
//Avant de fermer le pool il faut le vider!
public synchronized void emptyPool(){
    System.err.println("Fermer toutes les connections JDBC");
    for(int j=0;j<pool.size();j++){
        
       PooledConnection pconn= (PooledConnection) pool.get(j);
       //Si la connection n'est pas utilisée on la femer
       if(!pconn.isInuse()){
           pconn.close();
           //Sinon attendre 10 secondes et forcer la fermeture
       }else{
           try{
               java.lang.Thread.sleep(10000);
               pconn.close();
           }catch(InterruptedException irex){
               System.err.println(irex.getMessage());
           }
       }
    }
}

    
}
