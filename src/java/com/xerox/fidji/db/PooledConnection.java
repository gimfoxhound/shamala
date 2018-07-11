
package com.xerox.fidji.db;

import java.sql.Connection;
import java.sql.SQLException;


public class PooledConnection {
private Connection connection=null;    
private boolean inuse=false;

    public PooledConnection(Connection value) {
        if(value!=null){
            connection=value;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isInuse() {
        return inuse;
    }

    public void setInuse(boolean inuse) {
        this.inuse = inuse;
    }
    public void close(){
        try{
            connection.close();
        }catch(SQLException sqlexop){
            sqlexop.printStackTrace();
        }
    } 
        
    



}
