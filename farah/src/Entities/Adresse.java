/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Farah GABSI
 */
public class Adresse {
    private int id ;
    private String pays ;
    private String region;
    private int code_postal;
    private String rue;
    private User u;

    public Adresse(int id, String pays, String region, int code_postal, String rue, User u) {
        this.id = id;
        this.pays = pays;
        this.region = region;
        this.code_postal = code_postal;
        this.rue = rue;
        this.u = u;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
    

    public Adresse(int id, String pays, String region, int code_postal, String rue) {
        this.id = id;
        this.pays = pays;
        this.region = region;
        this.code_postal = code_postal;
        this.rue = rue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }
    
    @Override
    public String toString() {
        return "Adresse{" + "id=" + id + ", pays=" + pays + ", region=" + region + ", code_postal=" + code_postal + ", rue=" + rue + '}';
    }
}
