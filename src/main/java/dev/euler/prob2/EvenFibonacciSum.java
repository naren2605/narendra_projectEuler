package dev.euler.prob2;

public class EvenFibonacciSum {
/**
 * Problem 2
Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i=-1,j=1,sum=0;
int threshold=4000000;
		while(i<0||i<threshold){
	        i=fibnocii(j++); 
	        if(i%2==0){
	        	sum=sum+i;	
	        }
			
			}
		System.out.println(sum);
	}
	
    public static int fibnocii(int number){
    	if(number==0||number==1){
    		return 1;
    	}
    	else{
    		return fibnocii(number-2)+fibnocii(number-1);	
    	}
    	
    	
    }

}
