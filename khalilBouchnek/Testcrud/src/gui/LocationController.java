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
import entity.Promotion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
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
    private TableColumn<Location,Number> idvelo;

    LocationService ls = new LocationService() ;   
           List<Location> locations = new ArrayList<>() ;  

       private final ObservableList<Location> data = FXCollections.observableArrayList() ;
         private final ObservableList<Integer> dataidv = FXCollections.observableArrayList(ls.get_id_velo());  
           private final ObservableList<Integer> dataidu = FXCollections.observableArrayList(ls.get_id_user()); 
    @FXML
    private Button supprimer;
    @FXML
    private TextField recherche;
    @FXML
    private TableColumn<Location,Float> prixtotal;


    /**
     * Initializes the control  ler class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       comv.setItems(dataidv); 
       comu.setItems(dataidu);  
       
       Aff(); 
       RechercheAV();
       
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
        int id = ls.insertLocation(l); 
                  
       ls.UpdatePrix(id,ls.calculer(Integer.parseInt(tmpcmbv.getValue().toString())),Integer.parseInt(tmpcmbv.getValue().toString()));  
     
        Aff();
        RechercheAV(); 
        
                
    } 
    public void Aff() 
    {  data.clear(); 
        locations =ls.displaAll() ;
        for (Location location : locations) {
           data.add(location);
        }
        idlocation.setCellValueFactory(new PropertyValueFactory<>("id")) ;  
        dd.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        df.setCellValueFactory(new PropertyValueFactory<>("date_fin"));  
        iduser.setCellValueFactory(e-> new SimpleIntegerProperty(e.getValue().getUser().getId()));  
         idvelo.setCellValueFactory(e-> new SimpleIntegerProperty(e.getValue().getVelo().getId())); 
         prixtotal.setCellValueFactory(new PropertyValueFactory<>("prixtotal")); 

         tablocation.setItems(data);  
         tablocation.setEditable(true);

         idlocation.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter())) ; 
         dd.setCellFactory(TextFieldTableCell.forTableColumn()); 
         df.setCellFactory(TextFieldTableCell.forTableColumn());
         iduser.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter())) ; 
         idvelo.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
         prixtotal.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        
        
    }

    @FXML
    private void buttonSupprimer(ActionEvent event) { 
          tablocation.setItems(data);

             ObservableList<Location> allDemandes,SingleDemandes ;
             allDemandes=tablocation.getItems();
             SingleDemandes=tablocation.getSelectionModel().getSelectedItems();
             Location A = SingleDemandes.get(0);
             LocationService STP = new LocationService();
             STP.DeleteUserLocation(A.getId());
             SingleDemandes.forEach(allDemandes::remove); 
             Aff(); 
             RechercheAV();
    } 
    
    public void RechercheAV(){
        FilteredList<Location> filteredData = new FilteredList<>(data, b -> true);
		
		recherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(tab_location -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
			
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (String.valueOf(tab_location.getPrixtotal()).indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} 
				else if (String.valueOf(tab_location.getId()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false;
			});
		});
		
		
		SortedList<Location> sortedData = new SortedList<>(filteredData);
		
		
		sortedData.comparatorProperty().bind(tablocation.comparatorProperty());
		
		
		tablocation.setItems(sortedData);
   
 } 

    @FXML
    private void change_dd(TableColumn.CellEditEvent bb) {  
                 Location tab_Promotionelected =tablocation.getSelectionModel().getSelectedItem();
    tab_Promotionelected.setDate_debut(bb.getNewValue().toString());
        ls.Update(tab_Promotionelected.getId(),tab_Promotionelected.getDate_debut(),tab_Promotionelected.getDate_fin()); 
        ls.UpdatePrix(tab_Promotionelected.getId(),ls.calculer(tab_Promotionelected.getVelo().getId()),tab_Promotionelected.getVelo().getId()); 
           Aff();
        RechercheAV();
    }

    @FXML
    private void change_df(TableColumn.CellEditEvent bb) { 
        
                 Location tab_Promotionelected =tablocation.getSelectionModel().getSelectedItem();
    tab_Promotionelected.setDate_fin(bb.getNewValue().toString());
        ls.Update(tab_Promotionelected.getId(),tab_Promotionelected.getDate_debut(),tab_Promotionelected.getDate_fin()); 
        ls.UpdatePrix(tab_Promotionelected.getId(),ls.calculer(tab_Promotionelected.getVelo().getId()),tab_Promotionelected.getVelo().getId()); 
           Aff();
        RechercheAV();  

    }
    }

  
    

