
package controleurs;

import com.xerox.fidji.beans.BeanPanier;
import com.xerox.fidji.beans.Film;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShopController1 implements SousControleurInterface{

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        
        String action = request.getParameter("action");
        HttpSession unesession = request.getSession();
        BeanPanier unpanier;
        int nbelementsdanspanier =0;
        float prixdelacommande =0.0f;
        unpanier = (BeanPanier)unesession.getAttribute("panier");
        Film unfilm;
        if(unpanier==null){
            unpanier= new BeanPanier();
            unesession.setAttribute("panier", unpanier);
            
        }
        if(action.equals("add")){
            unfilm = new Film();
            String titre = request.getParameter("modelNo");
            String description= request.getParameter("description");                                                                                                
            String quantite= request.getParameter("quantity");
            String prix = request.getParameter("price");
            String coverbox= request.getParameter("boxcover");
            unfilm.setTitle(titre);
            unfilm.setDescription(description);
            unfilm.setQuantite(Integer.parseInt(quantite));
            unfilm.setPrice(Float.parseFloat(prix));
            unfilm.setBoxcover(coverbox);
            System.out.println("le film ajouté au panier est >>>>>>>" +unfilm+" et quantite "+ unfilm.getQuantite()+" prix "+unfilm.getPrice());
            unpanier.ajouterfilm(unfilm, 1);
            //System.out.println("unPanier --->"+ unpanier);
            nbelementsdanspanier = unpanier.nombreEleements();
            unesession.setAttribute("nbelementdanspanier", nbelementsdanspanier);
            prixdelacommande = unpanier.totalHT();
            unesession.setAttribute("prixdelacommande", prixdelacommande);
            
            System.out.println("Dans ShopController le panier contient >>>>>>>>>>>>>>>>>>>>");
            Collection f = unpanier.listerFilms();
            Iterator it = f.iterator();
            
            while(it.hasNext()) {
               Film x=new Film();
               x = (Film)it.next();
                System.out.println("film--->"+ x);
            }
        }
        if(action.equals("remove")){
         String titre = request.getParameter("modelNo");
         unpanier.enlever(titre, 1);
         nbelementsdanspanier = unpanier.nombreEleements();
         unesession.setAttribute("nbelementdanspanier", nbelementsdanspanier);
         prixdelacommande = unpanier.totalHT();
         unesession.setAttribute("prixdelacommande", prixdelacommande);
         return "/WEB-INF/includs/ShoppingCartMVC.jsp";
         
        }
        
        return "/WEB-INF/includs/lesfilms.jsp";
    }
    
    
}
