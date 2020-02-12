/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Adresse;
import Entities.User;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Farah GABSI
 */
public class ServiceAdresse {
    private Connection con = Connexion.getinstance().getCnx();
    public void ajouterAdresse (Adresse a){
        try {
            Statement st = con.createStatement();
            String req = "insert into `adresse` values("+a.getId()+",'"+a.getPays()+"','"+a.getRegion()+"','"+a.getCode_postal()+"','"+a.getRue()+"')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAdresse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void afficherAdresse (){
        try {
            PreparedStatement pt= con.prepareStatement("select * from `adresse`");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("adresse [id:"+rs.getInt(1)+" ,pays: "+rs.getString(2)+" ,region: "+rs.getString(3)+" ,code_postale: "+rs.getInt(4)+" ,rue: "+rs.getString(5)+"]");
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceAdresse.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
     public void modifierAdresse (int id,Adresse a) {
       
        try {
            PreparedStatement pt =con.prepareStatement("update adresse set pays= ?, region = ?, code_postal = ?, rue = ? where id= ?");
            pt.setString(1, a.getPays());
            pt.setString(2, a.getRegion());
            pt.setInt(3, a.getCode_postal());
            pt.setString(4, a.getRue());
            pt.setInt(5, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAdresse.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     public void supprimerAdresse (User u){
        try {
            PreparedStatement pt =con.prepareStatement("delete from adresse where id = ?");
            pt.setInt(1, u.getId());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
