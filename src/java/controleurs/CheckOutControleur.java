
package controleurs;

import com.xerox.fidji.beans.BeanPanier;
import com.xerox.fidji.beans.Film;
import com.xerox.fidji.beans.User;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckOutControleur implements SousControleurInterface{

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        
        User user = new User();
        ArrayList<Film> lstfilms = new ArrayList<>();
        BeanPanier unPanier = new BeanPanier();
        String msgError ="";
        HttpSession unesession = request.getSession(false);
        if(user==null){
            msgError="Vous n'etes pas loggué";
            request.setAttribute("msgError", msgError);
            return "/WEB-INF/includs/MyErrors.jsp";
        }
        
        if(unesession ==null){
            msgError="Votre panier est vide!";
            request.setAttribute("msgError", msgError);
            return "/WEB-INF/includs/MyErrors.jsp";
        }
        unPanier = (BeanPanier)unesession.getAttribute("panier");
        if(unPanier==null || unPanier.nombreEleements()==0){
            msgError="Votre panier est vide";
            request.setAttribute("msgError", msgError);
            return "/WEB-INF/includs/MyErrors.jsp";
        }
        
        if(user!=null && unesession!=null){
            if(unPanier!=null && !unPanier.estvide()){
            return "/WEB-INF/includs/CheckoutMVC.jsp";        
            }
        }
        return "/WEB-INF/includs/lesfilms.jsp";
        
    }
    
    
}
