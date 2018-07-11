
package com.xerox.fidji.db.divers;

import com.xerox.fidji.beans.Actor;
import com.xerox.fidji.db.GestionnaireDeConnexion;
import com.xerox.fidji.db.MesRequetes;
import com.xerox.fidji.db.MesUtiliitairesDB;
//import static com.xerox.fidji.db.divers.FilmDAO.rs;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.jboss.logging.Logger;


public class ActorDAO {
  
static Connection currentCon=null;
static ResultSet rs=null;
public static ArrayList<Actor> listActors() throws IOException{
    
    PreparedStatement psmt= null;
    boolean append = true;
    FileHandler handler = new FileHandler(MesUtiliitairesDB.getCHEMINLOGSACTORDAO(),append);
    Logger logger = Logger.getLogger("logs");
    logger.addHandler(handler);
    ArrayList<Actor> listactors = new ArrayList<Actor>();
    Actor unacteur =null;
    
    String rechercheActeursPhotos = MesRequetes.getLISTEACTEURSAVECPHOTOS();
    System.out.println("La requete de recherche des acteurs avec photoos est : "+rechercheActeursPhotos);
    logger.info("Nous procédons à la recherche des acteurs");
   try{ 
    try{
        currentCon = GestionnaireDeConnexion.getConnection();
        
    }catch(Exception exop){
        Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, exop);
    }
    psmt = currentCon.prepareStatement(rechercheActeursPhotos);
    rs= psmt.executeQuery();
    boolean encore=rs.next();
    if(!encore){
        System.out.println("Liste d'acteurs vide");
        logger.info("Liste des acteurs vide");
    }else{
        while(encore){
            unacteur = new Actor();
            String firstname = rs.getString("first_name");
            String lastname = rs.getString("last_name");
            java.sql.Date lastupdate= rs.getDate("last_update");            
            String img = rs.getString("Img");                        
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
            
            logger.fine("Acteur enregistre "+ unacteur);
            
            
                    
        }
    }
    
    
   }catch(SQLException sqlexop){
    Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE,null, sqlexop);
   }finally{
       if(rs!=null){
            try {
                rs.close();
            } catch (SQLException sqlexop) {
                Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, sqlexop);
                logger.severe("Attention! le Resultset ne se ferme pas "+sqlexop.getMessage());
            }
            rs=null;
        }
        
        if(psmt!=null){
                try {
                    psmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
                    logger.severe("Le PreparedStatement ne se ferme pas. "+ ex.getMessage());
                }
                psmt=null;
            }
            if(currentCon!=null){
                
                try {
                    currentCon.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
                    logger.severe("La connexion à la DB ne s'est pas fermée");
                }
                currentCon=null;
            }
   }
   if(listactors.isEmpty()){
       logger.warning("Attention liste vide "+listactors);
       return null;
   }else{
       logger.fine("La liste des acteurs est retournée et contient "+listactors.size()+" elements");
       return listactors;
   }
    
    
    
}
        



    
}
