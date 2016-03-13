package dev.euler.prob26;

import java.io.File;
import java.util.Date;

import dev.Utils;
import edu.naren.Sorting;

public class NameScores {

	public static void main(String[] args) {

		//int[] ar = new int[] { 5, 4, 3, 2, 1, 20, 13, 12 };
	//	System.out.println(partition(ar, 0, ar.length-1));
		
		
		
		
		System.out.println('A'-0);
		System.out.println("ABC".getBytes()[0]);
		
		

     String[] test=Utils.getStringDataFromFile(new File("p022_names.txt")).replaceAll("\"", "").split(",");	
   System.out.println(new Date());
     Sorting.mergeSort(test);
     System.out.println(new Date());
     int score=0;
    for(int i=1;i<=test.length;i++){
    	score=score+getNameScore(test[i-1], i);
    }
    System.out.println("score:"+score);
	}
	
	
	private static final byte ALPHA_A='A';
	
   public static int getNameScore(String name,int index){
	   int score=0;
	   for(byte byt:name.getBytes()){
		   score=score+(byt+1-ALPHA_A);
	   }
	   return score*index;
   }


}
