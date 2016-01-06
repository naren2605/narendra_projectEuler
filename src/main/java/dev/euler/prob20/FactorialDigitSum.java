package dev.euler.prob20;

import dev.Utils;

public class FactorialDigitSum {

	public static void main(String[] args) {

		String hundredFactorial=Utils.factorial("100");
		
		int[] factorialArray=Utils.convertStringToIntArray(hundredFactorial);
		int sum=0;
		for(int i=0;i<factorialArray.length;i++){
			sum=sum+factorialArray[i];
		}
		System.out.println(sum);
	}
	
}
