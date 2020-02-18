package com.velotn.Service;

import com.velotn.Entite.Commande;
import com.velotn.IService.IService;
import com.velotn.Utils.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCommande implements IService<Commande> {

    private Connection con;
    private Statement ste;

    public ServiceCommande() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Commande commande) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `commande` (`date`, `num_commande`, `prix`, `user_id`) VALUES (?,?,?,?);");
        pre.setString(1,commande.getDate());
        pre.setInt(2,commande.getNumCommande());
        pre.setDouble(3,commande.getPrix());
        pre.setInt(4,commande.getUserid());
        pre.executeUpdate();
        //addingItems
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT LAST_INSERT_ID() as id from commande");
        int id = 0;
        while(rs.next()){
            id = rs.getInt(1);
        }
        PreparedStatement pre2 = con.prepareStatement("INSERT INTO `listprod` (`command_id`,`product`,`qte`,`prix`) VALUES (?,?,?,?);");
        while(!commande.getProduits().isEmpty()){
            pre2.setInt(1,id);
            pre2.setInt(2,commande.getProduits().get(0));
            commande.getProduits().remove(0);
            pre2.setInt(3,1);
            pre2.setDouble(4,2.5);
            pre2.executeUpdate();
        }
    }

    @Override
    public boolean delete(Commande commande) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `commande` WHERE id = ?");
        pre.setInt(1,commande.getId());
        pre.executeUpdate();
        return true;
    }

    @Override
    public boolean update(Commande commande) throws SQLException {
        PreparedStatement pre = con.prepareStatement("UPDATE `commande` SET num_commande = ? where id = ?");
        pre.setInt(1,commande.getNumCommande());
        pre.setInt(2,commande.getId());
        pre.executeUpdate();
        return true;
    }

    @Override
    public List<Commande> readAll() throws SQLException {
        List<Commande> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * FROM commande");
        while(rs.next()){
            int id = rs.getInt(1);
            String date = rs.getString(2);
            int numcommande = rs.getInt(3);
            double prix = rs.getDouble(4);
            int userid = rs.getInt(5);
            Commande don = new Commande(id,date,numcommande,prix,userid);
            arr.add(don);
        }
        return arr;
    }

    @Override
    public Commande search(Commande commande) throws SQLException {
        return null;
    }

    @Override
    public List<Commande> sortByPrice() throws SQLException {
        return null;
    }
}
