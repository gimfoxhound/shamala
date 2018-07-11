
package controleurs;

import com.xerox.fidji.db.divers.ListActorsDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ListeActorAvecPhotosControleur implements SousControleurInterface{

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        HttpSession unesession = request.getSession(false);
        String msgErroracteurs = "Probleme de recuperation acteur";
        ListActorsDao listdesacteursavecphotos = new ListActorsDao();
        try{
            unesession.setAttribute("lstactorssphotos", listdesacteursavecphotos.getListActeurs() );
        }catch(Exception exop){
            exop.printStackTrace();
            Logger.getLogger(ListeFilmsControleur.class.getName()).log(Level.SEVERE, null, exop);
        }
        if(listdesacteursavecphotos.getListActeurs()!=null && listdesacteursavecphotos.getListActeurs().size()>0){
            return "/WEB-INF/includs/lesacteurssphotos.jsp"; //"/WEB-INF/includs/lesfilms.jsp"
        }else{
            request.setAttribute("msgError", msgErroracteurs);
            return "/WEB-INF/includs/MyErrors.jsp"; ///WEB-INF/includs/ErrorLogin.jsp
        }
        
    }

    


    
}
