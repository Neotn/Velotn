package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entity.Accessoire;
import entity.Piece_Rechange;
import entity.Produit;
import entity.Velo;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import service.ServiceProduit;

public class GestionStockController implements Initializable {
	
	@FXML
    private TableView<Produit> listeProduits;

    @FXML
    private TableView<Velo> listeVelos;

    @FXML
    private TableView<Piece_Rechange> listePieces;

    @FXML
    private TableView<Accessoire> listeAccessoires;
    
    @FXML
    private TableColumn<Produit, Integer> identifiant;

    @FXML
    private TableColumn<Produit, String> Nom_Produit ;
    
    @FXML
    private TableColumn<Produit, String> Description ;
    
    @FXML
    private TableColumn<Produit, Float> Prix;
    
    @FXML
    private TableColumn<Produit, String> Marque ;
    
    @FXML
    private TableColumn<Produit, String> Type ;
    
    @FXML
    private TableColumn<Produit, Integer> Quantite ;
    
    @FXML
    private TableColumn<Velo, String> nomV;

    @FXML
    private TableColumn<Velo, Number> identifiantV;
    
    @FXML
    private TableColumn<Velo, String> DescriptionV;

    @FXML
    private TableColumn<Velo, Float> PrixV;

    @FXML
    private TableColumn<Velo, String> MarqueV;

    @FXML
    private TableColumn<Velo, String> TypeV;

    @FXML
    private TableColumn<Velo, Integer> QuantiteV;
    
    @FXML
    private TableColumn<Piece_Rechange, Number> identifiantP;

    @FXML
    private TableColumn<Piece_Rechange, String> nomP;

    @FXML
    private TableColumn<Piece_Rechange, String> descriptionP;

    @FXML
    private TableColumn<Piece_Rechange, Float> prixP;

    @FXML
    private TableColumn<Piece_Rechange, String> marqueP;

    @FXML
    private TableColumn<Piece_Rechange, String> typeP;

    @FXML
    private TableColumn<Piece_Rechange, Integer> quantiteP;
    
    @FXML
    private TableColumn<Accessoire, Number> identifiantA;

    @FXML
    private TableColumn<Accessoire, String> nomA;

    @FXML
    private TableColumn<Accessoire, String> descriptionA;

    @FXML
    private TableColumn<Accessoire, Float> prixA;

    @FXML
    private TableColumn<Accessoire, String> marqueA;

    @FXML
    private TableColumn<Accessoire, String> typeA;

    @FXML
    private TableColumn<Accessoire, Integer> quantiteA;


    
    private final ObservableList<Produit> data = FXCollections.observableArrayList();
    private final ObservableList<Velo> dataV = FXCollections.observableArrayList();
    private final ObservableList<Piece_Rechange> dataP = FXCollections.observableArrayList();
    private final ObservableList<Accessoire> dataA = FXCollections.observableArrayList();


    
    
    
    private List<Produit> produits = new ArrayList<>();
    private List<Velo> velos = new ArrayList<>();
    private List<Piece_Rechange> Pieces = new ArrayList<>();
    private List<Accessoire> accessoires = new ArrayList<>();
    ServiceProduit sp = new ServiceProduit();
	
	
	public GestionStockController() {
		
		
	}
	
	private void listProducts()
	{
		produits= sp.displayProducts();
		data.clear();
		
		
		for (Produit produit : produits) {
			data.add(produit);
		}
		identifiant.setCellValueFactory(new PropertyValueFactory<>("id"));
		Nom_Produit.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
		Description.setCellValueFactory(new PropertyValueFactory<>("description"));
		Prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
		Marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
		Type.setCellValueFactory(new PropertyValueFactory<>("type"));
		Quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
		
		listeProduits.setItems(data);
		
		identifiant.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		Nom_Produit.setCellFactory(TextFieldTableCell.forTableColumn());
		Description.setCellFactory(TextFieldTableCell.forTableColumn());
		Prix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
		Marque.setCellFactory(TextFieldTableCell.forTableColumn());
		Type.setCellFactory(TextFieldTableCell.forTableColumn());
		Quantite.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	
	}
	
