
package com.xerox.fidji.db;


public class MesUtiliitairesDB {
private static final String   MONURLDB = "jdbc:mysql://localhost:3306/sakila";
private static final String   USERNAMEDB= "root";
private static final String   PASSWORDDB="0123456789";
private static final String   DRIVERDBMYSQL="com.mysql.jdbc.Driver";
private static final String   CHEMINLOGSACTORDAO= "h:\\logs\\ActorDAOTrace.txt";                                                   
private static final String   CHEMINDESTIMAGESDEST="H:\\Travail\\MyPetstore\\IntroMVC2-V04\\build\\web\\tests";
private static final String   CHEMINSTOSOCKAGEDBSOURCE="H:\\MyUploadbis";


    public static String getUSERNAMEDB() {
        return USERNAMEDB;
    }

    public static String getPASSWORDDB() {
        return PASSWORDDB;
    }

    public static String getDRIVERDBMYSQL() {
        return DRIVERDBMYSQL;
    }

    public static String getMONURLDB() {
        return MONURLDB;
    }

    public static String getCHEMINLOGSACTORDAO() {
        return CHEMINLOGSACTORDAO;
    }

    public static String getCHEMINDESTIMAGESDEST() {
        return CHEMINDESTIMAGESDEST;
    }

    public static String getCHEMINSTOSOCKAGEDBSOURCE() {
        return CHEMINSTOSOCKAGEDBSOURCE;
    }




    
}    
