package dev;

import java.util.ArrayList;

import dev.euler.prob23.NonAbundantSums;
import dev.euler.prob3.LargestPrimeNumberFactor;

public class Utils {
	public static int factorial(int number){
		int factorial=1;
		if(number==0){
			return factorial;
		}
		else{
			int tempNumber=number;
			while(tempNumber!=0){
				factorial=factorial*tempNumber--;
			}
			
			return factorial;
		}
	}
	
	public static boolean isPrime(long number){
		return LargestPrimeNumberFactor.isPrimeNumber(number);
	}
	
	public static long sqrt(long number){
		return LargestPrimeNumberFactor.getSquareRootApproxi(number);
	}
	public static long power(long base ,long index){
		return LargestPrimeNumberFactor.power(base, index);
	}
	public static ArrayList<Long> getDivisors(long number){
		ArrayList<Long> list=NonAbundantSums.getDivisors(number);
		list.add(number);
		return list;
	}
}
