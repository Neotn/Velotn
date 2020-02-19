/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcrud; 
import service.PromotionService ;  
import entity.Promotion ;  
import entity.Location; 
import entity.User ; 
import entity.Velo;
import java.text.SimpleDateFormat;
import java.util.Date;
import service.LocationService ;
import entity.Produit ; 
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author khalil
 */
public class Testcrud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        DataSource ds1=DataSource.getInstance();
        System.out.println(ds1);   
        List<Produit> list = new ArrayList<>() ; 
        
        Produit p1 = new Produit(1, "vtt", "sdhshd", 20);
        Produit p2 = new Produit(2, "ttt", "sdhshd", 50); 
        Promotion pr1 = new Promotion(1,"promo", 50, p1);   
         Promotion pr2 = new Promotion(2,"promo", 20, p2);   
        
        PromotionService ps = new PromotionService() ;  
       //ps.insertPromotion(pr1);  
             // ps.Updateprix(1,1);
        //ps.insertPromotion(pr2);  
               //ps.Updateprix(2,2);
     //  ps.Update(1,"Noel",30) ;
        //ps.Delete(1);  
       //ps.displaAll().forEach(System.out::println); 
      //ps.rechercherParType("promo").forEach(System.out::println);
      //ps.Update(0, type, 0);
//---------------------------------------------------------------------------------------------------------------------------------------------- 
Velo v1 = new Velo(1, "vtt", "sdhshd", 20, "mercedes", "tir"); 
        Velo v2 = new Velo( 2, "ttt", "sdhshd", 50, "peugeot", "tejri");
        User u1 = new User(12, "fm","f@esprit.tn", "154", "f", "m ", "1970-01-01", "21456654", "in", "m") ;
    LocationService ls = new LocationService() ; 
        Location  l1 = new Location(u1,"2020-03-04","2020-03-07",0,v1); 
        Location l2 = new Location(u1,"2020-07-10","2020-07-15",0,v2);  
        
       //ls.insertLocation(l1);   
        //ls.UpdatePrix(6,ls.calculer(2),2);
       //ls.Update(12,"2020-03-10","2020-03-20",1);  
         //ls.UpdatePrix(12,ls.calculer(1),1); 
    // ls.insertLocation(l2); 
       // ls.UpdatePrix(12,ls.calculer(2),2);  
         //ls.displaAll().forEach(System.out::println);
//        ls.TrierParPrix().forEach(System.out::println);
//           ls.rechercherParid(12).forEach(System.out::println); 
         // ls.DeleteProduitLocation(2); 
           //ls.DeleteUserLocation(12);
   
    }
    
}
