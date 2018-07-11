
package controleurs;

//import com.xerox.fidji.beans.Actor;
import com.xerox.fidji.beans.Film;
import com.xerox.fidji.db.UtilitaireCopieFichiers;
import com.xerox.fidji.db.divers.InsertionActeurDAO;
import com.xerox.fidji.db.divers.InsertionFilmDAO;
//import com.xerox.fidji.db.divers.InsertionActeurDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class InsertionActeurFilm implements SousControleurInterface{

    private static final String mondossier = "MyImgbis";
    private static final String uploadFilePath= "H:\\MyUploadbis\\MyImg\\";
    
    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
    
        System.out.println("Je suis dans -----> "+InsertionActeurFilm.class.getName());
        
        System.out.println("applicationpath--->"+mondossier);
        
    
        Film unFilm = new Film();
        
        String title = "";
        String description = "";
        short release_year = 0;
        byte language_id=1;
        byte original_language_id=1;
        short length=0;
        float Price= 0f;
        String boxcover= "";
        int quantite= 0;
        String fileName="";
         String img="";
       String filmRegistered="";

    System.out.println("Film----->"+unFilm);
        
        
        
        title = request.getParameter("txttitle");
        description = request.getParameter("txtdescription");
        release_year = Short.parseShort(request.getParameter("txtrelease_year"));
        length = Short.parseShort(request.getParameter("txtlength"));
        Price = Float.parseFloat(request.getParameter("txtprice"));
        quantite = Integer.parseInt(request.getParameter("txtquantite"));
        
        
        
        File fileSaveDir = new File(mondossier);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdirs();
        }
        if(fileSaveDir.exists())
        {
            System.out.println("MyIMg "+mondossier+" a été crée");  
        }else{
            System.out.println("Dossier "+mondossier+" non crée");  
        }
        
      try {
            Part filePart = request.getPart("boxcover"); // Retrieves <input type="file" name="file">
            //fileName = filePart.getName();
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            
            img = "MyImg/"+fileName;
            System.out.println("Je recopie l'image dans le dossier "+ mondossier);          
            boxcover = img;
        unFilm.setTitle(title);
        unFilm.setDescription(description);
        unFilm.setRelease_year(release_year);
        unFilm.setLength(length);
        unFilm.setPrice(Price);
        unFilm.setQuantite(quantite);
        unFilm.setBoxcover(boxcover);
       
        System.out.println("Dans insertionfilm un film----> "+unFilm);
        InsertionActeurDAO insertionActeur = new InsertionActeurDAO();
          InsertionFilmDAO insertionFilm = new InsertionFilmDAO();
          
        filmRegistered = insertionFilm.InsertionUnFilm(unFilm);
            
            
            OutputStream os = new FileOutputStream(uploadFilePath+fileName);
            byte buf[]= new byte[1024];
            int len=0;
            while((len=fileContent.read(buf))>0){
             os.write(buf,0,len);
      }
                      
            
            
            
            request.setAttribute("fichierCharge", fileName);
            
            os.close();
            fileContent.close();
            
            /*for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(mondossier+ fileName);
            //fileContent.close();
        }*/
            
            
        } catch (IOException ex) {
            Logger.getLogger(InsertionActeurControleurActe2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(InsertionActeurControleurActe2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception exop){
            Logger.getLogger(InsertionActeurControleurActe2.class.getName()).log(Level.SEVERE, null, exop);
        }
        //SUCCESS
        if (filmRegistered.equals("SUCCESS")) {
            try{
            UtilitaireCopieFichiers.copiefichiers();
        }catch(Exception exop){
            exop.printStackTrace();
        }
            return "/WEB-INF/includs/InsertionFilmSuccess.jsp";
        } else {  //msgError
            request.setAttribute("msgError", filmRegistered);
            return "/WEB-INF/includs/MyErrors.jsp";
        }
    }
    
    
    
}
