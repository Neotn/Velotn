/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.User;
import Utils.Connexion;
import com.jfoenix.controls.JFXCheckBox;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.ini4j.Wini;

/**
 *
 * @author Farah GABSI
 */
public class LoginService {
    
         PreparedStatement pst;
    ResultSet rs;
    Connection cnx=Connexion.getinstance().getCnx();

    public Statement ste;
    
     public LoginService() {
        try {
            ste = cnx.createStatement();
                    } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    public String LoginAction(User user) throws SQLException{
        String req= "Select * from fos_user where username=? and password=?";
        PreparedStatement prs= cnx.prepareStatement(req);
        prs.setString(1, user.getUsername());
        prs.setString(2, user.getPassword());
        rs = prs.executeQuery();
        return "good job u made it here";
    }
    
    public void createiniFile(String path,String user,String pass){
        try {
        File file = new File(path);
        if(!file.exists()){ 
            file.createNewFile();
        }
        Wini wini = new Wini(new File(path));
        wini.put("Login data", "Username",user);
        wini.put("Login data", "Password",pass);
        wini.store();
        
            } catch (IOException ex) {
                Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void readinifile(String path, TextField userid, PasswordField passid, JFXCheckBox remember){
        File file = new File(path);
        if(file.exists()){  
            try {
                Wini wini = new Wini(new File(path));
                String username = wini.get("Login data","Username");
                String password = wini.get("Login data","Password");
                if ((username!=null && !username.equals(""))&&(password!=null && !password.equals("")) ){
                    userid.setText(username);
                    passid.setText(password);
                    remember.setSelected(true);
                }
            } catch (IOException ex) {
                Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
          public ResultSet info(String email) throws SQLException {
     
          String req= "Select username,password from fos_user where email=? ";
          PreparedStatement prs= cnx.prepareStatement(req);
          prs.setString(1, email);
          rs= prs.executeQuery();
          return rs;
    }
    
    
       public ResultSet userbyid(Integer id) throws SQLException {
     
          String req= "Select * from fos_user where id=? ";
          PreparedStatement prs= cnx.prepareStatement(req);
          prs.setInt(1, id);
          rs= prs.executeQuery();
          return rs;
    }
       
        public ResultSet user(String username , String password) throws SQLException {
     
          String req= "Select * from fos_user where (username=? or email=?) and password=?";
          PreparedStatement prs= cnx.prepareStatement(req);
          prs.setString(1, username);
          prs.setString(2, password);
          rs= prs.executeQuery();
          return rs;
    }
       
         public void AjouterUtilisateur(String username , String prenom , String nom , String email , String password , String date_naissance) throws SQLException{
        String req= "INSERT INTO fos_user  (username,prenom,nom,email,password,date_naissance) VALUES (?,?,?,?,?,?)";
        PreparedStatement prs= cnx.prepareStatement(req);
        prs.setString(1, username);
        prs.setString(2, prenom);
        prs.setString(3, nom);
        prs.setString(4, email);
        prs.setString(5, password);
        prs.setString(6, date_naissance);
        
        int executeUpdate = prs.executeUpdate();
        System.out.println(" utilisateur Ajoutée");
    }
       public ResultSet check_email(String email) throws SQLException {
     
          String req= "Select * from fos_user where email=?";
          PreparedStatement prs= cnx.prepareStatement(req);
          prs.setString(1, email);
          rs= prs.executeQuery();
          return rs;
    }   
}
