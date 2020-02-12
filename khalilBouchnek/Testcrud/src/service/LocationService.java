/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Location ; 
import entity.Velo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import testcrud.DataSource;
/**
 *
 * @author khalil
 */
public class LocationService implements Ilocation<Location>{  
     private Connection cnx;
    private Statement st; 
    private ResultSet rs ; 
        private PreparedStatement pst ;  

    public LocationService(){
        cnx=DataSource.getInstance().getcnx();
    }
 @Override
    public void insertLocation(Location l) { 
        
        String req=" insert into location(id,date_debut,date_fin,prixtotal,id_produit) values(?,?,?,?,?)";  
        try {
        pst = cnx.prepareStatement(req) ;
        pst.setInt(1,l.getUser().getId());
        pst.setString(2, l.getDate_debut()); 
        pst.setString(3, l.getDate_fin()); 
        pst.setFloat(4,l.getPrixtotal()); 
        pst.setInt(5,l.getVelo().getId());
        pst.executeUpdate() ; 
          System.out.println("bien Ajouter ");

        } catch(SQLException ex)  
        { 
                        Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);

        }
        
    }
   

    @Override
    public List<Location> displaAll() {  
        
             List<Location> list = new ArrayList<>() ; 
             Velo v ;
             
        String req = "SELECT * from location l INNER JOIN velos v INNER JOIN produits p on v.id=p.id AND l.id_produit=v.id " ; 
        try {
            st=cnx.createStatement() ; 
            rs=st.executeQuery(req);  
           
           while(rs.next()) 
           {
               v=new Velo(rs.getInt("id_produit"), rs.getString("nomProd"), rs.getString("description"), rs.getFloat("prix"), rs.getString("marque"), rs.getString("type"));
               
               list.add(new Location(rs.getInt("id"), rs.getString("date_debut"), rs.getString("date_fin"),rs.getFloat("prixtotal"),v)) ; 
               
           }
              
          
            
        } catch (SQLException ex) {  
            Logger.getLogger(LocationService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return list ; 
    }
     

    @Override
    public void DeleteUserLocation(int id) {
       String req=" DELETE FROM location WHERE id="+id;  
        try {  
               st=cnx.createStatement() ; 
               st.executeUpdate(req) ; 
            System.out.println("bien supprimer");
        }catch (SQLException ex) { 
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);

        }    } 
    
       public void DeleteProduitLocation(int id) {
       String req=" DELETE FROM location WHERE id_produit="+id;  
        try {  
               st=cnx.createStatement() ; 
               st.executeUpdate(req) ; 
            System.out.println("bien supprimer");
        }catch (SQLException ex) { 
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);

        }    }

    @Override
    public void Update(int id , String date_debut, String date_fin ,int id_v) {
              String req=" UPDATE location SET date_debut='"+date_debut+"',date_fin='"+date_fin+"' WHERE id="+id+" and id_produit="+id_v;  
        try {  
               st=cnx.createStatement() ; 
               st.executeUpdate(req) ; 
            System.out.println("Location modifié");
        }catch (SQLException ex) { 
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);

        }
    } 
        public void UpdatePrix(int id  ,float prixtotal,int id_v) {
              String req=" UPDATE location SET prixtotal ="+prixtotal+" WHERE id="+id+" and id_produit="+id_v;  
        try {  
               st=cnx.createStatement() ; 
              st.executeUpdate(req) ; 
        }catch (SQLException ex) { 
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public List<Location> rechercherParid(int id) {  
        List<Location> list = new ArrayList<>() ;
        String req = "SELECT * from location l INNER JOIN velos v INNER JOIN produits p on v.id=p.id AND l.id_produit=v.id WHERE l.id="+id ;   
        Velo v ;
        try {  
               st=cnx.createStatement() ; 
               rs=st.executeQuery(req) ;  
               
               rs.last() ;  
               int nb=rs.getRow() ; 
               rs.beforeFirst();
              
               if(nb!=0) 
               { 
                    System.out.println("Location trouve") ;  
                    
                    while(rs.next()){ 
                 v=new Velo(rs.getInt("id_produit"), rs.getString("nomProd"), rs.getString("description"), rs.getFloat("prix"), rs.getString("marque"), rs.getString("type"));
               
               list.add(new Location(rs.getInt("id"), rs.getString("date_debut"), rs.getString("date_fin"),rs.getFloat("prixtotal"),v)) ; 
                    }

               } 
               
               else 
               { 
                   System.out.println("Location non trouve") ; 
               }  
            }catch (SQLException ex) { 
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);

        }   
        return list ;
    }
    
    public float getVeloPrix(int id) {  
        
            
        String req = "SELECT * from location l INNER JOIN produits p on l.id_produit=p.id AND l.id_produit="+id ;
        

        float prix=0;
        try {
            st=cnx.createStatement() ; 
            rs=st.executeQuery(req);  
           
           while(rs.next()) 
              prix= rs.getFloat("prix") ; 
        } catch (SQLException ex) {  
            Logger.getLogger(LocationService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return prix;
    }

    @Override
    public float calculer(int id) {
        String req = "SELECT TIMESTAMPDIFF (DAY,date_debut,date_fin) AS DAYs FROM location  WHERE id_produit="+id ;  
        float prix = getVeloPrix(id);
        int  k=0;
        
        try {
            st=cnx.createStatement() ; 
            rs=st.executeQuery(req);  
           while(rs.next())
           {
                  k = rs.getInt("DAYs"); 
       
           
           }
          
        } catch (SQLException ex) {  
            Logger.getLogger(LocationService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return k*prix;
    }   
    
  
    public List<Location> TrierParPrix() {   
              List<Location> list = new ArrayList<>() ; 
             Velo v ;
             
        String req = "SELECT * from location l INNER JOIN velos v INNER JOIN produits p on v.id=p.id AND l.id_produit=v.id ORDER BY prixtotal DESC" ; 
        try {
            st=cnx.createStatement() ; 
            rs=st.executeQuery(req);  
           
           while(rs.next()) 
           {
               v=new Velo(rs.getInt("id_produit"), rs.getString("nomProd"), rs.getString("description"), rs.getFloat("prix"), rs.getString("marque"), rs.getString("type"));
               
               list.add(new Location(rs.getInt("id"), rs.getString("date_debut"), rs.getString("date_fin"),rs.getFloat("prixtotal"),v)) ; 
               
           }   
        } catch (SQLException ex) {  
            Logger.getLogger(LocationService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return list ; 
        
    } 
    

   
    
    
}
