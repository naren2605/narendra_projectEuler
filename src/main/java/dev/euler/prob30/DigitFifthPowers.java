package dev.euler.prob30;

import dev.Utils;

public class DigitFifthPowers {
	public static void main(String[] args) {
     
	long end=	5*Utils.power(9, 5);
	long  totalFifthDigitPowers=0;
	long  tot=0;
	for(long i=2;i<=end;i++){
		long local=i;
		long total=0;
		for(long count=0;local!=0;count++){
			total=total+(Utils.power(local%10, 5));
			local=local/10;
		}
		if(i==total){
		System.out.println(i);
			tot=tot+i;
		}
	}
	System.out.println(tot);
	}
public static long fifthPowers(long number){
		
	
	return 0;
	}
	
}
