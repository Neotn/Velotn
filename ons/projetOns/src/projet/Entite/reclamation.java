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
public class reclamation {
    
    private int id;
    private int idUser;
    private String descriptionR;
    private int etat;
    

    public reclamation(int idUser, String descriptionR, int etat) {
        this.idUser = idUser;
        this.descriptionR = descriptionR;
        this.etat = etat;
    }

    public reclamation(int id, int idUser, String descriptionR, int etat) {
        this.id = id;
        this.idUser = idUser;
        this.descriptionR = descriptionR;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id=" + id + ", idUser=" + idUser + ", descriptionR=" + descriptionR + ", etat=" + etat + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDescriptionR() {
        return descriptionR;
    }

    public void setDescriptionR(String descriptionR) {
        this.descriptionR = descriptionR;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
