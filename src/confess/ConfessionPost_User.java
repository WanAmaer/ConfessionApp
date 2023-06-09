package confess;

import java.io.BufferedReader;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ConfessionPost_User extends javax.swing.JFrame {

    /**
     * Creates new form ConfessionPost_User
     */
    public ConfessionPost_User() {
	initComponents();
	String content="";
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
	jTextArea1.setText(content);
	//To clear the text file
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 74, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("It's Confess Time");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 26, 201, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("You can confess anything,");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 81, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("your identity will still be unknown.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 104, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 138, 535, 137));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Submit Your Confession");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Save as Draft");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 159, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confess/panda.gif"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	new Menu_User().setVisible(true);
	dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	Queue<String>queue = new Queue<>();
	if(jTextArea1.getText().equals(""))
	    JOptionPane.showMessageDialog(rootPane, "Should enter confession!");
	else{
	    //For spam filtering
	    SpamFiltering spam = new SpamFiltering();
	    String checkContent = jTextArea1.getText();
	    boolean pass = false;
	    try {
		File myObj = new File("Confession.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
		    String[] data = myReader.nextLine().split("//");
		    queue.enqueue(data[4]);
		}
		myReader.close();
	    } catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	    }
	    while(!queue.isEmpty()){
		pass = spam.checking(checkContent,queue.dequeue());
	    }

	    //If not a spam, proceed
	    if (pass==true) {
		//To get the userInfo to be saved in the Confession.txt.
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

		//Obtain the next postID from the Queue
		String temp = "";
		int umID = 0;
		int num = 0;
		String[] data = new String[4];
		try {
		    File myObj = new File("Queue.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
			data = myReader.nextLine().split("//");
		    }
		    umID = Integer.parseInt(data[2].substring(2));
		    num = Integer.parseInt(data[0]);
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
		    myFile.write(num + "// " + "New Post" + "//" + "UM" + umID + "//" + dtf.format(time) + "//" + jTextArea1.getText()+"//" + userInfo[0]);
		    myFile.newLine();
		    myFile.close();
		} catch (IOException e) {
		    JOptionPane.showMessageDialog(null, e);
		}

		//For adding all the info into the UserConfess text file.
		try {
		    BufferedWriter myFile = new BufferedWriter(new FileWriter("UserConfess.txt", true));
		    myFile.write(userInfo[0] + "//" + "UM" + umID);
		    myFile.newLine();
		    myFile.close();
		} catch (IOException e) {
		    JOptionPane.showMessageDialog(null, e);
		}

		JOptionPane.showMessageDialog(rootPane, "Submitted at " + dtf.format(time) + "\nConfession Post ID: UM" + umID + "\nYour Confession Will Be Published Soon..");
		new Menu_User().setVisible(true);
		dispose();
	    }
	    else{
		JOptionPane.showMessageDialog(null, "This confession has been tagged as a spam");
	    }
	}
	
	
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
	String draft = jTextArea1.getText();
	if(jTextArea1.getText().equals(""))
	    JOptionPane.showMessageDialog(rootPane, "Cannot save nothing!");
	else{
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
		myFile.write(userInfo[0] +"//New Post//" + jTextArea1.getText() + "//" + userInfo[0]);
		myFile.newLine();
		myFile.close();
	    } catch (IOException e) {
		JOptionPane.showMessageDialog(null, e);
	    }

	    JOptionPane.showMessageDialog(rootPane, "Save as a draft");
	    new Menu_User().setVisible(true);
	    dispose();
	}
	
    }//GEN-LAST:event_jButton3ActionPerformed

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
	    java.util.logging.Logger.getLogger(ConfessionPost_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(ConfessionPost_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(ConfessionPost_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(ConfessionPost_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new ConfessionPost_User().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
