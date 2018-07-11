
package com.xerox.fidji.db;

import controleurs.SousControleurInterface;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;


public class UtilitaireCopieFichiers {

public static void copiefichiers( ){
    File sourcedir= new File(MesUtiliitairesDB.getCHEMINSTOSOCKAGEDBSOURCE());
    File dest = new File(MesUtiliitairesDB.getCHEMINDESTIMAGESDEST());
    
    try {
        FileUtils.copyDirectory(sourcedir, dest);
    } catch (IOException ex) {
        Logger.getLogger(UtilitaireCopieFichiers.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

public static void copiefichiers(String source ){
    File sourcedir= new File(source);
    File dest = new File(MesUtiliitairesDB.getCHEMINDESTIMAGESDEST());
    
    try {
        FileUtils.copyDirectory(sourcedir, dest);
    } catch (IOException ex) {
        Logger.getLogger(UtilitaireCopieFichiers.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

public static void copiefichiers(String source, String destination ){
    File sourcedir= new File(source);
    File dest = new File(destination);
    
    try {
        FileUtils.copyDirectory(sourcedir, dest);
    } catch (IOException ex) {
        Logger.getLogger(UtilitaireCopieFichiers.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

    
}
