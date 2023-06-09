/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package confess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class BatchRemoval extends javax.swing.JFrame {

    /**
     * Creates new form BatchRemoval
     */
    
    Queue<String>queue = new Queue<>();
    int page=0;	    //For traverse in the queue
    
    public BatchRemoval() throws IOException {
	initComponents();
	Stack<String>stack = new Stack<>();
	//To sort the confession by time
	int foo=0;
	try {
	    File myObj = new File("Confession.txt");
	    Scanner myReader = new Scanner(myObj);
	    while (myReader.hasNextLine()) {
		String data = myReader.nextLine();
		stack.push(data);
		foo++;
	    }
	    myReader.close();
	} catch (FileNotFoundException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	}
	
	//To overwrite the file
	    try {
		FileWriter myWriter = new FileWriter("SortedConfession.txt");
		myWriter.write("Number//Reply To//UM ID//Submitted At//Confession\n");
		for(int i=stack.size(); i>1 ;i--){
		    queue.enqueue(stack.peek());
		    myWriter.write(stack.pop()+"\n");
		}
		
		myWriter.close();
	    } catch (IOException e) {
		System.out.println(e);
	    }   
	
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("SortedConfession.txt"));
	    String firstLine = reader.readLine().trim();
	    String[] columnsName = firstLine.split("//");
	    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
	    model.setColumnIdentifiers(columnsName);

	    Object[] tableLines = reader.lines().toArray();
	    for (int i = 0; i < tableLines.length; i++) {
		String line = tableLines[i].toString().trim();
		String[] dataRow = line.split("//");
		model.addRow(dataRow);
	    }
	   
	    jTable1.setAutoCreateRowSorter(true);
	} catch (FileNotFoundException e) {
	    System.out.println("Error bro");
	}

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Reply PostID", "Post ID", "Time", "Confession"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 610, 320));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 100, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Remove with resposibility");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confess/sky.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	  //Clean the tempFile
	try {
	    FileWriter myWriter = new FileWriter("tempConfession.txt");
	    myWriter.write("");
	    myWriter.close();
	} catch (IOException e) {
	    System.out.println(e);
	}
	
	DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
	String tempID="";
	ArrayList<String> deletedID = new ArrayList<>();			//For checking the content if it is the same or not.
	
	 //Choose row
        if(jTable1.getSelectedRowCount()==1){
           tempID = (String)model.getValueAt(jTable1.getSelectedRow(),2);
        }
        else if (jTable1.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(rootPane,"Please choose a confession to be deleted");
        }
        else{
            JOptionPane.showMessageDialog(rootPane,"Please select only one row at a time");
        }
	deletedID.add(tempID);
	try{
	    File file = new File("Confession.txt");
	    Scanner scan = new Scanner(file);
	    while(scan.hasNext()){
		String firstLine = scan.nextLine().trim();
		String[] contents = firstLine.split("//");
		//Create tempConfession file
		//Act as a file with no deleted content
		try {
		    BufferedWriter myFile = new BufferedWriter(new FileWriter("tempConfession.txt", true));
		    if (deletedID.contains(contents[1]) || deletedID.contains(contents[2])){	    //If contents is deleted, it will not save into the tempConfession
			deletedID.add(contents[2]);	    //It will add the deleted ID, so that the post that have the same reply Post ID will also be deleted.
			System.out.println("Berjaya");
		    }
		    else{
			myFile.write(contents[0] + "//" + contents[1] + "//" + contents[2] + "//" + contents[3] + "//" + contents[4]);
			myFile.newLine();
		    }
		    myFile.close();
		} catch (IOException e) {
		    System.out.println(e);
		}
	    }
	}
	catch(IOException e){
	    System.out.println(e);
	}
	//To overwrite the Confession file
	try {
	    FileWriter myWriter = new FileWriter("Confession.txt");
	    //To take the contents from the tempConfession file
	    try {
		File myObj = new File("tempConfession.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
		    String data = myReader.nextLine();
		     myWriter.write(data+"\n");
		}
		myReader.close();
	    } catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	    }
	    myWriter.close();
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    new BatchRemoval().setVisible(true);
	} catch (IOException ex) {
	    Logger.getLogger(BatchRemoval.class.getName()).log(Level.SEVERE, null, ex);
	}
	dispose();
		
	
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(BatchRemoval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(BatchRemoval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(BatchRemoval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(BatchRemoval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    new BatchRemoval().setVisible(true);
		} catch (IOException ex) {
		    Logger.getLogger(BatchRemoval.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
