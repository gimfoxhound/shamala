
package com.xerox.fidji.db.divers;

import com.xerox.fidji.beans.Film;
import com.xerox.fidji.db.GestionnaireDeConnexion;
import com.xerox.fidji.db.MesRequetes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class InsertionFilmDAO {

    public String InsertionUnFilm(Film unFilm){
        

Connection con = null;
PreparedStatement psmt = null;


String title = unFilm.getTitle();
String description = unFilm.getDescription();
short release_year = unFilm.getRelease_year();
byte language_id=1;
byte original_language_id=1;
short length=unFilm.getLength();
float Price= unFilm.getPrice();
String boxcover= unFilm.getBoxcover();
int quantite= unFilm.getQuantite();

System.out.println("Film----->"+unFilm);
        System.out.println("Boxcover---->"+ boxcover);

try{
    con = GestionnaireDeConnexion.getConnection();
    String query = MesRequetes.getINSERTIONFILMS();
    psmt = con.prepareStatement(query);
    //INSERT INTO film (title,description,release_year,language_id,original_language_id,length,Price,BoxCover,quantity) 
//                 VALUES (?,?, ?, 1,1,?, ?, ?,?);
    psmt.setString(1, title);
    psmt.setString(2, description);
    psmt.setInt(3, release_year);
    psmt.setInt(4,language_id);
    psmt.setInt(5,original_language_id);
    psmt.setInt(6, length);
    psmt.setFloat(7, Price);
    psmt.setString(8, boxcover);
    psmt.setInt(9,quantite);
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