	private void listVelos() {
		
		velos= sp.displayVelos();
		dataV.clear();
		
		
		for (Velo velo : velos) {
			dataV.add(velo);
			
		}
		identifiantV.setCellValueFactory(e-> new SimpleIntegerProperty(e.getValue().getId()));
		nomV.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
		DescriptionV.setCellValueFactory(new PropertyValueFactory<>("description"));
		PrixV.setCellValueFactory(new PropertyValueFactory<>("prix"));
		MarqueV.setCellValueFactory(new PropertyValueFactory<>("marque"));
		TypeV.setCellValueFactory(new PropertyValueFactory<>("type"));
		QuantiteV.setCellValueFactory(new PropertyValueFactory<>("quantite"));
		
		listeVelos.setItems(dataV);
		
		identifiantV.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
		nomV.setCellFactory(TextFieldTableCell.forTableColumn());
		DescriptionV.setCellFactory(TextFieldTableCell.forTableColumn());
		PrixV.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
		MarqueV.setCellFactory(TextFieldTableCell.forTableColumn());
		TypeV.setCellFactory(TextFieldTableCell.forTableColumn());
		QuantiteV.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
		
		
	}
	
	private void listPieces() {
		Pieces= sp.displayPieces();
		dataP.clear();
		
		
		for (Piece_Rechange piece : Pieces) {
			dataP.add(piece);
			
		}
		identifiantP.setCellValueFactory(e-> new SimpleIntegerProperty(e.getValue().getId()));
		nomP.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
		descriptionP.setCellValueFactory(new PropertyValueFactory<>("description"));
		prixP.setCellValueFactory(new PropertyValueFactory<>("prix"));
		marqueP.setCellValueFactory(new PropertyValueFactory<>("marque"));
		typeP.setCellValueFactory(new PropertyValueFactory<>("type"));
		quantiteP.setCellValueFactory(new PropertyValueFactory<>("quantite"));
		
		listePieces.setItems(dataP);
		
		identifiantP.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
		nomP.setCellFactory(TextFieldTableCell.forTableColumn());
		descriptionP.setCellFactory(TextFieldTableCell.forTableColumn());
		prixP.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
		marqueP.setCellFactory(TextFieldTableCell.forTableColumn());
		typeP.setCellFactory(TextFieldTableCell.forTableColumn());
		quantiteP.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
	}
	private void listAccessoires() {
		accessoires= sp.displayAccesoires();
		dataA.clear();
		
		
		for (Accessoire accessoire : accessoires) {
			dataA.add(accessoire);
			
		}
		identifiantA.setCellValueFactory(e-> new SimpleIntegerProperty(e.getValue().getId()));
		nomA.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
		descriptionA.setCellValueFactory(new PropertyValueFactory<>("description"));
		prixA.setCellValueFactory(new PropertyValueFactory<>("prix"));
		marqueA.setCellValueFactory(new PropertyValueFactory<>("marque"));
		typeA.setCellValueFactory(new PropertyValueFactory<>("type"));
		quantiteA.setCellValueFactory(new PropertyValueFactory<>("quantite"));
		
		listeAccessoires.setItems(dataA);
		
		identifiantA.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
		nomA.setCellFactory(TextFieldTableCell.forTableColumn());
		descriptionA.setCellFactory(TextFieldTableCell.forTableColumn());
		prixA.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
		marqueA.setCellFactory(TextFieldTableCell.forTableColumn());
		typeA.setCellFactory(TextFieldTableCell.forTableColumn());
		quantiteP.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
	}
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		listProducts();
		listVelos();
		listPieces();
		listAccessoires();
	
		
		
	}
	
}