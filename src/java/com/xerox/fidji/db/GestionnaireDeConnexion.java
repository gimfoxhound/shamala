
package com.xerox.fidji.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;
//import org.jboss.logging.Logger;


public class GestionnaireDeConnexion {
static Connection uneconnexion=null;
static String url;

public static Connection getConnection() throws Exception{
    boolean append =true;
    FileHandler handler = new FileHandler("h:\\Logs\\GestionnaireDeConnexionTrace.txt", append);
    Logger logger = Logger.getLogger("logs");
    logger.addHandler(handler);
    try{
        Class.forName(MesUtiliitairesDB.getDRIVERDBMYSQL()).newInstance();
    }catch(ClassNotFoundException cnfe){
        Logger.getLogger(GestionnaireDeConnexion.class.getName()).log(Level.SEVERE,null,cnfe);
        System.err.println("Le driver JDBC n'est pas chargé");
        logger.severe("Le driver JDBC n'est pas chargé "+ cnfe.getMessage());
    }
    catch (InstantiationException ex) {
        Logger.getLogger(GestionnaireDeConnexion.class.getName()).log(Level.SEVERE, null, ex);
        logger.severe("Le driver JDBC ne s'instancie pas. "+ex.getMessage());
    } catch (IllegalAccessException ex) {
        Logger.getLogger(GestionnaireDeConnexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("MySQL JDBC Driver Chargé");
    logger.severe("Le driver JDBC MySQL est chargé");;
    String mURL = MesUtiliitairesDB.getMONURLDB();
    try{
        uneconnexion= DriverManager.getConnection(mURL, MesUtiliitairesDB.getUSERNAMEDB(), MesUtiliitairesDB.getPASSWORDDB());
        
    }catch (SQLException sqlexop){
        Logger.getLogger(GestionnaireDeConnexion.class.getName()).log(Level.SEVERE, null, sqlexop);
        System.err.println("Probleme de driver manager, où l'url db, où le user, mot de passe");
        logger.severe("Probleme de driver manager, où l'url db, où le user, mot de passe. "+sqlexop.getMessage());
    }
    if(uneconnexion!=null){
        System.out.println("La connection à la DB à l'adresse : "+mURL+" est effectuée" );
        logger.info("La connection à la DB à l'adresse : "+mURL+" est effectuée" );
    }else{
        System.out.println("Probleme de connection");
        logger.warning("Probleme de connection");
    }
    return uneconnexion;
}

    
}
