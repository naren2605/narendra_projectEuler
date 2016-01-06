package dev.euler.prob17;

import java.util.HashMap;

public class NumberLetterCounts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> map = new HashMap<Integer, String>();
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
		map.put(100, "hundred");
		map.put(1000, "thousand");
		for(int i=1;i<=1000;i++){
			if(i<=10){
				System.out.println(map.get(i));
			}
			else if(i>10 && i<100){
				int k=i/10;
			}
			else if(i==100){
				System.out.println(map.get(i));
			}
			else if(i<1000 && i>100){
				
				int k=i/100;
				
				
			}
			else if(i==1000){
				System.out.println(map.get(i));
			}
		}
		
		
		
	}

}
