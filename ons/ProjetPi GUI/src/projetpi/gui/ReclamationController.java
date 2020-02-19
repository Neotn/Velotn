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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import projet.Entite.reclamation;
import projet.Services.serviceReclamation;

/**
 * FXML Controller class
 *
 * @author Ons
 */
public class ReclamationController implements Initializable {
   
    /**
     * Initializes the controller class.
     */
     serviceReclamation sr = new serviceReclamation();
     @FXML
    private TextField idUser;

    @FXML
    private TextField descriptionR;

    @FXML
    private TextField etat;

    @FXML
    private TableView<reclamation> listeReclamations;

    @FXML
    private TableColumn<reclamation, Integer> id;

    @FXML
    private TableColumn<reclamation, Integer> idUserR;

    @FXML
    private TableColumn<reclamation, String> description;

    @FXML
    private TableColumn<reclamation, Integer> etatR;
    
    private final ObservableList<reclamation> data = FXCollections.observableArrayList();
    private List<reclamation> reclamations = new ArrayList<>();

    
    private void listeReclamations() throws SQLException
    {
        reclamations = sr.readAll();
        for(reclamation reclamation:reclamations)
        {
            data.add(reclamation);
        }
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        idUserR.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        description.setCellValueFactory(new PropertyValueFactory<>("descriptionR"));
        etatR.setCellValueFactory(new PropertyValueFactory<>("etat"));
        
        listeReclamations.setItems(data);
        listeReclamations.setEditable(true);
        
        id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        idUserR.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        etatR.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             listeReclamations();
         } catch (SQLException ex) {
             Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }   
    
    @FXML
    void ajouterReclamation(ActionEvent event) throws SQLException {
       sr.ajouter(new reclamation(1, descriptionR.getText(), Integer.parseInt(etat.getText())));
    }
    
    @FXML
    void SupprimerReclamation(ActionEvent event) throws SQLException
    {
        ObservableList<reclamation> tous,Single ;
             tous=listeReclamations.getItems();
             Single=listeReclamations.getSelectionModel().getSelectedItems();
             reclamation r = Single.get(0);
             sr.delete(r);
             Single.forEach(tous::remove);
    }
public void Change_idUser(TableColumn.CellEditEvent bb) throws SQLException{
     reclamation Reclamationselected = listeReclamations.getSelectionModel().getSelectedItem();
     Reclamationselected.setIdUser(Integer.parseInt(bb.getNewValue().toString()));
     sr.update(Reclamationselected);
 }
    public void Change_descriptionR(TableColumn.CellEditEvent bb) throws SQLException{
     reclamation Reclamationselected = listeReclamations.getSelectionModel().getSelectedItem();
     Reclamationselected.setDescriptionR(bb.getNewValue().toString());
     sr.update(Reclamationselected);
 }
    public void Change_etat(TableColumn.CellEditEvent bb) throws SQLException{
     reclamation Reclamationselected = listeReclamations.getSelectionModel().getSelectedItem();
     Reclamationselected.setEtat(Integer.parseInt(bb.getNewValue().toString()));
     sr.update(Reclamationselected);
 }
}
