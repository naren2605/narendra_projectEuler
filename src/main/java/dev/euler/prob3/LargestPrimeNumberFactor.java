package dev.euler.prob3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dev.euler.prob23.NonAbundantSums;

public class LargestPrimeNumberFactor {
public static void main(String[] args) {

	long mainnmber=600851475143L;
	long number=mainnmber/2;
	System.out.println(number);
	/*ArrayList<Long> list=NonAbundantSums.getDivisors();
	Collections.sort(list, new Comparator<Long>() {
		@Override
		public int compare(Long o1, Long o2) {
			if(o1>o2){
				return -1;
			}
			else if(o1<o2){
				return 1;
			}
			return 0;
		}
		});
	System.out.println("sorted...");*/
	//long number=0;
/*	for(long i=number;i>0;i--){
		System.out.println("number primenumber test");
		if(isPrimeNumber(i)){
			number=i;
		   break;
		}
	}
	System.out.println("factor=="+number);
*/
	//System.out.println(fermatPrime(5));
	
	
//System.out.println(getSquareRootApproxi(mainnmber/2));	
	//System.out.println(getSquareRootApproxi(mainnmber/2)+1);
	long sqrt=getSquareRootApproxi(mainnmber/2)+1l;
	long grestestPrimeFacctor=0;
	for(long i=sqrt;i>0;i--){
		System.out.println(i);
		if((mainnmber%i==0)&&isPrimeNumber(i)){
			grestestPrimeFacctor=i;
			break;
		}
	}
	
	System.out.println("gretest prime factor =="+grestestPrimeFacctor);
	}
	


public static long fermatPrime(long index){
	
	return power(2,power(2,index))+1;
}
public static long power(long base,long index){
	long result=1;
	for(long i=0;i<index;i++){
		result=result*base;
	}
	return result;
}
	
	public static boolean isPrimeNumber(Long number){
		
		boolean isPrime=true;
		
		
		
		
		long root=getSquareRootApproxi(number)+1;
	   if(number==1||number==2||number==3){
		   return true;
	   }
	   if(number%2==0||number%3==0){
		   return false;
	   }
	   //System.err.println("ROOT:"+root);
		for(int i=3,k=1,count=1;i<=root;i++){
	  	  int localk=count;
	  	  
    	  k=(6*localk-1);
    	 //System.out.println(">>"+k);
    	  if(number%k==0&& number!=k){
    		   isPrime=false;
    		   break;
    		  
    	   }
    	  k=(6*localk+1);
    	  //System.out.println("<<"+k);
    	  if(number%k==0 && number!=k){
   		    
    		  isPrime= false;
    		  break;
   		  
   	   	   }
    	  count++;
	    }
		
		/*for(long i=2;i<=number/2;i++){
			if(number%i==0){
				isPrime=false;
				break;
			}
		}*/
		return isPrime;
	}
	
	
	public static long getSquareRootApproxi(long number){
		
		double guess=1.0;
		double upperBound=number;
		double doublenumber=number;
		guess=(1/2.0)*(guess+(doublenumber/guess));
		//System.out.println("doublenumber-(guess*guess) :"+((guess*guess)-doublenumber));
		while((((guess*guess)-doublenumber)>0.01)){
			guess=(1/2.0)*(guess+(doublenumber/guess));
		//	System.out.println("guess=="+guess);
		}
		
		//System.out.println(guess);
		return (long) (guess);
	}
	public static double getSquareRootApproxiDouble(long number){
		
		double guess=1.0;
		double upperBound=number;
		double doublenumber=number;
		guess=(1/2.0)*(guess+(doublenumber/guess));
		//System.out.println("doublenumber-(guess*guess) :"+((guess*guess)-doublenumber));
		while((((guess*guess)-doublenumber)>0.01)){
			guess=(1/2.0)*(guess+(doublenumber/guess));
		//	System.out.println("guess=="+guess);
		}
		
		//System.out.println(guess);
		return guess;
	}
	
	
/*	public static long getSquareRootApproxi(long number,long lowerBound,long upperBound){
		
	}
*/}
