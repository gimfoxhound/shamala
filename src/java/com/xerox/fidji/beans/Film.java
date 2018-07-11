package com.xerox.fidji.beans;

//import com.xerox.fidji.db.divers.UserDAO;
import com.xerox.fidji.db.divers.FilmDAO;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Film implements Comparable, Serializable{

    private String title;
    private String description;
    private short release_year;
    private byte language_id;
    private byte original_language_id;
    private byte rental_duration;
    private long rental_rate;
    private short length;
    private float replacement_cost;
    private String rating;
    private String special_features;
    private Date last_update;
    private float Price;
    private String boxcover;
    private int quantite;
    private int film_id;

    public Film() {
    }

    public Film(String title) {
        this.title = title;
    }

    public Film(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Film(String title, int quantite) {
        this.title = title;
        this.quantite = quantite;
    }
    
    
    public Film(String title, String description, String BoxCover) {
        this.title = title;
        this.description = description;
        this.boxcover = BoxCover;
    }

    public Film(String title, String description, short release_year, float Price, String BoxCover) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.Price = Price;
        this.boxcover = BoxCover;
    }
    
    
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getRelease_year() {
        return release_year;
    }

    public void setRelease_year(short release_year) {
        this.release_year = release_year;
    }

    public byte getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(byte language_id) {
        this.language_id = language_id;
    }

    public byte getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(byte original_language_id) {
        this.original_language_id = original_language_id;
    }

    public byte getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(byte rental_duration) {
        this.rental_duration = rental_duration;
    }

    public long getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(long rental_rate) {
        this.rental_rate = rental_rate;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public float getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(float replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getBoxcover() {
        return boxcover;
    }

    public void setBoxcover(String boxcover) {
        this.boxcover = boxcover;
    }
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
    
    public ArrayList<Film> Listedesfilms() throws IOException{
       
       //Login lg = new Login(identifiant, motdepasse);
       ArrayList<Film> lstfilms = new ArrayList<>();
       
       lstfilms= FilmDAO.listFilms();
       if(lstfilms !=null && lstfilms.size()>0){
       System.out.println("la liste des films  ---->"+lstfilms);
       return lstfilms;
   }else{
           return null;
       }
       
   }
    

    @Override
    public String toString() {
       /* StringBuffer  leFilm =  new StringBuffer( this.getTitle()+",");
        if(this.getDescription()!=null){
            leFilm.append(this.getDescription());
        }
        if(this.getPrice()!=0){
            leFilm.append(this.getPrice());
        }
        
        if(this.getQuantite()>0){
            leFilm.append(this.getQuantite());
        }
        if(this.getBoxCover()!=null){
            leFilm.append(this.getBoxCover());
        }*/
        String resy=this.getTitle()+", "+this.getDescription()+", "+this.getQuantite();
        
        
        return resy; 
    }
    
    
    

    @Override
    public boolean equals(Object unfilm) {
        return compareTo(unfilm)==0;
    }
    
    @Override
    public int compareTo(Object film) {
       
        int result = title.compareTo(((Film)film).getTitle());
        return result ==0 ? description.compareTo( ((Film)film).getDescription()):result;
    }

    public void delta(int qte){
        this.quantite +=qte;
        //this.setQuantite(qte++);
        //Essayez un this.set Attention ici !
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
    
    
    
  
    

}
