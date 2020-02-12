package com.velotn.Test;

import com.velotn.Entite.Commande;
import com.velotn.Entite.Don;
import com.velotn.Service.ServiceCommande;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestCommande {
    public static void main(String[] args) {
        ServiceCommande serviceCommande = new ServiceCommande();
        List<Integer> p = new ArrayList<Integer>();
        p.add(2);
        p.add(25);
        p.add(6);
        Commande c1 = new Commande("20/01/2020",123,250.0,p,2);
        Commande c2 = new Commande("02/01/2020",2,50.5,p,3);
        Commande sup = new Commande(1);
        Commande up = new Commande(2,500);
        try{
            //serviceDon.ajouter(d1);
            //serviceDon.ajouter(d2);
            serviceCommande.update(up);
            List<Commande> listCommande = serviceCommande.readAll();
            System.out.println(listCommande);
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
