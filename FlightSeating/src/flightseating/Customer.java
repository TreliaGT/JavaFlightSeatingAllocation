/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseating;
        
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Trelia
 */
public class Customer {
       private final SimpleStringProperty name = new SimpleStringProperty("");
       private final SimpleStringProperty ageGroup = new SimpleStringProperty("");
       private final SimpleStringProperty flightClass = new SimpleStringProperty("");
       private final SimpleStringProperty perferedSeat = new SimpleStringProperty(""); 
       private final SimpleIntegerProperty row = new SimpleIntegerProperty(0);
       private final SimpleIntegerProperty col = new SimpleIntegerProperty(0);

    public Customer(String name, String ageGroup, String flightClass, String perferedSeat, int row, int col) {
        this.name.set(name);
        this.ageGroup.set(ageGroup);
        this.flightClass.set(flightClass);
        this.perferedSeat.set(perferedSeat);
        this.row.set(row);
        this.col.set(col);
    }

         
    public SimpleStringProperty PropertyName() {
        return name;
    }

    public final void setName(String name) {
         this.name.set(name);
    }
    
    public String getName() {
        return name.get();
    }
    public SimpleStringProperty PropertyAgeGroup() {
        return ageGroup;
    }

    public final void setAgeGroup(String ageGroup) {
         this.ageGroup.set(ageGroup);
    }
    
    public String getAgeGroup() {
        return ageGroup.get();
    }

     public SimpleStringProperty PropertyFlightClass() {
        return flightClass;
    }

    public final void setFlightClass(String flightClass) {
         this.flightClass.set(flightClass);
    }
    
    public String getFlightClass() {
        return flightClass.get();
    }

     public SimpleStringProperty PropertyPerferedSeat() {
        return perferedSeat;
    }

    public final void setPerferedSeat(String perferedSeat) {
         this.perferedSeat.set(perferedSeat);
    }
    
    public String getPerferedSeat() {
        return perferedSeat.get();
    }  

       public SimpleIntegerProperty PropertyRow() {
        return row;
    }

    public final void setRow(int row) {
         this.row.set(row);
    }
    
    public int getRow() {
        return row.get();
    } 

   public SimpleIntegerProperty PropertyCol() {
        return col;
    }

    public final void setCol(int col) {
         this.col.set(col);
    }
    
    public int getCol() {
        return col.get();
    }     
}



