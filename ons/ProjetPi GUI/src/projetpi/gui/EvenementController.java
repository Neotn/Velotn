/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetpi.gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import projet.Entite.evenement;
import projet.Entite.reclamation;
import projet.Services.serviceEvenement;

/**
 * FXML Controller class
 *
 * @author Ons
 */
public class EvenementController implements Initializable {
    serviceEvenement se = new serviceEvenement();
    /**
     * Initializes the controller class.
     */
 @FXML
    private DatePicker date;

    @FXML
    private TextField nom;

    @FXML
    private TextField heure;

    @FXML
    private TextField description;

    @FXML
    private Button btnajouterE;

    @FXML
    private Button btnsupprimerE;

    @FXML
    private TableColumn<evenement, String> nomE;

    @FXML
    private TableColumn<evenement, String> heureE;

    @FXML
    private TableColumn<evenement, String> dateE;
    
    @FXML
    private TableColumn<evenement,Integer> id;
    
    @FXML
    private TableView<evenement> listeEvenements;

    @FXML
    private TableColumn<evenement, String> descriptionE;
    
    
    private final ObservableList<evenement> data = FXCollections.observableArrayList();
    private List<evenement> evenements = new ArrayList<>();
    
    private void listeEvenements() throws SQLException
    {
        listeEvenements.setItems(null);
        data.clear();
        evenements = se.readAll();
 
        for(evenement evenement:evenements)
        {
            data.add(evenement);
        }
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomE.setCellValueFactory(new PropertyValueFactory<>("nom"));
        heureE.setCellValueFactory(new PropertyValueFactory<>("heure"));
        dateE.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionE.setCellValueFactory(new PropertyValueFactory<>("description"));

        listeEvenements.setItems(data);
        listeEvenements.setEditable(true);
        
        id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        nomE.setCellFactory(TextFieldTableCell.forTableColumn());
        heureE.setCellFactory(TextFieldTableCell.forTableColumn());
        dateE.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionE.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listeEvenements();
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    @FXML
   void ajouterEvenement(ActionEvent event) throws SQLException {
       DatePicker tmpdated=(DatePicker) date;
        String dated= (String) tmpdated.getValue().toString();
       se.ajouter(new evenement(nom.getText(), heure.getText(), dated,description.getText()));
       listeEvenements();
       
    }
    
@FXML
    void SupprimerEvenement(ActionEvent event) throws SQLException
    {
        ObservableList<evenement> tous,Single ;
             tous=listeEvenements.getItems();
             Single=listeEvenements.getSelectionModel().getSelectedItems();
             evenement e = Single.get(0);
             se.delete(e);
             Single.forEach(tous::remove);
    }
    public void Change_nom(TableColumn.CellEditEvent bb) throws SQLException{
     evenement Evenementselected = listeEvenements.getSelectionModel().getSelectedItem();
     Evenementselected.setNom((bb.getNewValue().toString()));
     se.update(Evenementselected);
 }
    public void Change_heure(TableColumn.CellEditEvent bb) throws SQLException{
     evenement Evenementselected = listeEvenements.getSelectionModel().getSelectedItem();
     Evenementselected.setHeure((bb.getNewValue().toString()));
     se.update(Evenementselected);
 }
    public void Change_date(TableColumn.CellEditEvent bb) throws SQLException{
     evenement Evenementselected = listeEvenements.getSelectionModel().getSelectedItem();
     Evenementselected.setDate((bb.getNewValue().toString()));
     se.update(Evenementselected);
 }
    public void Change_desc(TableColumn.CellEditEvent bb) throws SQLException{
     evenement Evenementselected = listeEvenements.getSelectionModel().getSelectedItem();
     Evenementselected.setDescription((bb.getNewValue().toString()));
     se.update(Evenementselected);
 }
   /*public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<evenement> filteredData = new FilteredList<>(data, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(evenements -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (evenements.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (evenements.getHeure().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
                                } else if (evenements.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
                                } else if (evenements.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
                                }
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<evenement> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(readAll.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		readAll.setItems(sortedData);
    }
    */

}
