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

       
    public Customer(String name, String ageGroup, String flightClass, String perferedSeat) {
        this.name = name;
        this.ageGroup = ageGroup;
        this.flightClass = flightClass;
        this.perferedSeat = perferedSeat;
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
}



