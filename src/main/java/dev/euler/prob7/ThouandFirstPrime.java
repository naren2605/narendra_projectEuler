package dev.euler.prob7;

import dev.euler.prob3.LargestPrimeNumberFactor;

public class ThouandFirstPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int thousandFirstPrime=0;
          for(int i=3,k=1,count=1;i!=10002;){
        	  int localk=count;
        	  k=(6*localk-1);
        	  if(LargestPrimeNumberFactor.isPrimeNumber((long)k)){
        		
        		 System.err.println("improving count"+i+"prime=="+k+" :is6k?=="+is6kFormat(k));
        		 thousandFirstPrime=k;
        		 i++; 
        	  }
        	  k=(6*localk+1);
        	  if(LargestPrimeNumberFactor.isPrimeNumber((long)k)){
          		
         		 System.err.println("improving count"+i+"prime=="+k+" :is6k?=="+is6kFormat(k));
         		 thousandFirstPrime=k;
         		 i++; 
         	  }
        	  count++;
          }
          System.out.println(thousandFirstPrime);
	}
	
    public static String is6kFormat(int k){
    	String is6k="false";
    	if((k+1)%6==0){
    		is6k="6k-1 where k="+((k+1)/6);
    	}
    	else if((k-1)%6==0){
    		is6k="6k+1 where k="+((k-1)/6);
    	}
    	return is6k;
    }
}
