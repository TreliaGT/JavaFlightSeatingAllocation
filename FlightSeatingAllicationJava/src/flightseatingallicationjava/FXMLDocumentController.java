/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseatingallicationjava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;

/**
 *
 * @author Trelia
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private TableView<String[][]> FlightSeatsGrid;
    @FXML
    private TextField txtName;
    @FXML
    private ComboBox<?> AgeComboBox;
    @FXML
    private ComboBox<?> ClassComboBox;
    @FXML
    private ComboBox<?> SeatTypeCombo;
    private TableView<?> tableView;
    
         String plane[][] ={
        {"Row 1", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 2", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 3", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 4", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 5", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 6", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 7", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 8", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 9", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 10", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 11", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
          {"Row 12", "*" ,"*" ,"*" ,"*" ,"*" , "*"},
    };
    @FXML
    private TableColumn<?, ?> rows;
    @FXML
    private TableColumn<?, ?> A;
    @FXML
    private TableColumn<?, ?> B;
    @FXML
    private TableColumn<?, ?> C;
    @FXML
    private TableColumn<?, ?> D;
    @FXML
    private TableColumn<?, ?> E;
    @FXML
    private TableColumn<?, ?> F;

   
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList row = FXCollections.observableArrayList(plane);

            tableView.setItems(row);
    }    

    @FXML
    private void Close_Click(ActionEvent event) {
        
    }

    @FXML
    private void DeleteSeat_Click(ActionEvent event) {
    }

    @FXML
    private void AddCustomer_click(ActionEvent event) {
    }
   
}
