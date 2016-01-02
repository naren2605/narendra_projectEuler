package dev.euler.prob5;

import java.util.ArrayList;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * @author narendra kumar
 *
 */
public class SmallestMultiple {
public static void main(String[] args) {
	ArrayList<Integer> list=new ArrayList<Integer>();
	for(int i=1;i<=10;i++){
		list.add(i);
	}
	int lcm=1;
	for(int i=0,k=1;i<list.size();i++,k++){
		int divisor=list.get(i);
		lcm=lcm*divisor;
		for(int j=i+1;j<list.size();j++){
			if(list.get(j)%divisor==0){
				list.set(j,list.get(j)/divisor);
			}
		}
	}
	System.err.println(list.toString());
	System.err.println(lcm);
}
}
