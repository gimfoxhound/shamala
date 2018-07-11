
package com.xerox.fidji.beans;

import com.xerox.fidji.db.UtilitaireCopieFichiers;


public class TestCopies {

public static void main(String [] args){
    
    String source ="H:\\MyUploadbis";
    String dest= "H:\\Tests";
    try{
        UtilitaireCopieFichiers.copiefichiers(source, dest);
    }catch(Exception exop){
        exop.printStackTrace();
    }
    
}

    
}
