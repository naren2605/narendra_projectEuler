package dev.euler.prob10;

import dev.euler.prob3.LargestPrimeNumberFactor;

public class SummationOfPrimes {
public static void main(String[] args) {
	
	int thousandFirstPrime=0;
	long sum=2+3;
    for(int i=3,k=1,count=1;thousandFirstPrime<=2000000;){
  	  int localk=count;
  	  k=(6*localk-1);
  	  if(k>2000000){
  		  break;
  	  }
  	  if(LargestPrimeNumberFactor.isPrimeNumber((long)k)){
  		 
  		 thousandFirstPrime=k;
  		 sum=sum+k;System.out.println("prime:"+k);
  		 i++; 
  	  }
  	  k=(6*localk+1);
  	  if(LargestPrimeNumberFactor.isPrimeNumber((long)k)){
  		System.out.println("prime:"+k);
   		 thousandFirstPrime=k;
   		 sum=sum+k;
   		 i++; 
   	  }
  	  count++;
    }
    System.out.println("sum of primes="+sum);
}
}
