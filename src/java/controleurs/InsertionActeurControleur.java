package controleurs;

//import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
//import com.oreilly.servlet.MultipartRequest;
import com.xerox.fidji.beans.Actor;
import com.xerox.fidji.db.divers.InsertionActeurDAO;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@MultipartConfig
public class InsertionActeurControleur implements SousControleurInterface {
    private final String UPLOAD_DIRECTORY = "MyImg/";

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
    String mondossier = "H:\\Travail\\MyPetstore\\IntroMVC2-V04\\web\\MyImg\\"; 
        Actor unActeur = new Actor();
        String name ="";
        String firstname="";
        String last_name="";
        String theSex="";
        String datenaissance="";
        char sex='I';
        Date birthdate=null;
        String mensuration="";
        int taille =0;
        String img="";
        Date last_update=null;
        String DerniereUpdate="";
        try {
        //MultipartRequest m = new MultipartRequest(request,mondossier);
        
                                              // txtfirsname    
         firstname = request.getParameter("txtfirstname");
         last_name = request.getParameter("txtlastname");
         theSex= request.getParameter("txtsex");
         sex= theSex.charAt(0) ;
        
        datenaissance = request.getParameter("txtbirthdate");
        
        if(!datenaissance.equals("") || datenaissance!=null){
        birthdate = Date.valueOf(datenaissance);
        }else{
            birthdate=Date.valueOf("1900-01-01");
        }
        //birthdate=Date.valueOf("1900-01-01");
        mensuration = request.getParameter("txttaille");
        
        if(mensuration!=null)
        taille = Integer.parseInt(mensuration);
         img = "MyImg/"+request.getParameter("txtimg");
        DerniereUpdate = request.getParameter("txtlast_update");
        if(DerniereUpdate.equals("") || DerniereUpdate==null)
          DerniereUpdate="1900-01-01" ;
        
        last_update = Date.valueOf(DerniereUpdate);
        } catch (Exception ex) {
            Logger.getLogger(InsertionActeurControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//MyImg/Crystal_Dawn_F_Box.jpg

      




         System.out.println("unacteur firstname---> "+firstname);

        unActeur.setFirst_name(firstname);
        unActeur.setLast_name(last_name);
        unActeur.setSex(sex);
        unActeur.setBirthdate(birthdate);
        unActeur.setSize(taille);
        unActeur.setImg(name);
        
        
        System.out.println("Dans insertionacteurcontroleur un acteur----> "+unActeur+ ", mensuration : "  +mensuration);

        InsertionActeurDAO insertionActeur = new InsertionActeurDAO();

        String userRegistered = insertionActeur.InsertionUnActeur(unActeur);
        //SUCCESS
        
        //process only if its multipart content
       /* if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                    new DiskFileItemFactory()).parseRequest(request);
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                       name = new File(item.getName()).getName();
                       item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception exop) {
               exop.printStackTrace();
            }

        }*/
        
       /*
       String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
       Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
       String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
    InputStream fileContent = filePart.getInputStream();
       
       */
       
        
        if (userRegistered.equals("SUCCESS")) {
            return "/WEB-INF/includs/InsertionActSuccess.jsp";
        } else {
            request.setAttribute("msgError", userRegistered);
            return "/WEB-INF/includs/MyErrors.jsp";
        }
    }
    
    
    

        
        
        
    
    
 
    

}
