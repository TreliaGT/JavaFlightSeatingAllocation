/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseatingallicationjava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Trelia
 */
public class FXMLDocumentController implements Initializable {
    
   
    String plane[][] = new String[12][6]; 
    @FXML
    private TableView<?> FlightSeatsGrid;
    @FXML
    private TextField txtName;
    @FXML
    private ComboBox<?> AgeComboBox;
    @FXML
    private ComboBox<?> ClassComboBox;
    @FXML
    private ComboBox<?> SeatTypeCombo;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
