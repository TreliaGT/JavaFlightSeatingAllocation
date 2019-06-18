/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseating;

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
String plane[][];
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
        makePlaneFromFile();
        setSeatingTableView(); //sets up the seating view
       setComboBox(); //Sets up all combo boxes
        // WriteAllPlane();
    }  
    
   /**
     * Reads all of the seating data in seating.txt
     */
    public void makePlaneFromFile(){
               String fromfile = RandomAccess.readFromRandomAccessFile("Seating.txt", 0);
            String[] seat = fromfile.split(",");
          String seats[][] = {
              {seat[0], seat[1], seat[2], seat[3], seat[4], seat[5]}, //1
              {seat[6], seat[7], seat[8], seat[9], seat[10], seat[11]},//2
              {seat[12],seat[13],seat[14], seat[15], seat[16], seat[17]},//3
              {seat[18], seat[19] ,seat[20],seat[21], seat[22], seat[23]},//4
              {seat[24],seat[25], seat[26],seat[27],seat[28], seat[29]},//5
              {seat[30], seat[31], seat[32], seat[33],seat[34],seat[35]},//6
              {seat[36], seat[37], seat[38], seat[39], seat[40],seat[41]},//7
              {seat[42], seat[43], seat[44], seat[45], seat[46], seat[47]},//8
              {seat[48],seat[49], seat[50], seat[51], seat[52], seat[53]},//9
              {seat[54],seat[55],seat[56], seat[57], seat[58], seat[59]},//10
              {seat[60], seat[61],seat[62],seat[63], seat[64], seat[65]},//11
              {seat[66], seat[67],seat[68],seat[69], seat[70], seat[71]},//12
          };
        plane = seats;
    }
    
    public void makeCustomerFromFile(){
        String data;
         try {
        Scanner inFile = new Scanner(new FileReader("Customer.txt"));
        while(inFile.hasNextLine()){
            customer.add(new Customer(inFile.next(),inFile.next(), inFile.next(),inFile.next(),inFile.nextInt(),inFile.nextInt(), inFile.next(), inFile.next()));
        }
        inFile.close(); 
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
            if(" * ".equals(plane[i][cRight])){
                 AddCustomer(i,cRight);
                 break;
            }else if(" * ".equals(plane[i][cLeft])){
              AddCustomer(i,cLeft);
                 break;
            }else{
                 JOptionPane.showMessageDialog(null,"Sorry your SeatType isn't free");
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


