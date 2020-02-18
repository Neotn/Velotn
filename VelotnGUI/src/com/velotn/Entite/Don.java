package com.velotn.Entite;

import java.time.LocalDate;

public class Don {
    private int id;
    private double somme;
    private LocalDate date;
    private int userId;

    public Don(int id) {
        this.id = id;
    }

    public Don(int id, double somme) {
        this.id = id;
        this.somme = somme;
    }

    public Don(double somme, int userId) {
        this.date = LocalDate.now().plusDays(1);
        this.somme = somme;
        this.userId = userId;
    }

    public Don(int id, double somme, LocalDate date, int userId) {
        this.id = id;
        this.somme = somme;
        this.date = LocalDate.now();
        this.userId = userId;
    }

    public Don(double somme,LocalDate date, int userId) {
        this.somme = somme;
        this.date = LocalDate.now();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
