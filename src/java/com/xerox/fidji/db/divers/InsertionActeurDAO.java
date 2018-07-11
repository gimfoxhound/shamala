
package com.xerox.fidji.db.divers;

import com.xerox.fidji.beans.Actor;
import com.xerox.fidji.db.GestionnaireDeConnexion;
import com.xerox.fidji.db.MesRequetes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertionActeurDAO {


public String InsertionUnActeur(Actor unActeur){
    
Connection con = null;
PreparedStatement psmt = null;

//INSERTIONACTEURS ="INSERT INTO actor (first_name,last_name,sex,Birthdate,size,Img,last_update) VALUES (?,?,?,?,?,?,?)";
String firstname = unActeur.getFirst_name();
String last_name = unActeur.getLast_name();
char sex = unActeur.getSex();
Date birthdate = unActeur.getBirthdate();
int taille = unActeur.getSize();
String img = unActeur.getImg();
Date last_update= unActeur.getLast_update();
 System.out.println("Acteur----->"+unActeur);



try{
    con = GestionnaireDeConnexion.getConnection();
    String query = MesRequetes.getINSERTIONACTEURS();
    psmt = con.prepareStatement(query);
    //INSERTIONACTEURS ="INSERT INTO actor (first_name,last_name,sex,Birthdate,size,Img,last_update) VALUES (?,?,?,?,?,?,?)";
    psmt.setString(1, firstname);
    psmt.setString(2, last_name);
    psmt.setString(3, String.valueOf(sex));
    psmt.setDate(4,birthdate );
    psmt.setInt(5, taille);
    psmt.setString(6, img);
    psmt.setDate(7, last_update);
    int i = psmt.executeUpdate();
    if(i!=0){
        return "SUCCESS";
    }
    
    
    
}catch(SQLException sqlexop){
    sqlexop.printStackTrace();
}
catch(Exception exop){
    exop.printStackTrace();
}

   return "Oops.. Something went wrong there..!";  // On failure, send a message from here. 
    
}

    
}
