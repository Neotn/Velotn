package com.velotn.Entite;

import java.util.ArrayList;
import java.util.List;


public class Commande {
    private int id;
    private String date;
    private int numCommande;
    private double prix;
    private List<Integer> produits = new ArrayList<Integer>();
    private int userid;

    public Commande(String date, int numCommande, double prix, List<Integer> produits, int userid) {
        this.date = date;
        this.numCommande = numCommande;
        this.prix = prix;
        this.produits = produits;
        this.userid = userid;
    }

    public Commande(int id, String date, int numCommande, double prix, int userid) {
        this.id = id;
        this.date = date;
        this.numCommande = numCommande;
        this.prix = prix;
        this.userid = userid;
    }

    public Commande(int id, int numCommande) {
        this.id = id;
        this.numCommande = numCommande;
    }

    public Commande(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public List<Integer> getProduits() {
        return produits;
    }

    public void setProduits(List<Integer> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "com.velotn.Entite.Commande{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", numCommande='" + numCommande + '\'' +
                ", prix=" + prix +
                ", produits=" + produits +
                '}';
    }
}
