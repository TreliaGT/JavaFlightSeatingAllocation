/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseating;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    private TableColumn<Customer, String > row;
    @FXML
    private TableColumn<Customer, String> col;

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
   
    ArrayList<Customer> Customer = new ArrayList<Customer>();
         
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
       int I = customerlist.getSelectionModel().getSelectedIndex();
       int col = Customer.get(I).getCol();
       int row = Customer.get(I).getRow();
         plane[row][col] = "*";
         Customer.remove(I);
         setTableView();
         setCustomerTableView();
    }

    @FXML
    private void AddCustomer_click(ActionEvent event) {
        //JOptionPane.showMessageDialog(null, AgeComboBox.getValue() +  ClassComboBox.getValue() + SeatTypeCombo.getValue());
        addCustomer();
    }
    
    /***
     * Adds information to a table view
     */
    public void setTableView(){
        ArrayList<Seating> list = new ArrayList<Seating>();

        for(int i = 0; i < plane.length; i++){
            list.add(new Seating(plane[i][0], plane[i][1],plane[i][2],plane[i][3],plane[i][4],plane[i][5],plane[i][6]));
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
    
    public void setCustomerTableView(){
          ObservableList<Customer> person = FXCollections.observableArrayList(Customer);
              Names.setCellValueFactory(data -> data.getValue().PropertyName());
        ageGroup.setCellValueFactory(data -> data.getValue().PropertyAgeGroup());
        flightClass.setCellValueFactory(data -> data.getValue().PropertyFlightClass());
        perferedSeat.setCellValueFactory(data -> data.getValue().PropertyPerferedSeat());
        row.setCellValueFactory(data -> data.getValue().PropertyRowNum());
        col.setCellValueFactory(data -> data.getValue().PropertyColLetter());
        customerlist.setItems(person);
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
    
    /***
     * gets what seat type the customer would like
     */
    public void addCustomer(){
        switch(SeatTypeCombo.getValue()) {
        case "Window":
              getSeat(1, 6);
        break;
        case "Middle":
            getSeat(2, 5);
        break;
        case "Aisle":
            getSeat(3, 4);
        break;
        default:
            JOptionPane.showMessageDialog(null,"Please select SeatType");
        }
    }
    /**
     * Gets seat 
     * @param j
     * @param k
     */
    public void getSeat(int j, int k){
        for (int i = 0; i < plane.length; i++){
            if(plane[i][j] == "*"){
                 AddCustomer(i,j);
                 break;
            }else if(plane[i][k] == "*"){
              AddCustomer(i,k);
                 break;
            }else{
                 JOptionPane.showMessageDialog(null,"Sorry your SeatType isn't free");
            }
        }
    }
    
    public void AddCustomer(int j, int k){
        String A = "none";
          switch(k) {
        case 1:
              A = "A";
        break;
        case 2:
               A = "B";
        break;
        case 3:
               A = "C";
        break;
          case 4:
                A = "E";
        break;
          case 5:
             A = "F";
        break;
          case 6:
           A = "G";
        break;
        default:
            JOptionPane.showMessageDialog(null,"Error");
        }
          Customer.add(new Customer(txtName.getText(), AgeComboBox.getValue(), ClassComboBox.getValue(),SeatTypeCombo.getValue(), j , k , plane[j][0], A));
           addSeat(j,k);
        }
        
    public void addSeat(int j, int k){
        if(AgeComboBox.getValue() == "Adult"){
            plane[j][k] = "A"; 
        }else{
            plane[j][k] = "C"; 
        }
        setTableView();
        setCustomerTableView();
    }
    
  
}
