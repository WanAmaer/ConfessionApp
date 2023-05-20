package confess;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class SpamFiltering {
    public double similarityPercentage(String a, String b){
     double SumOfTwostring = 0;
        double SubsOfTwostring = 0;
        int sumofA = 0;
        int sumofB = 0;
        
        for (int i = 0; i < a.length(); i++) {
            int str1 = (int)a.charAt(i);
            sumofA += str1;
        }
        
        for (int i = 0; i < b.length(); i++) {
            int str2 = (int)b.charAt(i);
            sumofB += str2;
        }
        SumOfTwostring += (sumofA+sumofB);
        
        if(a.length() >= b.length()){
               SubsOfTwostring += (sumofA-sumofB);
           }
        if(a.length() < b.length()){
               SubsOfTwostring += (sumofB-sumofA);
           }        
        
        double SimilarPercentage = (SumOfTwostring - SubsOfTwostring)*100 / SumOfTwostring;
        
        return SimilarPercentage;
    }
    
    public boolean checking(String a,String b){
	//Only works when percentage is under 90
	if(similarityPercentage(a,b) <80.0 ){
	    System.out.println(similarityPercentage(a,b) );
	    return true;
	}
	else{
	    System.out.println(similarityPercentage(a,b));
	    return false;
	}
    }
}