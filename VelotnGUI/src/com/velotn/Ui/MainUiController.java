package com.velotn.Ui;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainUiController implements Initializable {
    @FXML
    private HBox parent;

    @FXML
    private VBox contentArea;

    @FXML
    private JFXButton commande;

    @FXML
    private Pane displayArea;

    @FXML
    private JFXButton don;

    @FXML
    private JFXButton connect;

    @FXML
    void close_app(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void minimize_app(MouseEvent event) {
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void open_don(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("DonUi.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("DonUi.fxml"));
        //DonUiController donController = loader.getController();
        displayArea.getChildren().removeAll();
        displayArea.getChildren().setAll(fxml);
        //donController.setData();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
