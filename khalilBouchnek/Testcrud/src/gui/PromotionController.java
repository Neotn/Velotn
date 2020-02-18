/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.PromotionService; 
import entity.Promotion ;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
/**
 * FXML Controller class
 *
 * @author khalil
 */
public class PromotionController implements Initializable {

    @FXML
    private TextField tftype;
    @FXML
    private TextField tftaux;
    @FXML
    private TableView<Promotion> tablePromotion;
    @FXML
    private TableColumn<Promotion,Integer> idpromotion;
    @FXML
    private TableColumn<Promotion,String> typepromotion;
    @FXML
    private TableColumn<Promotion,Float> tauxpromotion;   
     
     @FXML
    private TableColumn<Promotion,Number> idproduit;  
     @FXML
     private TableColumn<Promotion,Number> Prix;

    
      PromotionService ps = new PromotionService(); 
       
       List<Promotion> promotions = new ArrayList<>() ;  
        private final ObservableList<Promotion> data = FXCollections.observableArrayList() ; 
    @FXML
    private Button supprimer;
    @FXML
    private TextField recherche;
    @FXML
    private ComboBox<Integer> combo; 
     private final ObservableList<Integer> dataid = FXCollections.observableArrayList(ps.get_id_product()); 
    
   
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.setItems(dataid);
                 Aff() ; 
        RechercheAV();
    }    

 
  

    @FXML
    private void Ajouter(ActionEvent event) throws SQLException {
        String typeP = tftype.getText();
        float tauxp =Float.parseFloat(tftaux.getText()) ; 
         ComboBox tmpcmb = (ComboBox) combo;
      Promotion p = new Promotion(typeP,tauxp,ps.rechercheP(Integer.parseInt(tmpcmb.getValue().toString()))); 
      int id =ps.insertPromotion(p); 
        ps.Updateprix(id,Integer.parseInt(tmpcmb.getValue().toString()));
        Aff();
         RechercheAV(); 
         tftaux.setText(""); 
         tftype.setText(""); 
         
        
    } 
    
   
    public void Aff() 
    {  data.clear(); 
        promotions =ps.displaAll() ;
        for (Promotion promotion : promotions) {
           data.add(promotion);
        }
       idpromotion.setCellValueFactory(new PropertyValueFactory<>("id")) ;  
        typepromotion.setCellValueFactory(new PropertyValueFactory<>("type"));
        tauxpromotion.setCellValueFactory(new PropertyValueFactory<>("taux"));  
         idproduit.setCellValueFactory(e-> new SimpleIntegerProperty(e.getValue().getPro().getId()));  
         Prix.setCellValueFactory(e-> new SimpleFloatProperty(e.getValue().getPro().getPrix()));

         tablePromotion.setItems(data);  
         tablePromotion.setEditable(true);

         idpromotion.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter())) ; 
         typepromotion.setCellFactory(TextFieldTableCell.forTableColumn()); 
         tauxpromotion.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
         idproduit.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter())) ; 
         Prix.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

        
        
    }

    @FXML
    private void buttonSupprimer(ActionEvent event) { 
           tablePromotion.setItems(data);

             ObservableList<Promotion> allDemandes,SingleDemandes ;
             allDemandes=tablePromotion.getItems();
             SingleDemandes=tablePromotion.getSelectionModel().getSelectedItems();
             Promotion A = SingleDemandes.get(0);
             PromotionService STP = new PromotionService();
             STP.Delete(A.getId());
             SingleDemandes.forEach(allDemandes::remove); 
             Aff();
         RechercheAV();
    }


 public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Promotion> filteredData = new FilteredList<>(data, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		recherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(tab_demande -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (tab_demande.getType().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.				 Filter matches last name.
				}
				else if (String.valueOf(tab_demande.getId()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Promotion> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tablePromotion.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tablePromotion.setItems(sortedData);
   
 } 

    @FXML
    private void Change_Type(TableColumn.CellEditEvent bb ) { 
         Promotion tab_Promotionelected =tablePromotion.getSelectionModel().getSelectedItem();
     tab_Promotionelected.setType(bb.getNewValue().toString());
        ps.Update(tab_Promotionelected.getId(),tab_Promotionelected.getType(),tab_Promotionelected.getTaux());
    }
 
 
    
}
