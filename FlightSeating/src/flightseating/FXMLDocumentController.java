/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseating;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Trelia
 */
public class FXMLDocumentController implements Initializable {
    
  
    @FXML
    private TextField txtName;
    @FXML
    private ComboBox<String> AgeComboBox;
    @FXML
    private ComboBox<String> ClassComboBox;
    @FXML
    private ComboBox<String> SeatTypeCombo;
    @FXML
    private TableView<Seating> FlightSeatsGrid;
    @FXML
    private TableColumn<Seating, String> rows;
    @FXML
    private TableColumn<Seating, String> A;
    @FXML
    private TableColumn<Seating, String> B;
    @FXML
    private TableColumn<Seating, String> C;
    @FXML
    private TableColumn<Seating, String> D;
    @FXML
    private TableColumn<Seating, String> E;
    @FXML
    private TableColumn<Seating, String> F;
     @FXML
    private TableView<Customer> customerlist;
    @FXML
    private TableColumn<Customer, String> Names;
    @FXML
    private TableColumn<Customer, String> ageGroup;
    @FXML
    private TableColumn<Customer, String> flightClass;
    @FXML
    private TableColumn<Customer, String> perferedSeat;
    @FXML
    private TableColumn<Customer, Integer > row;
    @FXML
    private TableColumn<Customer, Integer> col;

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
   
   
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    setTableView();
    setComboBox();
    }    
    
    /**
     * Closes the program but also will call the write to file method
     * @param event 
     */
    @FXML
    private void Close_Click(ActionEvent event) {
       System.exit(0);
    }

    @FXML
    private void DeleteSeat_Click(ActionEvent event) {
    }

    @FXML
    private void AddCustomer_click(ActionEvent event) {
        //JOptionPane.showMessageDialog(null, AgeComboBox.getValue() +  ClassComboBox.getValue() + SeatTypeCombo.getValue());
    }
    
    /***
     * Adds information to a table view
     */
    public void setTableView(){
              ArrayList<Seating> list = new ArrayList<>();

       for(int i = 0; i < plane.length; i++){
           
           list.add(new Seating(plane[i][0], plane[i][1], plane[i][2], plane[i][3], plane[i][4], plane[i][5], plane[i][6]));
          // System.out.println(plane[i][0] + plane[i][1]+ plane[i][2]+ plane[i][3]+ plane[i][4]+ plane[i][5]+ plane[i][6]);
       } 
       ObservableList<Seating> list2 = FXCollections.observableArrayList(list);                      
        rows.setCellValueFactory(data -> data.getValue().PropertyRows());
        A.setCellValueFactory(data -> data.getValue().PropertyA());
        B.setCellValueFactory(data -> data.getValue().PropertyB()); 
        C.setCellValueFactory(data -> data.getValue().PropertyC()); 
        D.setCellValueFactory(data -> data.getValue().PropertyD()); 
        E.setCellValueFactory(data -> data.getValue().PropertyE()); 
        F.setCellValueFactory(data -> data.getValue().PropertyF()); 
        FlightSeatsGrid.setItems(list2);
    }
    
    /**
     * Sets all combo boxes required in this program
     */
    public void setComboBox(){
      String AgeCombo[] = {"Adult" , "Child"};
      String SeatType[] = {"Window", "Middle", "Aisle"}; 
      String ClassCombo[] = {"First", "Business", "Economy"};
      //AgeComboBox.setItems();
        AgeComboBox.getItems().addAll(AgeCombo);
        SeatTypeCombo.getItems().addAll(SeatType);
        ClassComboBox.getItems().addAll(ClassCombo);
    } 
    
    
}
