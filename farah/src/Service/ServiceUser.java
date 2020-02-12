/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.User;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Farah GABSI
 */
public class ServiceUser {
    public static User connectedUser =null;
    private Connection con=Connexion.getinstance().getCnx();
    public void ajouterUser (User u) {
        try {
            Statement st = con.createStatement();
            String req ="insert into `fos_user` values("+u.getId()+",'"+u.getUsername()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getDate_naiss()+"','"+u.getTel()+"','"+u.getInterets()+"','"+u.getImage()+"')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void afficherUser(){
        try {
            PreparedStatement pt= con.prepareStatement("select * from `fos_user`");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("User [id:"+rs.getInt(1)+" ,username: "+rs.getString(2)+" ,email: "+rs.getString(3)+" ,password: "+rs.getString(4)+" ,nom: "+rs.getString(5)+" ,prenom: "+rs.getString(6)+" ,date_naiss: "+rs.getDate(7)+" ,tel: "+rs.getString(8)+" ,interets: "+rs.getString(9)+" ,image: "+rs.getString(10)+"]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifierUser (int id,String nom) {
        try {
            PreparedStatement pt =con.prepareStatement("update fos_user set nom= ? where id= ?");
            pt.setString(1, nom);
            pt.setInt(2, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerUser (User u){
        try {
            PreparedStatement pt =con.prepareStatement("delete from fos_user where email = ? and username = ?");
            pt.setString(1, u.getEmail());
            pt.setString(2, u.getUsername());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean Authentifier(String username, String password){
        try {
            PreparedStatement pt =con.prepareStatement("select * from fos_user where username = ? and password = ?");
            pt.setString(1, username);
            pt.setString(2, password);
            ResultSet rs = pt.executeQuery();
            if ( rs.next()){
                System.out.println("User connecté [id:"+rs.getInt(1) + 
                        " ,username: " + 
                        rs.getString(2) +
                        " ,email: " +
                        rs.getString(3) +
                        " ,password: " +
                        rs.getString(4) +
                        " ,nom: " +
                        rs.getString(5)+
                        " ,prenom: " +
                        rs.getString(6) +
                        " ,date_naiss: " +
                        rs.getDate(7) +
                        " ,tel: " +
                        rs.getString(8) +
                        " ,interets: " +
                        rs.getString(9)+" ,image: "+rs.getString(10)+"]");
                connectedUser = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10));
                connectedUser.setId(rs.getInt(1));
                return true;
            }
            else{
                System.out.println("Verify your login or password");
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
            connectedUser = null;
            System.out.println("********");
        }
            return false;
    }
    
    public User getConnectedUser(){
        return connectedUser;
    }
}
