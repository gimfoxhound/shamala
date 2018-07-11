
package com.xerox.fidji.db;


public class MesRequetes {
private static final String RECHERCHEUSER ="select * from users where username = ? and password =?";
private static final String RECHERCHETOUSLESFILMS="select * from film where BoxCover is not null";
private static final String RECHERCHETOUSLESACTEURS="select * from actors";
private static final String INSERTIONACTEURS ="INSERT INTO actor (first_name,last_name,sex,Birthdate,size,Img,last_update) VALUES (?,?,?,?,?,?,?)";
private static final String LISTEACTEURSAVECPHOTOS="select * from actor where Img is not null";
private static final String INSERTIONFILMS="INSERT INTO film (title ,description, release_year, language_id, original_language_id, length, Price, BoxCover, quantity) VALUES (?,?,?,?,?,?,?,?,?);";

    public static String getRECHERCHEUSER() {
        return RECHERCHEUSER;
    }

    public static String getRECHERCHETOUSLESFILMS() {
        return RECHERCHETOUSLESFILMS;
    }

    public static String getRECHERCHETOUSLESACTEURS() {
        return RECHERCHETOUSLESACTEURS;
    }

    public static String getINSERTIONACTEURS() {
        return INSERTIONACTEURS;
    }

    public static String getLISTEACTEURSAVECPHOTOS() {
        return LISTEACTEURSAVECPHOTOS;
    }

    public static String getINSERTIONFILMS() {
        return INSERTIONFILMS;
    }
   
    
    
}



