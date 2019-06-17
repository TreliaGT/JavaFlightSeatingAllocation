/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseating;

import java.io.IOException;
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
import flightseating.Customer;
import java.io.RandomAccessFile;


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
    @FXML
    private TextField TxtSearch;
String plane[][];
 /* String plane[][] ={
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
    };*/
   
    ArrayList<Customer> customer = new ArrayList<Customer>();
          ObservableList<Customer> person;
   
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //WriteAllPlane();
          makePlaneFromFile();
         makeCustomerFromFile();
          setCustomerTableView();
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
        
         setTableView();
         setCustomerTableView();
    }

    /**
     * redirect to add customer method
     * @param event 
     */
    @FXML
    private void AddCustomer_click(ActionEvent event) {
        addCustomer();
        WriteAllPlane();
    }
    
    /**
     * Search Function for customers
     * @param event 
     */
     @FXML
    private void Search_click(ActionEvent event) {
    }
    
    /**
     * Reads all of the seating data in seating.txt
     */
    public void makePlaneFromFile(){
               String fromfile = readFromRandomAccessFile("seating.txt", 0);
            String[] seat = fromfile.split(",");
          String seats[][] = {
              {seat[0], seat[1], seat[2], seat[3], seat[4], seat[5],seat[6]}, //1
              {seat[7], seat[8], seat[9], seat[10], seat[11], seat[12],seat[13]},//2
              {seat[14], seat[15], seat[16], seat[17], seat[18], seat[19],seat[20]},//3
              {seat[21], seat[22], seat[23], seat[24], seat[25], seat[26],seat[27]},//4
              {seat[28], seat[29], seat[30], seat[31], seat[32], seat[33],seat[34]},//5
              {seat[35], seat[36], seat[37], seat[38], seat[39], seat[40],seat[41]},//6
              {seat[42], seat[43], seat[44], seat[45], seat[46], seat[47],seat[48]},//7
              {seat[49], seat[50], seat[51], seat[52], seat[53], seat[54],seat[55]},//8
              {seat[56], seat[57], seat[58], seat[59], seat[60], seat[61],seat[62]},//9
              {seat[63], seat[64], seat[65], seat[66], seat[67], seat[68],seat[69]},//10
              {seat[70], seat[71], seat[72], seat[73], seat[74], seat[75],seat[76]},//11
              {seat[77], seat[78], seat[79], seat[80], seat[81], seat[82],seat[83]},//12
          };
        plane = seats;
    }
    
       /**
     * Gets all Customer data from file
     */
    public void makeCustomerFromFile(){
         String fromfile = readFromRandomAccessFile("Customer.txt", 0);
            String[] seat = fromfile.split(",");
            int length = seat.length / 8;
             for (int i = 0 ; i < length; i++)
             {
                   customer.add(new Customer(seat[i], seat[i + 1], seat[i + 2], seat[i + 3],Integer.parseInt(seat[i + 4]), Integer.parseInt(seat[i + 5]), seat[i + 6] , seat[i + 7]));
                
             }
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
 
    /**
     * Sets the customer table view()
     */
    public void setCustomerTableView(){
    
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
        for (int i = 1; i < plane.length; i++){
            if("*".equals(plane[i][j])){
                 AddCustomer(i,j);
                 break;
            }else if("*".equals(plane[i][k])){
              AddCustomer(i,k);
                 break;
            }else{
                 JOptionPane.showMessageDialog(null,"Sorry your SeatType isn't free");
            }
        }
    }
    
    /**
     * Gets the letter of the column then adds the customer
     * @param j
     * @param k 
     */
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
          customer.add(new Customer(txtName.getText(), AgeComboBox.getValue(), ClassComboBox.getValue(),SeatTypeCombo.getValue(), j , k , plane[j][0], A));
          //   JOptionPane.showMessageDialog(null,customer.get(0).getData());
        int length = customer.size() - 1;
         appendToRandomAccessFile("Customer.txt", customer.get(length).getData());
           
           addSeat(j,k);
        }
        
    /**
     * Adds the seat to the plane array
     * @param j
     * @param k 
     */
    public void addSeat(int j, int k){
        if(AgeComboBox.getValue() == "Adult"){
            plane[j][k] = "A"; 
           // writeToRandomAccessFile("seating.txt", int position, A)
        }else{
            plane[j][k] = "C";
          //  writeToRandomAccessFile("seating.txt", int position, "C")
        }
        setTableView();
        setCustomerTableView();
    }
   
    /**
     * Writes customer list to file
     * @param file
     * @param position
     * @return 
     */
    public String readFromRandomAccessFile(String file,int position) {
        String record = null; 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "r"); // read mode
			// moves file pointer to position specified 
			fileStore.seek(position); 
			// read String from RandomAccessFile 
			//record = fileStore.readUTF(); 
			//record = fileStore.readLine();
                       record = fileStore.readLine();
			fileStore.close(); 
			} catch (IOException e) { 
				JOptionPane.showMessageDialog(null,"Error with reading file"); 
			} 
		return record; 
} 
    /**
     * writes all of the planes data
     */
    public void WriteAllPlane(){ 
      for(int i = 0; i < 12; i++){
       //appendToRandomAccessFile("Seating.txt", plane[i][0] + ","+ plane[i][1]  + ","+ plane[i][2]  + ","+ plane[i][3] + ","+ plane[i][4]  + ","+ plane[i][5]  + ","+ plane[i][6]+ "," );
      }        
    }
   
    /**
     * Writes in a certain position
     * @param file
     * @param position
     * @param record 
     */
  public void writeToRandomAccessFile(String file, int position, String record) { 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "rw"); // read write mode
			// moves file pointer to position specified 
			fileStore.seek(position); 
			// write String to RandomAccessFile 
			fileStore.writeUTF(record); 
                   
			fileStore.close(); 
			} catch (IOException e) { 
				JOptionPane.showMessageDialog(null,"Error with writing file");
		}  
	} 
  
  /**
   * Writes data to file
   * @param file
   * @param record 
   */
  public static void appendToRandomAccessFile(String file, String record) { 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "rw"); // read write mode
			// moves file pointer to position specified 
			System.out.println("Appending at position " + fileStore.length());
			fileStore.seek(fileStore.length()); 
			// write String to RandomAccessFile 
			fileStore.writeUTF(record); 
			fileStore.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
		}  
	}

   
}


