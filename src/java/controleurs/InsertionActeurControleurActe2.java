
package controleurs;

import com.xerox.fidji.beans.Actor;
import com.xerox.fidji.db.UtilitaireCopieFichiers;
import com.xerox.fidji.db.divers.InsertionActeurDAO;
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


public class InsertionActeurControleurActe2 implements SousControleurInterface{

    private static final String mondossier = "MyImgbis";
    private static final String uploadFilePath= "H:\\MyUploadbis\\MyImg\\";
    
    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
     
    
    
        System.out.println("applicationpath--->"+mondossier);
        
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
        String fileName="";
        String userRegistered="";
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp datecourrante = new java.sql.Timestamp(calendar.getTime().getTime());
        
        
        
        firstname = request.getParameter("txtfirstname");
        last_name = request.getParameter("txtlastname");
        theSex= request.getParameter("txtsex");
        System.out.println("sex---->"+theSex);
        if(!theSex.equals("") && theSex!=null)
        sex= theSex.charAt(0) ;
        System.out.println("Firstname---> "+firstname +", lastname --->"+last_name);
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
                                             //txtlast_update
        DerniereUpdate = request.getParameter("txtlast_update");
        if(DerniereUpdate.equals("") || DerniereUpdate==null){
            
            
          DerniereUpdate= datecourrante.toString();
    }
        java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        last_update = today;
        //img = "MyImg/"+request.getParameter("txfile");
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
        System.out.println("unacteur firstname---> "+firstname);
      try {
            Part filePart = request.getPart("txfile"); // Retrieves <input type="file" name="file">
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            
            img = "MyImg/"+fileName;
            System.out.println("Je recopie l'image dans le dossier "+ mondossier);          
            
        unActeur.setFirst_name(firstname);
        unActeur.setLast_name(last_name);
        unActeur.setSex(sex);
        unActeur.setBirthdate(birthdate);
        unActeur.setSize(taille);
        unActeur.setImg(img);
        unActeur.setLast_update(last_update);
        
        
        System.out.println("Dans insertionacteurcontroleur un acteur----> "+unActeur+ ", mensuration : "  +mensuration);
        InsertionActeurDAO insertionActeur = new InsertionActeurDAO();
        userRegistered = insertionActeur.InsertionUnActeur(unActeur);
            
            
            
            OutputStream os = new FileOutputStream(uploadFilePath+fileName);
            byte buf[] = new byte[1024];
            int len=0;
            while((len = fileContent.read(buf))>0){
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
        if (userRegistered.equals("SUCCESS")) {
            try{
            UtilitaireCopieFichiers.copiefichiers();
        }catch(Exception exop){
            exop.printStackTrace();
        }
            return "/WEB-INF/includs/InsertionActSuccess.jsp";
        } else {
            request.setAttribute("msgError", userRegistered);
            return "/WEB-INF/includs/MyErrors.jsp";
        }
    }
    
    
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
    
}
