package dev.euler.prob16;

import dev.Utils;

public class PowerDigitSum {

	 public static void main(String[] args) {
			
		 String product=Utils.power("2", 1000);
		 System.out.println(product);
		 int[] productarray=Utils.convertStringToIntArray(product);
		 long sum=0L;
		 for(int i=0;i<productarray.length;i++){
			 sum=sum+productarray[i];
		 }
		 
		 System.out.println(sum);
	}

}
