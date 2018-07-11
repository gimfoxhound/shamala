
package com.xerox.fidji.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TestAjouter {

public static void main(String[] args){
    Film film1 = new Film("Crystal Dawn dksd", "Film US");
    film1.setQuantite(1);
    Film film2 = new Film("La Comtesse est.. ", "Fim Français");
    Film film3 = new Film("Analia", "Deutsch");
    film2.setQuantite(1);
    film1.setPrice(12);
    film2.setPrice(13);
    film3.setQuantite(1);
    film3.setPrice(15);
    
    BeanPanier unpanier = new BeanPanier();
    unpanier.ajouterfilm(film1, 1);
    unpanier.ajouterfilm(film2, 1);
    unpanier.ajouterfilm(film3, 1);
    
    Collection s=  unpanier.listerFilms();
    
     List<Film> lstfilmschoisis= new ArrayList<Film>(s);
     System.out.println("Ecriture du Bean Panier");
    listefilm(lstfilmschoisis);
         
         
}
private static void listefilm(List<Film> lst){
    for(int j=0;j<lst.size();j++){
        System.out.println(lst.get(j));
    }
}



    
}
