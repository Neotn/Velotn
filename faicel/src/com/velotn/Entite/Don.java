package com.velotn.Entite;

public class Don {
    private int id;
    private double somme;
    private String date;
    private int userId;

    public Don(int id) {
        this.id = id;
    }

    public Don(int id, double somme) {
        this.id = id;
        this.somme = somme;
    }

    public Don(int id, double somme, String date, int userId) {
        this.id = id;
        this.somme = somme;
        this.date = date;
        this.userId = userId;
    }

    public Don(double somme,String date, int userId) {
        this.somme = somme;
        this.date = date;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "com.velotn.Entite.Don{" +
                "id=" + id +
                ", somme=" + somme +
                ", date='" + date + '\'' +
                ", userId=" + userId +
                '}';
    }
}
