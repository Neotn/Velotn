/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpi.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Ons
 */
public class HomeController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button btnReclamations;
    
    @FXML 
    private Button btnEvenements;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        label.setText("Hello World!");
    }
   
    @FXML
    private void gotoReclamation() throws IOException
    {
        Stage stage;
        Parent root;
        
        
        System.out.println("You clicked me!");
        stage = (Stage) btnReclamations.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("reclamation.fxml"));
        stage.setScene(new Scene(root));
        
        
    }
    
    @FXML
    private void gotoEvenement() throws IOException
    {
 Stage stage;
        Parent root;
       
        
        System.out.println("You clicked me!");
        stage = (Stage) btnReclamations.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("evenement.fxml"));
        stage.setScene(new Scene(root));
    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
