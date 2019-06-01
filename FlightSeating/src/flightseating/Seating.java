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
    private SimpleStringProperty rows;
    private SimpleStringProperty A;
    private SimpleStringProperty B;
    private SimpleStringProperty C;
    private SimpleStringProperty D;
    private SimpleStringProperty E;
    private SimpleStringProperty F;

    public Seating(String rows, String A, String B, String C, String D, String E, String F) {
         this.rows.set(rows);
         this.A.set(A);
         this.B.set(B);
         this.C.set(C);
         this.D.set(D);
         this.E.set(E);
         this.F.set(F);
    }
    
    public SimpleStringProperty PropertyRows() {
        return rows;
    }

    public void setRows(String rows) {
         this.rows.set(rows);
    }
    
    public String getRows() {
        return rows.get();
    }
    
    public SimpleStringProperty PropertyA() {
        return A;
    }

    public void setA(String A) {
        this.A.set(A);
    }
    
     public String getA() {
        return A.get();
    }
    

    public SimpleStringProperty PropertyB() {
        return B;
    }

    public void setB(String B) {
        this.B.set(B);
    }
    
      public String getB() {
        return B.get();
    }

    public SimpleStringProperty PropertyC() {
        return C;
    }

    public void setC(String C) {
        this.C.set(C);
    }
    
      public String getC() {
        return C.get();
    }
    public SimpleStringProperty PropertyD() {
        return D;
    }

    public void setD(String D) {
        this.D.set(D);
    }
    
    public String getD() {
        return D.get();
    }
    public SimpleStringProperty PropertyE() {
        return E;
    }

    public void setE(String E) {
        this.E.set(E);
    }

    public String getE() {
        return E.get();
    }
    public SimpleStringProperty PropertyF() {
        return F;
    }

    public void setF(String F) {
        this.F.set(F);
    }

        public String getF() {
        return F.get();
    }
    
                         
}
