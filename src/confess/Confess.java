package confess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class Confess {
 
    public static void main(String[] args) {
	//To start the program
	new Login().setVisible(true);
	
	Queue<String>queue = new Queue();
	Timer timer = new Timer();
	TimerTask task = new TimerTask(){

	    public void run(){
		JOptionPane.showMessageDialog(null, "Berjaya"); 
		//To read the file and use Queue as the data structure
		try {
		    File myObj = new File("Queue.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			queue.enqueue(data);
		    }
		    myReader.close();
		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}

		//Push the first line into the confession post
		try {
		    BufferedWriter myFile = new BufferedWriter(new FileWriter("Confession.txt", true));
		    myFile.write(queue.dequeue());
		    myFile.newLine();
		    myFile.close();
		} catch (IOException e) {
		    System.out.println(e);
		}
		
		int loop = queue.getSize();
		//Overwrite File with the new data without the pushed info
		 try {
		    FileWriter myWriter = new FileWriter("Queue.txt");
		    for(int i=0; i<loop; i++){
			System.out.println(queue.getSize());
			myWriter.write(queue.dequeue());
			myWriter.write("\n");
		    }
		    myWriter.close();
		} catch (IOException e) {
		    System.out.println(e);
		}
	    }
	};
	
	int i = 0;
	while(true){
	    i = 0;
	    try {
		File myObj = new File("Queue.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
		    //For traverse between the line, Do nothing
		    String data = myReader.nextLine();
		    i++;
		}
		myReader.close();
	    } catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	    }
            
	    if (i <= 5) {
		timer.scheduleAtFixedRate(task, 900000, 900000);    //Delay for 15 minutes in miliseconds
	    } else if (i <= 10) {
		timer.scheduleAtFixedRate(task, 600000, 600000);    //Delay for 10 minutes in miliseconds
	    } else if (i > 10) {
		timer.scheduleAtFixedRate(task, 300000, 300000);     //Delay for 5 minutes in miliseconds
	    }
	}
    }
}
