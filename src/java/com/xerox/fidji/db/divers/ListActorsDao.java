
package com.xerox.fidji.db.divers;

import com.xerox.fidji.beans.Actor;
import com.xerox.fidji.db.GestionnaireDeConnexion;
import com.xerox.fidji.db.MesRequetes;
import static com.xerox.fidji.db.divers.ActorDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ListActorsDao {

public ArrayList<Actor> getListActeurs(){
    ArrayList<Actor> lst = new ArrayList<Actor>();
    Connection con;
    String img="";
    try{
        con = GestionnaireDeConnexion.getConnection();
        PreparedStatement psmt = con.prepareStatement(MesRequetes.getLISTEACTEURSAVECPHOTOS());
        ResultSet rs = psmt.executeQuery();
        Actor unacteur = null;
        while(rs.next()){
            unacteur = new Actor();

            String firstname = rs.getString("first_name");
            String lastname = rs.getString("last_name");
            java.sql.Date lastupdate= rs.getDate("last_update");                        
            img = "tests/"+rs.getString("Img");                        
            java.sql.Date datenaissance = rs.getDate("Birthdate");
            String sex = rs.getString("sex");
            int taille = rs.getInt("size");
            String surnom = rs.getString("nickname");
            String uneremarque = rs.getString("remarque");            
            boolean actif= rs.getBoolean("isactif");            
            int poids = rs.getInt("poids");
            
            
            
            unacteur.setFirst_name(firstname);
            unacteur.setLast_name(lastname);
            unacteur.setLast_update(lastupdate);
            unacteur.setImg(img);
            unacteur.setBirthdate(datenaissance);
            unacteur.setSex(sex.charAt(0));
            unacteur.setSize(taille);
            unacteur.setNickname(surnom);
            unacteur.setRemarque(uneremarque);
            unacteur.setIsactive(actif);
            unacteur.setPoids(poids);
            System.out.println("L'acteur insere est >>>>>>>>>>"+unacteur);
            lst.add(unacteur);
            
            
        }
        
        
    }catch(SQLException sqlexop){
        sqlexop.printStackTrace();
    }
    catch(Exception exop){
        exop.printStackTrace();
    }
    return lst;
}


    
}
