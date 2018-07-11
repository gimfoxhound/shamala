
package controleurs;

import com.xerox.fidji.beans.Login;
import com.xerox.fidji.db.divers.UserDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ConnectionControleur implements SousControleurInterface{

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        String unMessage="";
        Login lg= new Login();
        System.out.println("Avant le Try Catch ---> "+ ConnectionControleur.class.getName());
        HttpSession unesession = request.getSession();
        String username = request.getParameter("txtusername");
        String password = request.getParameter("txtmotdepasse");
        System.out.println("username----->" +username);
        System.out.println("password----->" +password);
          
            if(username!=null && password!=null ){
                
                lg.setUsername(username);
                lg.setPassworth(password);
                System.out.println("Dans le try catch ---> "+ ConnectionControleur.class.getName());
            }
            
        try{
            lg=UserDAO.seLoguer(lg);
        }catch (IOException ex) {
           Logger.getLogger(ConnectionControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
             if(lg!=null)
             unesession.setAttribute("usr", lg);
             unMessage="connecté!";
             
         
         
         
          if(lg ==null){
             unMessage="erreur d'identification";
             request.setAttribute("msgError",unMessage );
           return "/WEB-INF/includs/MyErrors.jsp";
          }
         unesession.setAttribute("unmessage",unMessage);
         return "/WEB-INF/includs/successlogin.jsp";
         //  } catch (IOException ex) {
           // Logger.getLogger(ConnectionControleur.class.getName()).log(Level.SEVERE, null, ex);
        //}
        
         
         
         
    }

    
    
}
