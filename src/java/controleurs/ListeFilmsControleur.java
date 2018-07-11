
package controleurs;

import com.xerox.fidji.beans.Film;
import com.xerox.fidji.db.divers.ListFilmsDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ListeFilmsControleur implements SousControleurInterface{

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        String msgErrorfilms = "Probleme de recuperation des films";
        
        
        
            //ArrayList<Film> uneliste= new ArrayList<>();
            ListFilmsDao f= new ListFilmsDao();
            try {
            //uneliste = f.getListDesFilms();
            session.setAttribute("lisfilms", f.getListDesFilms());
         } catch (Exception ex) {
            Logger.getLogger(ListeFilmsControleur.class.getName()).log(Level.SEVERE, null, ex);
        }   
            // listlivres
             if(f.getListDesFilms()!=null && f.getListDesFilms().size()>0){
            return "/WEB-INF/includs/lesfilms.jsp";
             }else{
                 request.setAttribute("msgError", msgErrorfilms);
                 return "/WEB-INF/includs/MyErrors.jsp";
             }
        
        
    }
    
    
    
}
