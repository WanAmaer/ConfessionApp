/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package confess;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ReplyConfession_User extends javax.swing.JFrame {

    /**
     * Creates new form ReplyConfession_User
     */
    public ReplyConfession_User() {
	initComponents();
	String data="",content="";
	try {
	    File myObj = new File("tempReplyID.txt");
	    Scanner myReader = new Scanner(myObj);
	    while (myReader.hasNextLine()) {
		data = myReader.nextLine();
	    }
	    myReader.close();
	} catch (FileNotFoundException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	}
	try {
	    File myObj = new File("tempDraft.txt");
	    Scanner myReader = new Scanner(myObj);
	    while (myReader.hasNextLine()) {
		content = myReader.nextLine();
	    }
	    myReader.close();
	} catch (FileNotFoundException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	}
	jTextField1.setText(data);
	jTextArea1.setText(content);
	//To clear the text file
	try {
	    FileWriter myWriter = new FileWriter("tempReplyID.txt");
	    myWriter.write("");
	    myWriter.close();
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    FileWriter myWriter = new FileWriter("tempDraft.txt");
	    myWriter.write("");
	    myWriter.close();
	} catch (IOException e) {
	    System.out.println(e);
	}
	
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Reply Confession");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 13, -1, -1));

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Reply Confession post ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 69, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 197, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Your Reply Confession Content:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 148, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 525, 130));

        jButton2.setText("Submit Your Confession");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 345, -1, -1));

        jButton3.setText("Save as Draft");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 383, 159, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confess/panda.gif"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	new Menu_User().setVisible(true);
	dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // Tambah utk checking whether the post ID wujud atau x
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	if (jTextArea1.getText().equals("")) {
	    JOptionPane.showMessageDialog(rootPane, "Should enter confession!");
	} 
	else {
	//check if the postID exist
	    boolean existID = false;
	    String[] datas = new String[5];
	    try {
		File myObj = new File("Confession.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
		    datas = myReader.nextLine().split("//");
		    System.out.println(datas[2]);
		    if (jTextField1.getText().equals(datas[2])) {
			existID = true;
			break;
		    }
		    if (!myReader.hasNextLine()) {
			break;
		    }
		}
		myReader.close();
	    } catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	    }
	    if (existID == false) {
		JOptionPane.showMessageDialog(null, "The post ID does not exist.\nPlease enter another post ID");
	    } else {
		//To get the userInfo to be saved in the Confession.txt
		String[] userInfo = new String[2];
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime time = LocalDateTime.now();

		//For the reply post ID, Obtain it from the temporary file
		//Or if there is no
		String confession = jTextArea1.getText();

		//Obtain the next postID from the Queue
		String temp = "";
		int umID = 0;
		int num = 0;
		try {
		    File myObj = new File("Queue.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
			String[] data = myReader.nextLine().split("//");
			if (!myReader.hasNextLine()) {
			    umID = Integer.parseInt(data[2].substring(2));
			    num = Integer.parseInt(data[0]);
			    System.out.println("Berjaya");
			}
		    }
		    myReader.close();
		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		umID++;
		num++;

		// For adding all the info into the Queue text file.
		try {
		    BufferedWriter myFile = new BufferedWriter(new FileWriter("Queue.txt", true));
		    myFile.write(num + "//" + jTextField1.getText() + "//UM" + umID + "//" + dtf.format(time) + "//" + jTextArea1.getText() + "//" + userInfo[0]);
		    myFile.newLine();
		    myFile.close();
		} catch (IOException e) {
		    JOptionPane.showMessageDialog(null, e);
		}

		//For adding all the info into the UserConfess text file.
		try {
		    BufferedWriter myFile = new BufferedWriter(new FileWriter("UserConfess.txt", true));
		    myFile.write(userInfo[0] + "//UM" + umID);
		    myFile.newLine();
		    myFile.close();
		} catch (IOException e) {
		    JOptionPane.showMessageDialog(null, e);
		}

		JOptionPane.showMessageDialog(rootPane, "Submitted at " + dtf.format(time) + "\nConfession Post ID: UM" + umID + "\nYour Confession Will Be Published Soon..");
		new Menu_User().setVisible(true);
		dispose();
	    }
	}
	
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String draft = jTextArea1.getText();
	if (draft.equals(""))
	    JOptionPane.showMessageDialog(rootPane, "Cannot save nothing");
	else {
	    //check if the postID exist
	    boolean existID = false;
	    String[] datas = new String[5];
	    try {
		File myObj = new File("Confession.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
		    datas = myReader.nextLine().split("//");
		    System.out.println(datas[2]);
		    if (jTextField1.getText().equals(datas[2])) {
			existID = true;
			break;
		    }
		    if (!myReader.hasNextLine()) {
			break;
		    }
		}
		myReader.close();
	    } catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	    }
	    if (existID == false) {
		JOptionPane.showMessageDialog(null, "The post ID does not exist.\nPlease enter another post ID");
	    } else {
		String[] userInfo = new String[2];

		//To get the userInfo to be saved in the draft.
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

		// For adding all the info into the Draft text file.
		try {
		    BufferedWriter myFile = new BufferedWriter(new FileWriter("Draft.txt", true));
		    myFile.write(userInfo[0] + "//" +jTextField1.getText() + "//"  + jTextArea1.getText() + "//" + userInfo[0]);
		    myFile.newLine();
		    myFile.close();
		} catch (IOException e) {
		    JOptionPane.showMessageDialog(null, e);
		}

		JOptionPane.showMessageDialog(rootPane, "Save as a draft");
		new Menu_User().setVisible(true);
		dispose();
	    }
	}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
	    java.util.logging.Logger.getLogger(ReplyConfession_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(ReplyConfession_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(ReplyConfession_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(ReplyConfession_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new ReplyConfession_User().setVisible(true);
	    }
	});
    }
//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
