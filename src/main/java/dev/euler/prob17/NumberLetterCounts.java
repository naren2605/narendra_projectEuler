package dev.euler.prob17;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;

import dev.Utils;

public class NumberLetterCounts {
	private static HashMap<Integer, String> map = new HashMap<Integer, String>();
	static{
	map.put(0, "zero");
	map.put(1, "one");
	map.put(2, "two");
	map.put(3, "three");
	map.put(4, "four");
	map.put(5, "five");
	map.put(6, "six");
	map.put(7, "seven");
	map.put(8, "eight");
	map.put(9, "nine");
	map.put(10, "ten");
	map.put(11, "eleven");
	map.put(12, "twelve");
	map.put(13, "thirteen");
	map.put(14, "fourteen");
	map.put(15, "fifteen");
	map.put(16, "sixteen");
	map.put(17, "seventeen");
	map.put(18, "eighteen");
	map.put(19, "nineteen");
	map.put(20, "twenty");
	map.put(30, "thirty");
	map.put(40, "forty");
	map.put(50, "fifty");
	map.put(60, "sixty");
	map.put(70, "seventy");
	map.put(80, "eight");
	map.put(90, "ninety");
	map.put(100, "hundred");
	map.put(1000, "thousand");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*

		for(int i=1;i<100;i++){
			if(i<=19){
				System.out.println(map.get(i));
			}
			else if(i>19 && i<100){
				int k=i%10;
				int j=(i/10)*10;
				
				if(k!=0){
					System.out.println(map.get(j)+" "+map.get(k));
				}
				else{
					System.out.println(map.get(j));
				}
			}
			else if(i==100){
				System.out.println(map.get(i));
			}
			else if(i<1000 && i>100){
				
				int k=i/100;
				int p=i/10;
				
				
			}
			else if(i==1000){
				System.out.println(map.get(i));
			}
		}*/
		
	//	System.out.println(getStringRepresentationOfNumber(100));
		
	
	}

	
/*	public static String getStringRepresentationOfNumber(long number){
		
		int size=(""+number).length();
	
		if(size==1){
			return map.get(number);
		}
		else if(size==2){
			if(number<20||number%10==0){
				return map.get(number);
			}
			else{
				 getStringRepresentationOfNumber((number/10)*10)+" "+getStringRepresentationOfNumber(number%10);
			}
		}
		if(size==3){
			if(number%10==0){
				return map.get(number);
			}
		}
		
		if(map.get(number)!=null){
			return map.get(number);
		}
		else{
			int i=size-1;
			if(size>2){
				return getStringRepresentationOfNumber((number/Utils.power(10,i))*Utils.power(10,i))+" and  "+getStringRepresentationOfNumber(number%10);
			}
			
			
		}
		

	}*/
}
