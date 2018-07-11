
package com.xerox.fidji.db.divers;

import com.xerox.fidji.beans.Film;
import com.xerox.fidji.db.GestionnaireDeConnexion;
import com.xerox.fidji.db.MesRequetes;
//import static com.xerox.fidji.db.divers.FilmDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ListFilmsDao {
    
    
   public ArrayList<Film> getListDesFilms(){
   ArrayList<Film> lst = new ArrayList<Film>();
   Connection con; 
   try{
     con =GestionnaireDeConnexion.getConnection();
       PreparedStatement psmt = con.prepareStatement(MesRequetes.getRECHERCHETOUSLESFILMS());
       ResultSet rs = psmt.executeQuery();
       Film unfilm=null;
       while(rs.next()){
           //select title, description, price from film
           unfilm = new Film();
           String title = rs.getString("title");
           String description = rs.getString("description");
           long prix = rs.getInt("price");
           String boxcover = "tests/"+rs.getString("BoxCover");
           int quantite = rs.getInt("quantity");
           int film_id=  rs.getInt("film_id");
           
           unfilm.setTitle(title);
           unfilm.setDescription(description);
           unfilm.setPrice(prix);
           //Rajout ici de set quantité
           unfilm.setQuantite(quantite);
           unfilm.setBoxcover(boxcover);  
           unfilm.setFilm_id(film_id);
           lst.add(unfilm);
           
       }
       
   }catch(Exception exop){
       exop.printStackTrace();
   }
  
    
   return lst;
} 
}
