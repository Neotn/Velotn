/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView; 
import entity.Location ; 
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.LocationService ;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class LocationController implements Initializable {

    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private ComboBox<Integer> comv;
    @FXML
    private ComboBox<Integer> comu;
    @FXML
    private TableView<Location> tablocation;
    @FXML
    private TableColumn<Location,Integer> idlocation;
    @FXML
    private TableColumn<Location,Number> iduser;
    @FXML
    private TableColumn<Location,String> dd;
    @FXML
    private TableColumn<Location,String> df; 
    @FXML   
    private TableColumn<Location,String> idvelo;

    LocationService ls = new LocationService() ; 
         private final ObservableList<Integer> dataidv = FXCollections.observableArrayList(ls.get_id_velo());  
           private final ObservableList<Integer> dataidu = FXCollections.observableArrayList(ls.get_id_user()); 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       comv.setItems(dataidv); 
       comu.setItems(dataidu);
       
    }    

    @FXML
    private void Ajouter(ActionEvent event) throws SQLException  {
        DatePicker tmpdated=(DatePicker) date_debut;
        String dated= (String) tmpdated.getValue().toString();  
        DatePicker tmpdatef=(DatePicker) date_fin;
        String datef= (String) tmpdatef.getValue().toString();  
         ComboBox tmpcmbu = (ComboBox) comu; 
         ComboBox tmpcmbv = (ComboBox) comv;
        Location l = new Location(ls.rechercheu(Integer.parseInt(tmpcmbu.getValue().toString())), dated, datef,ls.recherchev(Integer.parseInt(tmpcmbv.getValue().toString()))) ;  
        ls.insertLocation(l);
        
        
                
    }
    
}
