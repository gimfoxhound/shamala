package com.xerox.fidji.beans;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class BeanPanier {

    HashMap<String, Film> map;

    public BeanPanier() {
        map = new HashMap();
    }

    public void ajouter(String titre) {
        ajouter(titre, 1);
    }

    public void ajouter(String titre, int qte) {
        if (map.containsKey(titre)) {
            Film unfilm = map.get(titre);
            unfilm.delta(qte);
            if (unfilm.getQuantite() < 1) 
                supprimer(titre);
        } else {
                map.put(titre, new Film(titre, qte));
            }
    }
    public void ajouterfilm(Film unfilm, int qte) {   //La methode qui marche pas mal
        if (map.containsKey(unfilm.getTitle() )) {
            unfilm = map.get(unfilm.getTitle());
            unfilm.delta(qte); 
            if (unfilm.getQuantite() < 1) 
                supprimer(unfilm.getTitle());
            } else {
                unfilm.setQuantite(qte);
                map.put(unfilm.getTitle(), unfilm);
            }
            System.out.println("Un film dans le panier ------------>" + unfilm);
       }

    public void enlever(Film unfilm, int qte){
        ajouterfilm(unfilm, -qte);
    }
    
    
    public void enlever(String titre, int qte) {
        ajouter(titre, -qte);
    }

    public void enlever(String titre) {
        enlever(titre, 1);
    }

    public void supprimer(String titre) {
        if (map.containsKey(titre)) {
            map.remove(titre);
        }
    }

    public Film rechercher(String titre) {
        if (map.containsKey(titre)) {
            return map.get(titre);
        } else {
            return null;
        }
    }

    public Collection listerFilms() {
        return map.values();
    }

    public void viderpanier() {
        if (map.size() > 0) {
            map.clear();
        }
    }

    public boolean estvide() {
        return map.isEmpty();
    }

    public int nombreEleements() {
        Collection unecollection = map.values();
        Iterator it = unecollection.iterator();
        Film unfilm;
        int nbreElements = 0;
        while (it.hasNext()) {
            unfilm = (Film) it.next();
            nbreElements += unfilm.getQuantite();
        }
        return nbreElements;
    }

    public float totalHT() {
        Collection unecollection = map.values();
        Iterator it = unecollection.iterator();
        Film unfilm;
        float prix=0;
        while(it.hasNext()){
            unfilm = (Film)it.next();
            prix+= (unfilm.getQuantite() * unfilm.getPrice());
        }
        
        return prix;
    }

    public float totalTTC() {
        return -1;
    }
    
    public int taillepanier(){
        return map.size();
    }
}
