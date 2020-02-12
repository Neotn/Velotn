/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service; 
import entity.Produit;
import entity.Promotion ;  
import testcrud.DataSource ; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khalil
 */
public class PromotionService implements Ipromotion<Promotion>{
 
    private Connection cnx;
    private Statement st; 
    private ResultSet rs ; 
        private PreparedStatement pst ;  

    public PromotionService(){
        cnx=DataSource.getInstance().getcnx();
    }
    @Override
    public void insertPromotion(Promotion p) {   
       String req=" insert into promotion(id,type,taux,id_produits) values(?,?,?,?)";  
        try {
        pst = cnx.prepareStatement(req) ; 
        pst.setInt(1,p.getId());
        pst.setString(2, p.getType()); 
        pst.setFloat(3, p.getTaux());  
        pst.setInt(4,p.getPro().getId());
        pst.executeUpdate() ; 
          System.out.println("bien Ajouter ");

        } catch(SQLException ex)  
        { 
                        Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        
        
    }

    @Override
    public List<Promotion> displaAll() {
         List<Promotion> list = new ArrayList<>() ;  
         Produit pr; 
         
        String req = "select * from promotion pr INNER JOIN produits p on pr.id_produits=p.id" ;  
         
        try {
            st=cnx.createStatement() ; 
            rs=st.executeQuery(req); 
            while(rs.next())  { 
                pr=new Produit(rs.getInt("id_produits"), rs.getString("nomProd"), rs.getString("description"), rs.getFloat("prix"));
                list.add(new Promotion(rs.getInt("id"), rs.getString("type"), rs.getFloat("taux"),pr)) ;  
            } 
        } catch (SQLException ex) {  
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return list ; 
    }

    @Override
    public void Delete(int id) { 
              String req=" DELETE FROM promotion WHERE id="+id;  
        try {  
               st=cnx.createStatement() ; 
               st.executeUpdate(req) ; 
            System.out.println("bien supprimer");
        }catch (SQLException ex) { 
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void Update(int id , String type , float taux) {
       String req=" UPDATE promotion SET type='"+type+"',taux="+taux+" WHERE id="+id;  
        try {  
               st=cnx.createStatement() ; 
               st.executeUpdate(req) ; 
            System.out.println("Promotion modifié");
        }catch (SQLException ex) { 
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);

        }    }   
    public void Updateprix(int id ,int id_pr) { 
        float k = calculerpromo(id_pr);
       String req=" UPDATE  promotion pr INNER JOIN produits p on pr.id_produits=p.id AND pr.id_produits= "+id_pr+ " SET p.prix="+k+"WHERE pr.id = "+id;  
        try {  
               st=cnx.createStatement() ; 
               st.executeUpdate(req) ; 
            System.out.println("Promotion modifié");
        }catch (SQLException ex) { 
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);

        }    }  
    
    
    public float getProduitPrix(int id) {  
        
            
        String req = "SELECT * from promotion pr INNER JOIN produits p on pr.id_produits=p.id AND pr.id_produits="+id ;
        

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
     public float  calculerpromo(int id )  
     { 
          String req = "SELECT * FROM promotion WHERE id_produits="+id ;  
        float prix = getProduitPrix(id);
        float  k=0;
        
        try {
            st=cnx.createStatement() ; 
            rs=st.executeQuery(req);  
           while(rs.next())
           {
                  k = rs.getFloat("taux"); 
       
           
           }
          
        } catch (SQLException ex) {  
            Logger.getLogger(LocationService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return (k*prix)/100;
     } 
     public List<Promotion> rechercherParType(String type) {  
        List<Promotion> list = new ArrayList<>() ;
        String req = "select * from promotion pr INNER JOIN produits p on pr.id_produits=p.id WHERE pr.type='"+type+"'";   
        Produit pr;  ;
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
                  pr=new Produit(rs.getInt("id_produits"), rs.getString("nomProd"), rs.getString("description"), rs.getFloat("prix"));
                list.add(new Promotion(rs.getInt("id"), rs.getString("type"), rs.getFloat("taux"),pr)) ;  
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
   
}

   

