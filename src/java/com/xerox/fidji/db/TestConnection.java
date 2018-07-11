
package com.xerox.fidji.db;





import com.xerox.fidji.beans.Login;
import com.xerox.fidji.beans.User;
import com.xerox.fidji.db.divers.UserDAO;
import java.io.IOException;


public class TestConnection {

    public static void main(String[] args) throws IOException {
        String username="root";
        String motdepasse="0123456789";
                         
        Login lg = new Login(username, motdepasse);
        User usr=null;
        /*Login lg1 = new Login();
         lg1=  UserDAO.seLoguer(lg);
         System.out.println("Le user------->" +lg1);*/
        usr=authentification("root", "0123456789");
        if(usr!=null){
        System.out.println("le user c'est ---->" +usr);
        }else{
            System.out.println("Le user "+username+ " ou le motdepasse "+motdepasse+" sont inconnus dans la db"); 
        }
    }
    public static User authentification(String identifiant, String motdepasse) throws IOException{
        
        ///if(username!=null){
        Login lg = new Login(identifiant, motdepasse);
        //Login lg1 = new Login();        
         lg=  UserDAO.seLoguer(lg);
       if(lg!=null){
         System.out.println("Le user------->" +lg);
        return new User(identifiant);                    
        }else{
            return null;
        }    
    }
    
    
}
