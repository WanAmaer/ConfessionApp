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
public class ViewYourConfession extends javax.swing.JFrame {
    
    /**
     * Creates new form ViewYourConfession
     */
    
    Queue<String>queue = new Queue<>();
    int page=0;	    //For traverse in the queue
    
    public void openTabbed(int page){
	String stck = queue.getElement(page);
	String[] confession = stck.split("//");
	if (confession[1] == "New Post") {
	    jTextArea1.setText("#" + confession[2] + "\n[" + confession[3] + "]\n\n" + confession[4]);
	} else {
	    jTextArea1.setText("#" + confession[2] + "\n[" + confession[3] + "]\n\nReply to " + confession[1] + "\n" + confession[4]);
	}
    }
    
    public ViewYourConfession() throws IOException {
	initComponents();
	//Clean the tempFile
	try {
	    FileWriter myWriter = new FileWriter("currentReply.txt");
	    myWriter.write("");
	    myWriter.close();
	} catch (IOException e) {
	    System.out.println(e);
	}
	
	//For the SortedConfession
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
	    
	//To get the current userInfo    
	String[] userInfo = new String[2];
	try{
	    File file = new File("currentUserInfo.txt");
	    Scanner scan = new Scanner(file);
	    String firstLine = scan.nextLine().trim();
	    userInfo = firstLine.split("//");
	    scan.close();
	}
	catch(IOException e){
	    System.out.println("Error bro");
	}
	
	//For sorting only the userID
	int loop=0;
	try {
            File myObj = new File("Confession.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] x = data.split("//");
		    try {
			//currentReply is the text file that has our userID
			BufferedWriter myFile = new BufferedWriter(new FileWriter("currentReply.txt", true));
			if(loop==0){
			    myFile.write(x[0] + "//" + x[1] + "//" + x[2] + "//" + x[3] + "//" + x[4]+"\n");
			    loop++;
			}
			else{
			    if (userInfo[0].equals(x[5])){
			    queue.enqueue(data);
			    myFile.write(x[0] + "//" + x[1] + "//" + x[2] + "//" + x[3] + "//" + x[4]);
			    myFile.newLine();  
			    }
			}
			
			myFile.close();
		    } catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		    }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	
	try{
	    BufferedReader reader = new BufferedReader(new FileReader("currentReply.txt"));
	    String firstLine = reader.readLine().trim();
	    String[]columnsName = firstLine.split("//");
	    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
	    model.setColumnIdentifiers(columnsName);
	    
	    Object[] tableLines = reader.lines().toArray();
	    for(int i=0; i<tableLines.length; i++){
		
		String line = tableLines[i].toString().trim();
		String[] dataRow = line.split("//");
		model.addRow(dataRow);
	    }
	    
	}catch(FileNotFoundException e){
	    System.out.println("Error bro");
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel1.setText("Your Confession");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 13, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 92, 110, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UM ID", "Time", "Message", "Reply"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jTabbedPane1.addTab("All", jScrollPane2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Previous");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Next");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Reply");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButton9)
                .addGap(24, 24, 24)
                .addComponent(jButton10)
                .addGap(40, 40, 40)
                .addComponent(jButton11)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Confession", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 58, -1, 307));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View Confession");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confess/sky.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Menu_User().setVisible(true);
	dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if(page==0)
        JOptionPane.showMessageDialog(rootPane, "This is the latest page");
        else{
            page--;
            openTabbed(page);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(page==queue.getSize()-1)
        JOptionPane.showMessageDialog(rootPane, "This is the last confession");
        else{
            page++;
            String stck = queue.getElement(page);
            String[] confession = stck.split("//");
            if (confession[1].equals("New Post")){
                jTextArea1.setText("#" + confession[2] + "\n[" + confession[3] + "]\n\n" + confession[4]);
            } else {
                jTextArea1.setText("#" + confession[2] + "\n[" + confession[3] + "]\n\nReply to " + confession[1] + "\n" + confession[4]);
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        String stck = queue.getElement(page);
        String[] confession = stck.split("//");

        //tempID is for the replyPostID
        String tempID = confession[2];
        try {
            FileWriter myWriter = new FileWriter("tempReplyID.txt");
            myWriter.write(tempID);
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        new ReplyConfession_User().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         DefaultTableModel model3 = (DefaultTableModel)jTable1.getModel();
        //Choose row
        if(jTable1.getSelectedRowCount()==1){
	    try {
		File myObj = new File("SortedConfession.txt");
		Scanner myReader = new Scanner(myObj);
		int foo=-1;
		while (myReader.hasNextLine()) {
		    String[] data = myReader.nextLine().split("//");
		    if(data[0].equals(String.valueOf(model3.getValueAt(jTable1.getSelectedRow(),0))))
			page = foo;
		    else
			foo++;
		}
		myReader.close();
	    } catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	    }
	    jTabbedPane1.setSelectedIndex(1);
	    openTabbed(page);
        }
        else if (jTable1.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(rootPane,"Please choose a confession to be viewed");
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
	    java.util.logging.Logger.getLogger(ViewYourConfession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(ViewYourConfession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(ViewYourConfession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(ViewYourConfession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    new ViewYourConfession().setVisible(true);
		} catch (IOException ex) {
		    Logger.getLogger(ViewYourConfession.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}