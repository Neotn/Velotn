/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velo;

import Entities.Adresse;
import Entities.Groups;
import Entities.User;
import Service.ServiceAdresse;
import Service.ServiceGroupe;
import Service.ServiceUser;
import java.sql.Date;

/**
 *
 * @author Farah GABSI
 */
public class Velo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here1    
Groups g= new Groups("farah",1,"ahla","haha",0);
ServiceGroupe sg = new ServiceGroupe();
sg.ajouterGroupe(g);
        System.out.println(sg.RechercheGroupeParNom("farah"));

//sg.supprimerGroupe(g3);
User u1 = new User("ma222", "@", "12", "f", "fd", new Date(1994, 1, 19), "32", "zj", "hg");
User u2 = new User( "farah", "@", "12", "f", "fd", new Date(96, 1, 1), "32", "zj", "hg");
ServiceUser su =new ServiceUser();
su.ajouterUser(u1);
su.afficherUser();
        System.out.println("******");
su.supprimerUser(u1);
su.afficherUser();

ServiceAdresse sd= new ServiceAdresse();
Adresse d1 = new Adresse(1223, "Tunisie", "Sousse", 400, "arriana");
Adresse d2 = new Adresse(124, "Tunisie", "Tunis", 300, "issat");
Adresse d3 = new Adresse(124, "Tunisie", "Bizerte", 300, "issat");
/*sd.ajouterAdresse(d1);
sd.ajouterAdresse(d2);
sd.afficherAdresse();
        System.out.println("*********");
sd.modifierAdresse(124, d3);
sd.afficherAdresse();
        System.out.println("******");*/
//sd.supprimerAdresse(d3);
//sd.afficherAdresse();
  


boolean isAuth = su.Authentifier("farah2222", "12");
        System.out.println("isAuth = "+isAuth);

        System.out.println("connected user : " + su.getConnectedUser().toString());

    }
    
}
