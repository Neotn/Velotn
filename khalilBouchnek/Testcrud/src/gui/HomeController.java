/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class HomeController implements Initializable {

    @FXML
    private BorderPane bp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     

    @FXML
    private void Promotion(MouseEvent event) { 
        Loadp("Promotion");
    }

    @FXML
    private void Location(MouseEvent event) { 
                Loadp("Location");

    }
     private void Loadp(String p) 
     {  
         Parent root = null ; 
        try { 
           root = FXMLLoader.load(getClass().getResource(p+".fxml")) ;
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         bp.setCenter(root);
     }
    
    
}
