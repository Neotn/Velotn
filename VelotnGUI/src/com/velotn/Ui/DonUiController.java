package com.velotn.Ui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.velotn.Entite.Don;
import com.velotn.Service.ServiceDon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.math.RoundingMode;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import static java.lang.Float.parseFloat;

public class DonUiController implements Initializable {
    @FXML
    private JFXTextField donTextField;

    @FXML
    private JFXComboBox<String> donComboBox;
    ObservableList<String> list = FXCollections.observableArrayList("TND","EUR","USD");

    @FXML
    void addDonation(ActionEvent event) {
        float sum = parseFloat(donTextField.getText());
        ServiceDon serviceDon = new ServiceDon();
        if(donComboBox.getValue().equals("TND")){
            sum = sum;
        }
        else if(donComboBox.getValue().equals("USD")){
            sum *= 2.85440;
        }
        else if(donComboBox.getValue().equals("EUR")){
            sum *= 3.08065;
        }
        Don d = new Don(sum,1);
        try{
            serviceDon.ajouter(d);
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        donComboBox.setItems(list);
        donComboBox.setValue("TND");

    }
}
