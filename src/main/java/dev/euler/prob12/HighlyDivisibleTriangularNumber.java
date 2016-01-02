package dev.euler.prob12;

import dev.Utils;

public class HighlyDivisibleTriangularNumber {
	/**
	 * this approach is taking time to calculate no.of divisors ,
	 * hence requires some change
	 * ans=76576500
	 * @param args
	 */
	public static void main(String[] args) {
		long k=76576500;
		       //17907120;
       boolean brak=false;
       long sizebookmark=0;
       long number=0;
		 for(long i=1;!brak;i++){
			 int size=Utils.getDivisors(number=Utils.sumOfNaturalNumbers(i)).size();
			 if(sizebookmark<size){
				 sizebookmark=size;
				 System.out.println(number+"==improving...==="+size);	 
			 }
			 
			 if(size>500){
				 brak=true;
			 }
		 }
		 System.out.println(number);
	}
}
