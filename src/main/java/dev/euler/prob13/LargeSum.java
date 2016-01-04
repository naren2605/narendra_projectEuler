package dev.euler.prob13;

import java.io.File;

import dev.Utils;

public class LargeSum {
	public static void main(String[] args) {
		File file= new File("problem13Data");
	
		
		String dataString=Utils.getStringDataFromFile(file);
		//String dataString="1224";
		int[][] data=Utils.convertStringData(dataString, 50);
	    System.out.println(Utils.add(data));
		
		
	}
}
