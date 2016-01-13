package dev.euler.prob21;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dev.Utils;

public class AmicableNumbers {


	public static void main(String[] args) {

	long sum=0;
	Set<Integer> set=new HashSet<Integer>();
	for(int i=1;i<=10000;i++){
		
			long sum2=sum(i);
			if(i==sum(sum2) &&(i!=sum2)){
				set.add(i);
				System.out.println("amicable number ="+i+" reflection "+sum2);
			}
     
		
	}
		
		System.out.println(set.size());
		for(int i:set){
			sum=sum+i;
		}
		System.out.println(sum);
	}

	
	public static long  sum(long number){
		List<Long> divisors=Utils.getDivisorsWithOutNumber(number);
		long total=0;
		for(Long divisor:divisors){
			total=total+divisor;
		}
		return total;
	}
}
