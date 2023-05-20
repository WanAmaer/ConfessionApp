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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class draftConfession extends javax.swing.JFrame {

    public draftConfession() throws IOException {
	initComponents();
	String[]userInfo = new String[2];
	//Current draft is for the Searching Part
        try {
            FileWriter myWriter = new FileWriter("currentDraft.txt");
            myWriter.write("Reply PostID//Draft\n");
            myWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
	//To take the currentUser info
	try {
		File myObj = new File("currentUserInfo.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
		    String data = myReader.nextLine();
		    userInfo = data.split("//");
		}
		myReader.close();
	    } catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	    }
	
	//To do the searching from the Draft, so that only the user's draft will be chose.
        try {
            File myObj = new File("Draft.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
		String[]x = data.split("//");

		if (userInfo[0].equals(x[0])) {
		    try {
			BufferedWriter myFile = new BufferedWriter(new FileWriter("currentDraft.txt", true));
			myFile.write(x[1] + "//" + x[2]);
			myFile.newLine();
			myFile.close();
		    } catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		    }
		}
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	
	//This is for displaying the table
        try {
            BufferedReader reader = new BufferedReader(new FileReader("currentDraft.txt"));
            String firstLine = reader.readLine().trim();
            String[] columnsName = firstLine.split("//");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setColumnIdentifiers(columnsName);

            Object[] tableLines = reader.lines().toArray();
            for(int i=0; i<tableLines.length; i++){

                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("//");
                model.addRow(dataRow);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error bro");
        } catch (IOException ex) {
            Logger.getLogger(OtherConfession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Draft Confession");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 14, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reply Post ID", "Draft"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 78, 590, 361));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confess/Olb0.gif"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Menu_User().setVisible(true);
	dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	//Clean the copyDraft
	try {
	    FileWriter myWriter = new FileWriter("copyDraft.txt");
	    myWriter.write("");
	    myWriter.close();
	} catch (IOException e) {
	    System.out.println(e);
	}
	
	DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
	ArrayList<String>deletedID=new ArrayList<>();
	String tempID = "";
	String content ="";
	if (jTable1.getSelectedRowCount() == 1) {
	    try {
		File myObj = new File("currentDraft.txt");
		Scanner myReader = new Scanner(myObj);
		int foo = -1;
		while (myReader.hasNextLine()) {
		    String[] data = myReader.nextLine().split("//");
		    if (data[1].equals(String.valueOf(model.getValueAt(jTable1.getSelectedRow(), 1)))) {
			tempID = data[0];
			content = data[1];
			//To save temporarily the reply into the tempReplyID.txt
			try {
			    FileWriter myWriter = new FileWriter("tempReplyID.txt");
			    myWriter.write(tempID);
			    myWriter.close();
			} catch (IOException e) {
			    System.out.println(e);
			}
			//To save temporarily the draft into the tempDraft.txt
			try {
			    FileWriter myWriter = new FileWriter("tempDraft.txt");
			    myWriter.write(content);
			    myWriter.close();
			} catch (IOException e) {
			    System.out.println(e);
			}
		    }
		}
		myReader.close();
	    } catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	    }
	    
	    //To do the searching from the Draft, so that only the draft will be deleted.
	    deletedID.add(tempID);
	    deletedID.add(content);
	    try {
		File file = new File("Draft.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
		    String firstLine = scan.nextLine().trim();
		    String[] contents = firstLine.split("//");
		    //Create copyDraft file
		    //Act as a file with no deleted content
		    try {
			BufferedWriter myFile = new BufferedWriter(new FileWriter("copyDraft.txt", true));
			if (deletedID.contains(contents[1]) && deletedID.contains(contents[2])) {	    //If contents is deleted, it will not save into the tempConfession
			    System.out.println("Berjaya");
			} else {
			    myFile.write(contents[0] + "//" + contents[1] + "//" + contents[2]+"\n");
			}
			myFile.close();
		    } catch (IOException e) {
			System.out.println(e);
		    }
		}
	    } catch (IOException e) {
		System.out.println(e);
	    }
	    
	    //To return the data into the Draft.txt
	    try {
		FileWriter myWriter = new FileWriter("Draft.txt");
		try {
		    File myObj = new File("copyDraft.txt");
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
	    
	    if(tempID.equals("New Post")){
		new ConfessionPost_User().setVisible(true);
		dispose();
	    }
	    else{
		new ReplyConfession_User().setVisible(true);
		dispose();
	    }
	}
        else if (jTable1.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(rootPane,"Please choose a draft to be editted");
        }
        else{
            JOptionPane.showMessageDialog(rootPane,"Please select only one row at a time");
        }
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
	    java.util.logging.Logger.getLogger(draftConfession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(draftConfession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(draftConfession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(draftConfession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    new draftConfession().setVisible(true);
		} catch (IOException ex) {
		    Logger.getLogger(draftConfession.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}