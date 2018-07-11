
package controleurs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.FSEntityResolver;
import org.xml.sax.SAXException;
//import org.x
//import myit


public class PDFControleur implements SousControleurInterface{

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response)  {
       
        String msgError="";
        String msgSuccess="";
        String msgException="";
        String action= request.getParameter("action");
        System.out.println("Action vaut ----> "+action);
        
        
        if(action.equals("genPDF")){
        OutputStream os= null;
        try {
            response.setHeader("Cache-Control", "no-cache");
            String html= request.getParameter("html");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + "MyPDFMoustac\"" );
            response.setHeader("Cache-Control", "no-cache");
            os = response.getOutputStream();
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(true);
            DocumentBuilder builder;
            builder = documentBuilderFactory.newDocumentBuilder();
            builder.setEntityResolver(FSEntityResolver.instance());
            org.w3c.dom.Document document;
            document = builder.parse(new ByteArrayInputStream(html.getBytes()));
            ITextRenderer itxtrenderer = new ITextRenderer();
            itxtrenderer.setDocument(document, null);
            itxtrenderer.layout();
            itxtrenderer.createPDF(os, true);//At this step generation pdf
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(PDFControleur.class.getName()).log(Level.SEVERE, null, ex);
            msgException+=ex.getMessage();
        }catch(ParserConfigurationException pce){
            msgException+=pce.getMessage();
        pce.printStackTrace();
        } catch(SAXException sae){
            msgException+=sae.getMessage();
            sae.printStackTrace();
        }
        catch(Exception exop){
            msgException+=exop.getMessage();
            exop.printStackTrace();
        }
        
        finally {
            try {
                os.flush();
                os.close();
                msgError=  "Probleme de generation du fichier pdf";
                request.setAttribute("msgError", msgError);
                
                return "/WEB-INF/includs/MyErrors.jsp";
            } catch (IOException ex) {
                Logger.getLogger(PDFControleur.class.getName()).log(Level.SEVERE, null, ex);
                msgException+=ex.getMessage();
            }
        }
        msgSuccess="PDF généré!";
        request.setAttribute("succes", msgSuccess);
        
        return "/WEB-INF/includs/PDFCreatedSucess.jsp";
        }else{
            
                msgError=  "Pas de facture à générer en pdf!";
                request.setAttribute("msgError", msgError);
                request.setAttribute("msgException", msgException);
                return "/WEB-INF/includs/MyErrors.jsp";
        }
    }

    

    
}
