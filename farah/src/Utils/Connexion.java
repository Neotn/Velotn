/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Farah GABSI
 */
public class Connexion {
    private static String url="jdbc:mysql://localhost:3306/wecode";
    private static String usr="root";
    private static String pwd="";
    private static Connexion cbd;
    private static Connection cnx;
    
    public static Connection getCnx(){
        return cnx;
    }
    
    private Connexion () {
        try {
            cnx=DriverManager.getConnection(url, usr, pwd);    
            System.out.println("Connexion etabli");
        } catch (SQLException ex) {
            System.out.println("erreu"+ex.getMessage());
        }
    }
     public static Connexion getinstance () {
         if (cbd==null)
             cbd=new Connexion();
         return cbd;
     }
    
    
}
