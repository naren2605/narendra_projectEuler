package dev.euler.prob17;

import java.util.HashMap;

import dev.Utils;

public class NumberLetterCounts {
/**
 * this recursive approach will work for numbers lessthan ten thousand
 * should imporve it for thousands and lakhs.
 */
	private static HashMap<Long, String> map = new HashMap<Long, String>();
	static{
	map.put(0L, "zero");
	map.put(1L, "one");
	map.put(2L, "two");
	map.put(3L, "three");
	map.put(4L, "four");
	map.put(5L, "five");
	map.put(6L, "six");
	map.put(7L, "seven");
	map.put(8L, "eight");
	map.put(9L, "nine");
	map.put(10L, "ten");
	map.put(11L, "eleven");
	map.put(12L, "twelve");
	map.put(13L, "thirteen");
	map.put(14L, "fourteen");
	map.put(15L, "fifteen");
	map.put(16L, "sixteen");
	map.put(17L, "seventeen");
	map.put(18L, "eighteen");
	map.put(19L, "nineteen");
	map.put(20L, "twenty");
	map.put(30L, "thirty");
	map.put(40L, "forty");
	map.put(50L, "fifty");
	map.put(60L, "sixty");
	map.put(70L, "seventy");
	map.put(80L, "eighty");
	map.put(90L, "ninety");
	map.put(100L, "hundred");
	map.put(1000L, "thousand");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

String result="";

for(long i=1;i<=1000;i++){
	result=result+""+getStringRepresentationOfNumber(i,false);
	System.out.println(getStringRepresentationOfNumber(i,false));
}
		result=result.replaceAll(" ", "");
		System.out.println(result.length());
	
	}

	
	public static String getStringRepresentationOfNumber(long number,boolean inloop){
		
		int size=(""+number).length();	
		
		if(map.get(number)!=null){
			return map.get(number);
		}
		else{
			int i=size-1;
			if(size >2 &&(number%100==0)){
				return map.get((number/Utils.power(10,i)))+" "+getStringRepresentationOfNumber(Utils.power(10,i),true);
			}
			else if(size >2){
				return map.get((number/Utils.power(10,i)))+" "+getStringRepresentationOfNumber(Utils.power(10,i),true)+" and "+getStringRepresentationOfNumber(number-(number/Utils.power(10,i))*Utils.power(10,i),true);
			}
				
			else{
				return getStringRepresentationOfNumber((number/Utils.power(10,i))*Utils.power(10,i),true)+" "+getStringRepresentationOfNumber(number-(number/Utils.power(10,i))*Utils.power(10,i),true);

			}
			
			
		}
		

	}
}
