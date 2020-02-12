/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Groups;
import Entities.User;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Hsine
 */
public class ServiceGroupe {

    Connection c = Connexion.getinstance().getCnx();

    public ServiceGroupe() {

    }

    public void ajouterGroupe(Groups p1) {
        String req = "INSERT INTO `groups`(`id`, `nom`,`nbrMembre`, `description`,  `date_de_creation`,  image , `nbr_signal`,`IdUser`) VALUES (?,?,?,?,?,?,?,?)";
        Calendar c1 = Calendar.getInstance();
        Timestamp ts = new Timestamp(c1.getTimeInMillis());
        try {

            PreparedStatement ps = c.prepareStatement(req);
            ps.setInt(1, p1.getId());
            ps.setString(2, p1.getNom());
            ps.setInt(3, 1);
            ps.setString(4, p1.getDescription());

            ps.setTimestamp(5, ts);
            ps.setString(6, p1.getImage());
            ps.setInt(7, 0);
            ps.setInt(8, 1);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceGroupe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Groups> AfficherAllGroups() {
        ObservableList<Groups> ALLgroups = FXCollections.observableArrayList();
//    int aa = UserLoginController.iduser;
        try {
            String query = "select * from groups";
            Statement st = c.createStatement();
            ResultSet rest = st.executeQuery(query);
            while (rest.next()) {
                Groups g = new Groups();
                g.setId(rest.getInt("id"));
                g.setNom(rest.getString("nom"));
                g.setNbrMembre(rest.getInt("nbrMembre"));
                g.setDate_de_creation(rest.getDate("date_de_creation"));
                g.setNbr_signal(rest.getInt("nbr_signal"));
                g.setImage(rest.getString("image"));
                g.setIdUser(rest.getInt("IdUser"));
                g.setDescription(rest.getString("description"));

                System.out.println(g);

                ALLgroups.add(g);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.ServiceGroupe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ALLgroups;

    }

    public Groups getGroupeById(int idCourant) {

        Groups g = new Groups();
        try {
            String query = "select * from groups where id = ?";
            PreparedStatement ps;

            ps = c.prepareStatement(query);
            ps.setInt(1, idCourant);
            ResultSet rest = ps.executeQuery();

            while (rest.next()) {
                g.setId(rest.getInt("id"));
                g.setNom(rest.getString("nom"));
                g.setNbrMembre(rest.getInt("nbrMembre"));
                g.setDate_de_creation(rest.getDate("date_de_creation"));
                g.setNbr_signal(rest.getInt("nbr_signal"));
                g.setImage(rest.getString("image"));
                g.setIdUser(rest.getInt("IdUser"));
                g.setDescription(rest.getString("description"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.ServiceGroupe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;

    }

    public void supprimerGroupe(Groups a) {
        String query = "delete from groups where nom=?";
        PreparedStatement ps;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, a.getNom());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceGroupe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateGroupe(Groups b) throws SQLException {

        String reqUp = "UPDATE groups SET nom=?,description=?,image=? where id=?";
        PreparedStatement pss = c.prepareStatement(reqUp);

        System.out.println(b);
        pss.setString(1, b.getNom());
        pss.setString(2, b.getDescription());

        pss.setString(3, b.getImage());
        pss.setInt(4, b.getId());

        pss.executeUpdate();

    }

   

    public ObservableList<Groups> RechercheGroupeParNom(String recherche) {

        ObservableList<Groups> ALLgroups = FXCollections.observableArrayList();
        try {
            String query = "select * from groups WHERE nom LIKE '%" + recherche + "%' ;";
            Statement st = c.createStatement();
            ResultSet rest = st.executeQuery(query);
            while (rest.next()) {
                Groups g = new Groups();

                g.setId(rest.getInt("id"));
                g.setNom(rest.getString("nom"));
                g.setNbrMembre(rest.getInt("nbrMembre"));
                g.setDate_de_creation(rest.getDate("date_de_creation"));
                g.setNbr_signal(rest.getInt("nbr_signal"));
                g.setImage(rest.getString("image"));
                g.setIdUser(rest.getInt("IdUser"));
                g.setDescription(rest.getString("description"));
                ALLgroups.add(g);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.ServiceGroupe.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ALLgroups;

    }

}
