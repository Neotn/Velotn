/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import projet.Entite.evenement;
import projet.IService.IService;
import projet.utils.DataBase;

/**
 *
 * @author Ons
 */
public class serviceEvenement implements IService<evenement>{

     private Connection con;
    private Statement ste;

    public serviceEvenement() {
        con = DataBase.getInstance().getConnection();
    }
    
    @Override
    public void ajouter(evenement t) throws SQLException {
        
       PreparedStatement pre=con.prepareStatement ("INSERT INTO evenement (nom,heure,date,description) VALUES (?,?,?,?) ");
       pre.setString(1, t.getNom());
       
       pre.setString(2, t.getHeure().toString());
       pre.setDate(3, t.getDate());
       pre.setString(4, t.getDescription());
       pre.executeUpdate();
       
        
    }

    @Override
    public boolean delete(evenement t) throws SQLException {
      PreparedStatement pre=con.prepareStatement ("DELETE FROM evenement WHERE id=?");
      pre.setInt(1,t.getId());
       pre.executeUpdate();
       return true;
      
    }

    @Override
    public boolean update(evenement t) throws SQLException {
        PreparedStatement pre=con.prepareStatement ("UPDATE evenement SET nom=?,heure=?,date=?,description=? WHERE  id=? ");
       pre.setString(1, t.getNom());
       pre.setString(2, t.getHeure().toString());
       pre.setDate(3, t.getDate());
       pre.setString(4, t.getDescription());
       pre.setInt(5,t.getId());
       pre.executeUpdate();
       return true;
    }

    @Override
    public List<evenement> readAll() throws SQLException {
       List<evenement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from evenement");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               Time heure=rs.getTime(3);
               Date  date=rs.getDate(4);
               String description=rs.getString(5);
               
               evenement e=new evenement(id,nom, heure, date, description);
     arr.add(e);
     }
    return arr;
    }
    public void rechercher(int a){
        try {
            String req = "Select* from evenement where id='"+a+"'" ;
            Statement st = con.prepareStatement(req);
            ResultSet rst;
            st=con.createStatement();
            rst=st.executeQuery(req);
            rst.last(); 
            int nbrRow=rst.getRow();
            if (nbrRow!=0){
                System.out.println("evenement trouvé");
            }else{
                System.out.println("evenement introuvable");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }        
    }
    public void rechercherParNom(String a){
        try {
            String req = "Select* from evenement where nom='"+a+"'";
            Statement st = con.prepareStatement(req);
            ResultSet rst;
            st=con.createStatement();
            rst=st.executeQuery(req);
            rst.last(); 
            int nbrRow=rst.getRow();
            if (nbrRow!=0){
                System.out.println("evenement trouvé");
            }else{
                System.out.println("evenement introuvable");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }        
    }
}
