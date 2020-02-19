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
import projet.Entite.reclamation;
import projet.IService.IService;
import projet.utils.DataBase;

/**
 *
 * @author Ons
 */
public class serviceReclamation implements IService<reclamation> {
    private Connection con;
    private Statement ste;
    public serviceReclamation() {
        con = DataBase.getInstance().getConnection();
    }
    
    @Override
    public void ajouter(reclamation t) throws SQLException {
        PreparedStatement pre=con.prepareStatement ("INSERT INTO reclamation (idUser,descriptionR,etat) VALUES (?,?,?) ");
       pre.setInt(1, t.getIdUser());
       
       pre.setString(2, t.getDescriptionR());
       pre.setInt(3, t.getEtat());
       pre.executeUpdate();
    }

    

    @Override
    public boolean delete(reclamation t) throws SQLException {
        PreparedStatement pre=con.prepareStatement ("DELETE FROM reclamation WHERE id=?");
      pre.setInt(1,t.getId());
       pre.executeUpdate();
       return true;
    }

    @Override
    public boolean update(reclamation t) throws SQLException {
         PreparedStatement pre=con.prepareStatement ("UPDATE reclamation SET idUser=?,descriptionR=?,etat=? WHERE  id=? ");
       pre.setInt(1, t.getIdUser());
       
       pre.setString(2, t.getDescriptionR());
       pre.setInt(3, t.getEtat());
       pre.setInt(4,t.getId());
       pre.executeUpdate();
       return true;
    }

    @Override
    public List<reclamation> readAll() throws SQLException {
        List<reclamation> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reclamation");
     while (rs.next()) {                
               int id=rs.getInt(1);
               int idUser=rs.getInt(2);
               String descriptionR=rs.getString(3);
               int etat=rs.getInt(4);
               
               
               reclamation r=new reclamation(id,idUser,descriptionR,etat);
     arr.add(r);
     }
    return arr;
    }
    public void rechercher(int a){
        try {
            String req = "Select* from reclamation where id='"+a+"'" ;
            Statement st = con.prepareStatement(req);
            ResultSet rst;
            st=con.createStatement();
            rst=st.executeQuery(req);
            rst.last(); 
            int nbrRow=rst.getRow();
            if (nbrRow!=0){
                System.out.println("reclamation trouvé");
            }else{
                System.out.println("reclamation introuvable");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }        
    }
    public void rechercherParEtat(String a){
        try {
            String req = "Select* from reclamation where etat='"+a+"'";
            Statement st = con.prepareStatement(req);
            ResultSet rst;
            st=con.createStatement();
            rst=st.executeQuery(req);
            rst.last(); 
            int nbrRow=rst.getRow();
            if (nbrRow!=0){
                System.out.println("reclamation trouvé");
            }else{
                System.out.println("reclamation introuvable");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }        
    }
}
