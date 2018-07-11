
package controleurs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertActeurPage implements SousControleurInterface{

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
      
        return "/WEB-INF/includs/insertActeur.jsp";
    }
    
    
    
}
