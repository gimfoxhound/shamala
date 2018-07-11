
package com.xerox.fidji.beans;

import java.io.Serializable;


public class User implements Comparable, Serializable{

private String userId;
private String ipAddr;
private String passworth;

    public User() {
    }

  public User(String anUser){
      this.userId= anUser;
  }
   


   public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getPassworth() {
        return passworth;
    }

    public void setPassworth(String passworth) {
        this.passworth = passworth;
    }

    @Override
    public String toString() {
        return userId;
    }

    @Override
    public int hashCode() {
        return 13*userId.hashCode() + 7*ipAddr.hashCode();
    }

    @Override
    public boolean equals(Object user) {
        return compareTo(user)==0;
    }

    @Override
    public int compareTo(Object user) {
        int result = userId.compareTo(((User)user).getUserId());
        return result ==0 ? ipAddr.compareTo( ((User)user).getIpAddr()):result;
        
        
    }
    
    
    
    



    
}
