
package controleurs;

import com.xerox.fidji.beans.BeanPanier;
import com.xerox.fidji.beans.Film;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingCartMVCControleur  implements SousControleurInterface{

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession uneSession  = request.getSession(false);
        BeanPanier unpanier;
        String msgError="";
        unpanier = (BeanPanier)uneSession.getAttribute("panier");
        //unPanier = (BeanPanier)unesession.getAttribute("panier");
        if(unpanier==null || unpanier.nombreEleements()==0|| unpanier.estvide()){
            msgError="Votre panier est vide";
            request.setAttribute("msgError", msgError);
            return "/WEB-INF/includs/lesfilms.jsp";
        }
        
        
        msgError = "Probleme de chargement de panier, "+ unpanier.nombreEleements()+" elements.";
        Collection boucle = unpanier.listerFilms();
        List<Film> lstfilmschoisis=null; 
        if(boucle!=null && !boucle.isEmpty()){
         lstfilmschoisis   = new ArrayList<Film>(boucle);
        Collections.sort(lstfilmschoisis);            
        uneSession.setAttribute("filmschoisis", lstfilmschoisis);
        Collection f = unpanier.listerFilms();
            Iterator it = f.iterator();
            
            /*while(it.hasNext()) {
               Film x=new Film();
               x = (Film)it.next();
                System.out.println("Dans ShoppingMVCControleur film--->"+ x);
            }*/
        
        
        return "/WEB-INF/includs/ShoppingCartMVC.jsp";
        }else{
            request.setAttribute("msgError", msgError );
            return "/WEB-INF/includs/MyErrors.jsp";
        }
        
        
        
        
    }
    
    
    
}
