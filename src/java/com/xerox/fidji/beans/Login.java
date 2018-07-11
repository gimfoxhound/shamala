
package com.xerox.fidji.beans;

import com.xerox.fidji.db.divers.UserDAO;
import java.io.IOException;


public class Login {
private String username;
private String passworth;
private boolean valide;
private String remarque;
private String email;
private String fullname;
private String role;
private String prenom;
private String nom;
private String adresse;
private String ville;
private String img;

    public Login() {
    }

    public Login(String username, String password){
        this.username = username;
        this.passworth = password;
    }

   public User authentification(String identifiant, String motdepasse) throws IOException{
       
       Login lg = new Login(identifiant, motdepasse);
       lg= UserDAO.seLoguer(lg);
       if(lg!=null){
       System.out.println("le user ---->"+lg);
       return new User(identifiant);
   }else{
           return null;
       }
       
   }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassworth() {
        return passworth;
    }

    public void setPassworth(String passworth) {
        this.passworth = passworth;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    

    @Override
    public String toString() {
        String result =" "+this.getUsername() +", " + this.getPassworth();
        if(this.getEmail()!=null){
            result+=", "+this.getEmail();
        }
        result+=", "+this.prenom+", "+this.getNom()+" a pour role : "+this.getRole();
        if(this.getAdresse()!=null && !this.getAdresse().equals("")){
            result+= ", reside : "+this.getAdresse();
        }
        if(this.getVille()!=null && !this.getVille().equals("")){
            result+=" "+this.getVille();
        }
        
        
        return result ;
    }

    

    
    
     
    
    
    
    


    
}
