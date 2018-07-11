
package controleurs;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.jboss.logging.Logger;

@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB
public class FrontControleur extends HttpServlet {

    
    
    private HashMap<String, SousControleurInterface>mp;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        mp = new HashMap<>();
        Enumeration<String> noms = config.getInitParameterNames();
        while(noms.hasMoreElements()){
            String section = noms.nextElement();
            String valeur = config.getInitParameter(section);
            try{
                SousControleurInterface sc = (SousControleurInterface)Class.forName(valeur).newInstance();
                mp.put(section, sc);
                System.out.println(section +" ------> "+valeur);
                
            }catch(InstantiationException | IllegalAccessException | ClassNotFoundException exop){
                Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, exop);
            }
              System.out.println(section +" -> "+valeur);
            
            
        }
        
        
        
        
        
        
    }
    
    
    
    
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("Je suis dans la servlet >>>>>>>>>"+ Class.forName(FrontControleur.class.getName()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session  = request.getSession();
        String section  = request.getParameter("section");
        String url= "/WEB-INF/home.jsp";
        if(mp.containsKey(section)){
            SousControleurInterface pc = mp.get(section);
            url = pc.executer(request, response);
        }
        if(!url.equals("noDispatcher")){
            url=response.encodeURL(url);
            System.out.println("l'url donne "+url.toString());
            getServletContext().getRequestDispatcher(url).include(request, response);
        }
        
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
