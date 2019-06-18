/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightseating;

import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

/**
 *
 * @author Trelia
 */
public class RandomAccess {
    
    
        /**
     * Writes customer list to file
     * @param file
     * @param position
     * @return 
     */
    public static char readFromRandomAccessFile(String file,int position) {
       char record = 'E'; 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "r"); // read mode
			// moves file pointer to position specified 
			fileStore.seek(position); 
			// read String from RandomAccessFile 
			//record = fileStore.readUTF(); 
//			record = fileStore.readLine();
                      record = fileStore.readChar();
			fileStore.close(); 
			} catch (IOException e) { 
				//JOptionPane.showMessageDialog(null,"Error with reading file"); 
			} 
		return record; 
}
    
    /**
     * Writes in a certain position
     * @param file
     * @param position
     * @param record 
     */
  public static void writeToRandomAccessFile(String file, int position, String record) { 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "rw"); // read write mode
			// moves file pointer to position specified 
			fileStore.seek(position); 
			// write String to RandomAccessFile 
			fileStore.writeChars(record); 
                   
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
			fileStore.writeChars(record); 
			fileStore.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
		}  
	}

   
}

