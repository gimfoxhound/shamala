
package controleurs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout implements SousControleurInterface{

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession unesession = request.getSession(false);
        if(unesession!=null){
            
            unesession.removeAttribute("usr");
            unesession.setMaxInactiveInterval(1);
            unesession.invalidate();
            System.out.println("Session invalidée!");
            request.setAttribute("LogoutMessage", "You have log out successfully");
            response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expire", -1);
            //RequestDispatcher requestDispatcher = request.getRequestDispatcher(path)
        }
        return "/WEB-INF/home.jsp";
        
    }

    
    
}
