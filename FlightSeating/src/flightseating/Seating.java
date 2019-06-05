/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseating;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author V244682
 */
public class Seating {
    private final SimpleStringProperty rows  = new SimpleStringProperty("");
    private final SimpleStringProperty A  = new SimpleStringProperty("");
    private final SimpleStringProperty B  = new SimpleStringProperty("");
    private final SimpleStringProperty C  = new SimpleStringProperty("");
    private final SimpleStringProperty D  = new SimpleStringProperty("");
    private final SimpleStringProperty E = new SimpleStringProperty("");
    private final SimpleStringProperty F  = new SimpleStringProperty("");

    public Seating(String rows, String A, String B, String C, String D, String E, String F) {
         this.rows.set(rows);
         this.A.set(A);
         this.B.set(B);
         this.C.set(C);
         this.D.set(D);
         this.E.set(E);
         this.F.set(F);
    }

    //Setters and getters
    public SimpleStringProperty PropertyRows() {
        return rows;
    }

    public final void setRows(String rows) {
         this.rows.set(rows);
    }
    
    public String getRows() {
        return rows.get();
    }
    
    public SimpleStringProperty PropertyA() {
        return A;
    }

    public final void setA(String A) {
        this.A.set(A);
    }
    
     public String getA() {
        return A.get();
    }
    

    public SimpleStringProperty PropertyB() {
        return B;
    }

    public final void setB(String B) {
        this.B.set(B);
    }
    
      public String getB() {
        return B.get();
    }

    public SimpleStringProperty PropertyC() {
        return C;
    }

    public final void setC(String C) {
        this.C.set(C);
    }
    
      public String getC() {
        return C.get();
    }
    public SimpleStringProperty PropertyD() {
        return D;
    }

    public final void setD(String D) {
        this.D.set(D);
    }
    
    public String getD() {
        return D.get();
    }
    public SimpleStringProperty PropertyE() {
        return E;
    }

    public final void setE(String E) {
        this.E.set(E);
    }

    public String getE() {
        return E.get();
    }
    public SimpleStringProperty PropertyF() {
        return F;
    }

    public final void setF(String F) {
        this.F.set(F);
    }

        public String getF() {
        return F.get();
    }
    
                         
}
