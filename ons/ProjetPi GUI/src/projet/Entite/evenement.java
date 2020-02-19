/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Entite;

/**
 *
 * @author Ons
 */
public class evenement {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "evenement{" + "id=" + id + ", nom=" + nom + ", heure=" + heure + ", date=" + date + ", description=" + description + '}';
    }

    public evenement(int id, String nom, String heure, String date, String description) {
        this.id = id;
        this.nom = nom;
        this.heure = heure;
        this.date = date;
        this.description = description;
    }

    public evenement(String nom, String heure, String date, String description) {
        this.nom = nom;
        this.heure = heure;
        this.date = date;
        this.description = description;
    }
    private int id;
    private String nom;
    private String heure;
    private String date;
    private String description;
    
    //public evenement recherche
    
    
    
}
