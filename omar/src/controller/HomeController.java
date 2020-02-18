package controller;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class HomeController {

    @FXML
    private Button gestionStock;
    
    @FXML
    private AnchorPane rootPane;
    
    public HomeController() {	
    	
    }
    
    @FXML
    private void onMouseEnter(MouseEvent event)
    {
    	gestionStock.setStyle("-fx-background-color: #D3EDF3; -fx-border-width: 0; -fx-background-radius: 0; -fx-border-color: transparent; -fx-font-size: 16; -fx-text-fill: #828282;");	
    }
    
    @FXML
    void onMouseExit(MouseEvent event)
    {
    	gestionStock.setStyle("-fx-background-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-border-color: transparent; -fx-font-size: 16; -fx-text-fill: #828282;");	
    }
    
    @FXML
    void onGestionStockClicked(MouseEvent event) throws IOException {
    	
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("../gui/GestionStock.fxml"));
    	rootPane.getChildren().setAll(pane);
    	
    	

    }
}
