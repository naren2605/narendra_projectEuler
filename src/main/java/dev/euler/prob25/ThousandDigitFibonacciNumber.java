package dev.euler.prob25;

import dev.Utils;

public class ThousandDigitFibonacciNumber {

	public static String fibnocii(String varSum1,String varSum2){
	     String sum1=varSum1;
	     String sum2=varSum2;
	     String fib="1";
 

  			fib=Utils.add(sum1,sum2);
  			sum1=sum2;
  			sum2=fib;
  		
  	//	System.out.println("fib sum1=="+sum1+" sum2===="+sum2);
  	
  	
  	return sum2;
  }

	
	public static void main(String[] args) {

		
		int size=-1;
		String sum1=null;
		String sum2=null;
		int lockIndex=0;
		for(int i=1;size<=1000;i++){
		
			
			if(sum2==null){
				sum2=Utils.fibnocii(i+"");
				//System.err.println(i+":"+sum2);
			}
			else if(sum1==null){
				sum1=sum2;
				sum2=Utils.fibnocii(i+"");
				//System.err.println(i+":"+sum2);
			}
			else if(sum1!=null && sum2!=null){
			//System.out.println("testing..i:"+i+":"+sum2);
				String temp=sum2;
				sum2=fibnocii(sum1, sum2);
				sum1=temp;
				//System.err.println(i+":"+sum2);
			}
			if(size<0){
				size=0;
			}
			if(size<sum2.length()){
				
				size=sum2.length();
               if(size==1000){
            	   lockIndex=i;
            	   break;
               }
			}
		}
		System.out.println(lockIndex);
	}

}
