/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseatingallicationjava;

/**
 *
 * @author Trelia
 */
public class Customer {
       private String name;
       private String ageGroup;
       private String flightClass;
       private String perferedSeat; 
       private int row;
       private int col;

    public Customer(String name, String ageGroup, String flightClass, String perferedSeat, int row, int col) {
        this.name = name;
        this.ageGroup = ageGroup;
        this.flightClass = flightClass;
        this.perferedSeat = perferedSeat;
        this.row = row;
        this.col = col;
    }
         
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getPerferedSeat() {
        return perferedSeat;
    }

    public void setPerferedSeat(String perferedSeat) {
        this.perferedSeat = perferedSeat;
    }    

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    
}



