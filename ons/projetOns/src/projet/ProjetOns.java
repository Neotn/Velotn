/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projet.Entite.evenement;
import projet.Entite.reclamation;
import projet.Services.serviceEvenement;
import projet.Services.serviceReclamation;

/**
 *
 * @author Ons
 */
public class ProjetOns {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        serviceEvenement se = new serviceEvenement();
        serviceReclamation sr = new serviceReclamation();
        Time t = new Time(15, 0, 0);
        Date d = new Date(120,1,9);
        List<evenement> evenements = new ArrayList<evenement>();
        List<reclamation> reclamations = new ArrayList<reclamation>();
        
        
        evenement e = new evenement(1,"test", t, d, "nouveau evenement");
        evenement e1 = new evenement(3,"test2", t, d, "bonjour");
        reclamation r = new reclamation(2, 5, "nouvelle reclamation", 1);
        reclamation r1 = new reclamation(3, 6, "reclamation", 0);
        try {
            /*se.ajouter(e);
            se.ajouter(e1);
            se.delete(e1);*/
           se.update(e1);
           //evenements=se.readAll();
            
            /*sr.ajouter(r1);
            sr.ajouter(r);
            sr.delete(r*/
            //sr.update(r1);
            //reclamations=sr.readAll();
            
            //sr.ajouter(r1);
            
            
            // TODO code application logic here
        } catch (SQLException ex) {
            Logger.getLogger(ProjetOns.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //evenements.forEach((ev)->System.out.println(ev));
        reclamations.forEach((re)->System.out.println(re));
        
        
    }
    
}
