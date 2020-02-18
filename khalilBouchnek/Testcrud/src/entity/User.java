/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author khalil
 */
public class User {
    private int id ;
  private String username;
 private String email;
 private String password;
 private String nom;
 private String prenom;
 private String date_naiss;
 private String tel ;
 private String interets;
 private String image;

    public User(int id, String username, String email, String password, String nom, String prenom, String date_naiss, String tel, String interets, String image) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.tel = tel;
        this.interets = interets;
        this.image = image;
    }
public User(int id )
{ 
    this.id= id ; 
}
 

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

   

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setInterets(String interets) {
        this.interets = interets;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

  

    public String getTel() {
        return tel;
    }

    public String getInterets() {
        return interets;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", date_naiss=" + date_naiss + ", tel=" + tel + ", interets=" + interets + ", image=" + image + '}';
    }
}
