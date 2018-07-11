
package com.xerox.fidji.beans;

import java.util.Enumeration;
import java.util.Hashtable;


public class MonCatalogue {
    
    protected Hashtable items = new Hashtable();

    public MonCatalogue() {
    }
    
    public void ajouterFilm(Film unfilm, int unequantite){
        System.out.println("Un film ----->"+unfilm);
        items.put(unfilm.getTitle()  , unfilm);
    }
    public void ajouterFilm(Film unfilm){
        items.put(unfilm.getTitle(), unfilm);
    }
    public void ajouterFilm(String titre){
        //ajouterFilm(unfilm);
    }
    public void ajouterFilm(String titre, int qte){
        if(items.containsKey(titre)){
            Film unfilm = (Film)items.get(titre);
            unfilm.delta(qte);
            if(unfilm.getQuantite()<1){
                supprimer(titre);
            }else{
                items.put(titre, new Film(titre,qte));
            }
        }
    }
    public void ajouterFilm(String titre, String description,float prix, int quantite){
        String[] item = {titre,description, Float.toString(prix),Integer.toString(quantite)};
        if(items.containsKey(titre)){
            String[] tmpItem= (String[])items.get(titre);
            int tmpQuant = Integer.parseInt(tmpItem[3]);
            quantite +=tmpQuant;
            tmpItem[3] = Integer.toString(quantite);
            
        }else{
            items.put(titre, item);
        }
    }
    public void enleverlivredupanier(String titre){
        if(items.containsKey(titre)){
            items.remove(titre);
        }
    }
    public void supprimer (String ref){
        items.remove(ref);
    }
    
    public void videlepanier(){
        if(items.size()>0){
            items.clear();
        }
    }
    public void updateQuantite(String titre, int quantite){
        if(items.containsKey(titre)){
            String[] tmpItem = (String[])items.get(titre);
            tmpItem[3] = Integer.toString(quantite);
        }
    }
    
    public Enumeration getEnumeration(){
        return items.elements();
    }
    
    public float getCost(){
        Enumeration uneliste = items.elements();
        String[] tmpItem;
        float totalcost = 0.00f;
        while(uneliste.hasMoreElements()){
            tmpItem = (String[])uneliste.nextElement();
            totalcost+= ( Integer.parseInt(tmpItem[3]) )*( Float.parseFloat(tmpItem[2]));
        }
        return totalcost;
    }
    public int getNumOfItems(){
        Enumeration uneliste = items.elements();
        String [] tmpItem;
        int numOfItems =0;
        while(uneliste.hasMoreElements()){
            tmpItem =  (String[])uneliste.nextElement();
            numOfItems +=  Integer.parseInt(tmpItem[3]);
        }
         return numOfItems;
    }
    
    
}
