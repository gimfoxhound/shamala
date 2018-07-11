
package com.xerox.fidji.db.divers;

import com.xerox.fidji.beans.Login;
import com.xerox.fidji.db.GestionnaireDeConnexion;
import com.xerox.fidji.db.MesRequetes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDAO {

static Connection currentCon=null;
static ResultSet rs=null;

public static Login seLoguer(Login bean) throws IOException{
    PreparedStatement psmt = null;
    boolean append = true;
    FileHandler handler = new FileHandler("h:\\logs\\UserDAOTrace.log", append);
    Logger logger = Logger.getLogger("logs");
    logger.addHandler(handler);
    
    String username = bean.getUsername();
    String password = bean.getPassworth();
    String rechercheUser= MesRequetes.getRECHERCHEUSER();
    System.out.println("Your username is : " +bean.getUsername());
    System.out.println("your passworth is : "+ bean.getPassworth());
    System.out.println("la requete est ----> "+rechercheUser);
    
    logger.info(bean.getUsername()+ ", "+bean.getPassworth());
    try{
        try{
            currentCon = GestionnaireDeConnexion.getConnection();
        }catch(Exception exop){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, exop);
        }
        psmt = currentCon.prepareStatement(rechercheUser);
        psmt.setString(1, username);
        psmt.setString(2, password);
        rs= psmt.executeQuery();
        boolean encore= rs.next();
        
        if(!encore){
            System.out.println("Cet utilisateur et ce mot de passe "+bean+" n'existe pas dans la db. ");
            logger.severe("Cet utilisateur et ce mot de passe "+bean+" n'existe pas dans la db. ");
            bean.setValide(false);
        }else{
              String identifiant = rs.getString("username");
              String motdepasse = rs.getString("password");
              String fullname = rs.getString("fullname");
              String email = rs.getString("email");
              String prenom= rs.getString("prenom");
              String nom = rs.getString("nom");
              String adresse = rs.getString("adresse");
              String ville = rs.getString("ville");
              String role = rs.getString("role");
              
              System.out.println("Bienvenu --->" +identifiant);
              logger.fine("Bienvenu --->"+identifiant);
              bean.setUsername(identifiant);
              bean.setPassworth(password);
              bean.setEmail(email);
              bean.setPrenom(prenom);
              bean.setNom(nom);
              bean.setAdresse(adresse);
              bean.setVille(ville);
              bean.setRole(role);
              bean.setValide(true);
        }
    }catch(SQLException sqlexop){
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null ,sqlexop);
        logger.severe(UserDAO.class.getName()+", ----> "+sqlexop.getMessage());
    }finally{
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException sqlexop) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqlexop);
                logger.severe("Attention! le Resultset ne se ferme pas "+sqlexop.getMessage());
            }
            rs=null;
        }
        
        if(psmt!=null){
                try {
                    psmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                    logger.severe("Le PreparedStatement ne se ferme pas. "+ ex.getMessage());
                }
                psmt=null;
            }
            if(currentCon!=null){
                
                try {
                    currentCon.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                    logger.severe("La connexion à la DB ne s'est pas fermée");
                }
                currentCon=null;
            }
        }
        if(!bean.isValide()){
            logger.warning("L'utilisateur et le mot de passe sont inconnus dans la db "+bean);
            return null;
        }else{
            
            logger.fine("L'utilisateur et le password sont bons --->"+bean);
            return bean;
        }
        
        
}

public static Login seLoguer(String username, String password) throws IOException{
    PreparedStatement psmt = null;
    boolean append = true;
    FileHandler handler = new FileHandler("h:\\logs\\UserDAOTrace.log", append);
    Logger logger = Logger.getLogger("logs");
    logger.addHandler(handler);
    Login bean = new Login(username, password);
    
    String rechercheUser= MesRequetes.getRECHERCHEUSER();
    
    System.out.println("la requete est ----> "+rechercheUser);
    
    logger.info(username+ ", "+password);
    try{
        try{
            currentCon = GestionnaireDeConnexion.getConnection();
        }catch(Exception exop){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, exop);
        }
        psmt = currentCon.prepareStatement(rechercheUser);
        psmt.setString(1, username);
        psmt.setString(2, password);
        
        
        
        rs= psmt.executeQuery();
        boolean encore= rs.next();
        
        if(!encore){
            System.out.println("Cet utilisateur et ce mot de passe n'existe pas dans la db. "+username+", "+password);
            logger.severe("Cet utilisateur et ce mot de passe n'existe pas dans la db. "+username+", "+password);
            
            bean.setValide(false);
        }else{
              String identifiant = rs.getString("username");
              String motdepasse = rs.getString("password");
              String fullname = rs.getString("fullname");
              
              String prenom= rs.getString("prenom");
              String nom = rs.getString("nom");
              String adresse = rs.getString("adresse");
              String ville = rs.getString("ville");
              String role = rs.getString("role");
              
             
              System.out.println("Bienvenu --->" +identifiant);
              logger.fine("Bienvenu --->"+identifiant);
              bean.setUsername(identifiant);
              bean.setPassworth(password);
              bean.setValide(true);
              bean.setPrenom(prenom);
              bean.setNom(nom);
              bean.setAdresse(adresse);
              bean.setVille(ville);
              bean.setRole(role);
        }
    }catch(SQLException sqlexop){
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null ,sqlexop);
        logger.severe(UserDAO.class.getName()+", ----> "+sqlexop.getMessage());
    }finally{
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException sqlexop) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqlexop);
                logger.severe("Attention! le Resultset ne se ferme pas "+sqlexop.getMessage());
            }
            rs=null;
        }
        
        if(psmt!=null){
                try {
                    psmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                    logger.severe("Le PreparedStatement ne se ferme pas. "+ ex.getMessage());
                }
                psmt=null;
            }
            if(currentCon!=null){
                
                try {
                    currentCon.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                    logger.severe("La connexion à la DB ne s'est pas fermée");
                }
                currentCon=null;
            }
        }
        if(!bean.isValide()){
            logger.warning("L'utilisateur et le mot de passe sont inconnus dans la db "+bean);
            return null;
        }else{
            
            logger.fine("L'utilisateur et le password sont bons --->"+bean);
            return bean;
        }
        
        
}






}
