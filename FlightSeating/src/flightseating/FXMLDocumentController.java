/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseating;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
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
    @FXML
    private TextField TxtSearch;
String plane[][] = new String[12][6];
// String plane[][] ={
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//        {"*" ,"*" ,"*" ,"*" ,"*" , "*"},
//    };
  
    ArrayList<Customer> customer = new ArrayList<Customer>();
          ObservableList<Customer> person;
   int RowNumber;

          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WriteAllPlane();
        makePlaneFromFile();
        makeCustomerFromFile();
        setSeatingTableView(); //sets up the seating view
       setComboBox(); //Sets up all combo boxes
    }  
    
   /**
     * Reads all of the seating data in seating.txt
     */
    public void makePlaneFromFile(){
//            String fromfile = RandomAccess.readFromRandomAccessFile("Seating.txt", 0);
            for (int row = 0; row < 12; row++) {
                for (int col = 0; col < 6; col++) {
                    int location = 4*(6*row + (col));
                    plane[row][col] = String.valueOf(RandomAccess.readFromRandomAccessFile("Seating.txt", location));
                    }
            }
    }
    
    /**
     * Reads the customer data in Customer.txt
     */
    public void makeCustomerFromFile(){
      
         try {
         String line;
         BufferedReader inFile = new BufferedReader(new FileReader("Customer.txt"));
        while((line = inFile.readLine()) != null){
            String[] customerInfo = line.split(",");
            customer.add(new Customer(customerInfo[0],customerInfo[1], customerInfo[2],customerInfo[3],Integer.parseInt(customerInfo[4]),Integer.parseInt(customerInfo[5]), customerInfo[6], customerInfo[7]));
        }
        inFile.close(); 
        setCustomerTableView();
      } catch (IOException i) {
          JOptionPane.showMessageDialog(null, "There was an error");
      }
    }
    
     /**
     * Closes the program but also will call the write to file method
     * @param event 
     */
    @FXML
    private void Close_Click(ActionEvent event) {
       //WriteAllPlane();
       savedata();
       System.exit(0);
    }
    
    /**
     * Delete customer and removes the seat
     * @param event 
     */
    @FXML
    private void DeleteSeat_Click(ActionEvent event) {
       int I = customerlist.getSelectionModel().getSelectedIndex();
       int col = customer.get(I).getCol();
       int row = customer.get(I).getRow();
         plane[row][col] = "*";
         customer.remove(I);
         int location = 4*(6*row + (col));
         RandomAccess.writeToRandomAccessFile("Seating.txt", location,"*");
         
      
     setSeatingTableView();
     setCustomerTableView();
    }

    /**
     * redirect to add customer method
     * @param event 
     */
    @FXML
    private void AddCustomer_click(ActionEvent event) {
        addCustomer();
    }
    
    /**
     * Search Function for customers
     * @param event 
     */
     @FXML
    private void Search_click(ActionEvent event) {
        binarySearch(TxtSearch.getText());
    }
    
    /**
     * Binary Search function
     * @param line
     */
    public void binarySearch(String line)
     {
       
        int first = 0;
        int last = customer.size();
        int mid=0;
        boolean found = false;

        while (first <= last && !found)
        {
            mid = (first + last) / 2;

            if (customer.get(mid).getName().equals(line)||customer.get(mid).getName().compareTo(line) == 0) // cannot use == for string comparisons
                    
                found = true;
            else if (customer.get(mid).getName().compareTo(line) > 0) 
                last = mid - 1;
            else
                first = mid + 1;
        }

        if (found)
        {
           //Collections.sort(customer, Customer.NameComparator);
            customerlist.getSelectionModel().select(mid);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Sorry Customer wasn't found");
        }
            
     }
    
    /***
     * Adds information to a table view
     */
    public void setSeatingTableView(){
        ArrayList<Seating> list = new ArrayList<Seating>();
        for(int i = 0; i < plane.length; i++){
            list.add(new Seating(plane[i][0], plane[i][1],plane[i][2],plane[i][3],plane[i][4],plane[i][5]));
          
        }
           
       ObservableList<Seating> list2 = FXCollections.observableArrayList(list);    
        A.setCellValueFactory(data -> data.getValue().PropertyA());
        B.setCellValueFactory(data -> data.getValue().PropertyB()); 
        C.setCellValueFactory(data -> data.getValue().PropertyC()); 
        D.setCellValueFactory(data -> data.getValue().PropertyD()); 
        E.setCellValueFactory(data -> data.getValue().PropertyE()); 
        F.setCellValueFactory(data -> data.getValue().PropertyF()); 
        FlightSeatsGrid.setItems(list2);
    }
 
    /**
     * Sets the customer table view()
     */
    public void setCustomerTableView(){
     Collections.sort(customer, Customer.NameComparator);
          ObservableList<Customer> person = FXCollections.observableArrayList(customer);
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
              getSeat(0, 5);
        break;
        case "Middle":
            getSeat(1, 4);
        break;
        case "Aisle":
            getSeat(2, 3);
        break;
        default:
            JOptionPane.showMessageDialog(null,"Please select SeatType");
        }
    }
    
    /**
     * Gets seat 
     * @param cRight
     * @param cLeft
     */
    public void getSeat(int cRight, int cLeft){
        for (int i = 0; i < plane.length; i++){
            if("*".equals(plane[i][cRight])){
                 AddCustomer(i,cRight);
                 break;
            }else if("*".equals(plane[i][cLeft])){
              AddCustomer(i,cLeft);
                 break;
            }else{
                 if (plane.length == (i + 1)){
                      JOptionPane.showMessageDialog(null,"please choose another seat");
                 }
            }
        }
    }
    
    /**
     * Gets the letter of the column then adds the customer 
     * @param row
     * @param Column
     */
    public void AddCustomer(int row, int Column){
        String A = "none";
          switch(Column) {
        case 0:
              A = "A";
        break;
        case 1:
               A = "B";
        break;
        case 2:
               A = "C";
        break;
          case 3:
                A = "E";
        break;
          case 4:
             A = "F";
        break;
          case 5:
           A = "G";
        break;
        default:
            JOptionPane.showMessageDialog(null,"Error");
        }
         
            customer.add(new Customer(txtName.getText(), AgeComboBox.getValue(), ClassComboBox.getValue(),SeatTypeCombo.getValue(), row , Column , "Row " + Integer.toString(row + 1), A));
            
      
           addSeat(row,Column);
        }
        
    /**
     * Adds the seat to the plane array 
     * @param row
     * @param Column
     */
    public void addSeat(int row, int Column){
         int location = 4*(6*row + (Column));
         
        if("Adult".equals(AgeComboBox.getValue())){
            plane[row][Column] = "A"; 
            
             RandomAccess.writeToRandomAccessFile("Seating.txt", location,"A");
          
        }else{
            plane[row][Column] = "C";
            
            RandomAccess.writeToRandomAccessFile("Seating.txt", location,"C");
        }
        setSeatingTableView();
        setCustomerTableView();
    }
    
      /**
     * writes all of the planes data
     */
    public void WriteAllPlane(){ 
    String seatFile = "Seating.txt";
    File file = new File(seatFile);
    if(!file.exists()){   
        String result = "";
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                result += "*,";
                 }
            }
         RandomAccess.writeToRandomAccessFile(seatFile, 0, result);
        }
    }
    
  /**
     * save the binary tree to a binary file.
     */
    public void savedata(){
          try {
        PrintWriter outfile = new PrintWriter("Customer.txt");
        for (Customer item : customer){
         outfile.println(item.getData());   
        }
        outfile.close();
        
          JOptionPane.showMessageDialog(null, "saved data");
      } catch (IOException i) {
         JOptionPane.showMessageDialog(null, "Error with saving");
      }
          System.exit(0);
    }

}


