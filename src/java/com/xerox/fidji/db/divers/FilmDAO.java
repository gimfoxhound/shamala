
package com.xerox.fidji.db.divers;

//import com.xerox.fidji.beans.Login;
import com.xerox.fidji.beans.Film;
import com.xerox.fidji.db.GestionnaireDeConnexion;
import com.xerox.fidji.db.MesRequetes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FilmDAO {


static Connection currentCon=null;
static ResultSet rs=null;

public static ArrayList<Film> listFilms() throws IOException{
    PreparedStatement psmt = null;
    boolean append = true;
    FileHandler handler = new FileHandler("h:\\logs\\FilmDAOTrace.log", append);
    Logger logger = Logger.getLogger("logs");
    logger.addHandler(handler);
    ArrayList<Film> listfilms = new ArrayList<Film>();
    Film unfilm=null;
    
    String rechercheTouslesFilms= MesRequetes.getRECHERCHETOUSLESFILMS();    
    System.out.println("la requete est ----> "+rechercheTouslesFilms);
    
    logger.info( "Nous Procedons à la recherche des films ");
    try{
        try{
            currentCon = GestionnaireDeConnexion.getConnection();
        }catch(Exception exop){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, exop);
        }
        psmt = currentCon.prepareStatement(rechercheTouslesFilms);
        /*psmt.setString(1, username);
        psmt.setString(2, password);*/
        rs= psmt.executeQuery();
        boolean encore= rs.next();
        
        if(!encore){
            System.out.println("liste des films vide. ");
            logger.info("liste des films vide.");
            //bean.setValide(false);
        }else{
            while(encore){
              unfilm = new Film();
              String titre = rs.getString("title");
              String description = rs.getString("description");
              float prix = rs.getFloat("Price");
              String boxcover = rs.getString("BoxCover");
              int quantite = rs.getInt("quantity");
                     

              unfilm.setTitle(titre);
              unfilm.setDescription(description);
              unfilm.setPrice(prix);
              unfilm.setBoxcover(boxcover);
              unfilm.setQuantite(quantite);
              
              
              logger.fine("film enregistré --->"+unfilm);
              listfilms.add(unfilm);
            }
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
        if(listfilms.isEmpty()){
            logger.warning("Attention liste vide "+listfilms);
            return null;
        }else{
            
            logger.fine("La liste de film de films est recupérée et contient  --->"+listfilms.size()+" titres de films");
            return listfilms;
        }

}
}
