
package com.xerox.fidji.beans;

import java.io.Serializable;
import java.sql.Date;


public class Actor implements Comparable, Serializable{

private String first_name;
private String last_name;
private String nickname;
private char sex;
private Date birthdate;
private String img;
private int size;
private Date last_update;
private String remarque;
private int poids;
private boolean isactive;
    public Actor()  {
    }

    public Actor(String first_name, String last_name, char sex) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.sex = sex;
    }

    public Actor(String first_name, String last_name, String nickname, char sex) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.sex = sex;
    }

    public Actor(String first_name, String last_name, String nickname, char sex, Date Birthdate) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.sex = sex;
        this.birthdate = Birthdate;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }
    
    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }
    @Override
    public String toString() {
        String unacteur = this.getFirst_name()+", "+this.getLast_name()+", "+this.getNickname()+ ", "+this.getImg();
        return unacteur;
    }
 @Override
    public boolean equals(Object unacteur) {
        return compareTo(unacteur)==0;
    }
    
    @Override
    public int compareTo(Object unacteur) {
       
        int result = first_name.compareTo(((Actor)unacteur).getFirst_name());
        if(result==0){
        result=  last_name.compareTo( ((Actor)unacteur).getLast_name());
        }
        if(result==0){
        result=  nickname.compareTo( ((Actor)unacteur).getNickname());
        }
        if(result==0){
        boolean genre= this.sex==( ((Actor)unacteur).getSex() );
        if(genre)
        result= 0  ;
        }
        if(result==0){
            boolean taille=size==(((Actor)unacteur).getSize());
            if(taille)
            result = 0;
        }
            
        return result;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
}
