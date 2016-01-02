package dev.euler.prob23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NonAbundantSums {
/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NumberCategory nc= getNumnberCategeory(28123 , 28123);
		Map<Integer, ArrayList<Integer>> perfectNumbers= nc.getPerfectNumbers();
		Map<Integer, ArrayList<Integer>> deficientNumbers= nc.getDeficientNumbers();
		Map<Integer, ArrayList<Integer>> abundantNumbers= nc.getAbundantNumbers();
		Set<Integer> keys=perfectNumbers.keySet();
		/*System.out.println(">>>>>>>>>>>>>>>>>PERFECT NUMBERS:"+keys.size()+"<<<<<<<<<<<<<<<<<<<<<<");
		for(Integer perfectnumber:keys){
			System.out.println(perfectnumber+"----->"+perfectNumbers.get(perfectnumber).toString());
		}
		*/
	/*	keys=deficientNumbers.keySet();
		System.out.println(">>>>>>>>>>>>>>>>>DEFEICIENT NUMBERS:"+keys.size()+"<<<<<<<<<<<<<<<<<<<<<<");
		for(Integer number:keys){
			System.out.println(number+"----->"+deficientNumbers.get(number).toString());
		}*/
		
		keys=abundantNumbers.keySet();
	/*	System.out.println(">>>>>>>>>>>>>>>>>ABUNDANT NUMBERS:"+keys.size()+"<<<<<<<<<<<<<<<<<<<<<<");
		
		//
		for(Integer number:keys){
			System.out.println(number+"----->"+abundantNumbers.get(number).toString());
		}
		*/
		//System.out.println(sumOfNumbersSumCannotBeExpressedAsTwoAbundantNumbers());
	}

	
	public static int sumOfNumbersSumCannotBeExpressedAsTwoAbundantNumbers(){
	
		int limit=28123;
		NumberCategory nc= getNumnberCategeory(1 , limit);
		//Map<Integer, ArrayList<Integer>> perfectNumbers= nc.getPerfectNumbers();
		//Map<Integer, ArrayList<Integer>> deficientNumbers= nc.getDeficientNumbers();
		Map<Integer, ArrayList<Integer>> abundantNumbers= nc.getAbundantNumbers();
		Set<Integer> abundantNumberSet=abundantNumbers.keySet();
		/*ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i :abundantNumberSet){
		arrayList.add(i);	
		}
		Collections.sort(arrayList, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1>o2){
				return 1;
			}
			else if(o1<o2){
				return -1;
			}
			return 0;
		}
		});
		System.out.println("array....");
		System.out.println(arrayList.toString());
		//return 0;
	*/	int iterations=0;
		int sum=0;
		
		Set<Integer> set= new HashSet<Integer>();
/*	
		    for(int j=0;j<arrayList.size();j++){
		    	for(int k=0;k<arrayList.size();k++){
		    		if(arrayList.get(j)+arrayList.get(k)<=limit){
		    			
		    			if(set.add(arrayList.get(j)+arrayList.get(k))){
		    				System.out.println(arrayList.get(j)+"+"+arrayList.get(k));
		    			}
		    		}
		    		if(i==(arrayList.get(j)+arrayList.get(k))){
		    			
		    			if(!set.add(i)){
		    			System.out.println("duplicate.."+i);	
		    			}
		    		}
		    	}
		    }
		System.out.println("setsiz="+set.size());
		
		for(int i=0;i<limit;i++){
			if(!set.contains(i)){
				sum=sum+i;
			}
		}
		System.err.println("sum=="+sum);*/
		Set<Integer> extractSet= new HashSet<Integer>();
		for(int i=1;i<=limit;i++){
	
			for(int key:abundantNumberSet){
	/*			if(i==24){
					System.err.println("test for i==24");
				}*/
				if((i-key)>0){
				if(abundantNumberSet.contains(i-key)){
			
					//System.err.println("Got a number :"+i+"  key="+key+" :i-key="+(i-key)+" map="+abundantNumbers.get(key).toString());
					iterations++;
					extractSet.add(i);
					break;
				}
				}
			
			}
		
		}

		sum=0;
for(int i=0;i<limit;i++){
	if(!extractSet.contains(i)){
		sum=sum+i;
	}
	
}
		
		return sum;
		
	}
	
	public static NumberCategory getNumnberCategeory(int fromNumberInclusive,int toNumberInclusive){
		
		 Map<Integer,ArrayList<Integer>> perfectNumbers= new HashMap<Integer, ArrayList<Integer>>();
		 Map<Integer,ArrayList<Integer>> deficientNumbers= new HashMap<Integer, ArrayList<Integer>>();
		 Map<Integer,ArrayList<Integer>> abundantNumbers= new HashMap<Integer, ArrayList<Integer>>();
		NumberCategory numberCategory= new NumberCategory(perfectNumbers, deficientNumbers, abundantNumbers);
		if(fromNumberInclusive>=toNumberInclusive){
			throw new RuntimeException("please enter fromNumberInclusive < toNumberInclusive ");
		}
		else{
			
			for(int i=fromNumberInclusive;i<=toNumberInclusive;i++){
			    
				ArrayList<Integer> divisosrsOfI=getDivisors(i);
				
				int sum=0;
				for(int divisor:divisosrsOfI){
					sum=sum+divisor;
				}
				
				if(sum==i){
					perfectNumbers.put(i, divisosrsOfI);
				}
				else if(sum<i){
					deficientNumbers.put(i, divisosrsOfI);
				}
				else if(sum > i){
					abundantNumbers.put(i, divisosrsOfI);
				}
				
			}
		}
	return numberCategory;	
	}
	
	public static ArrayList<Integer> getDivisors(int number){
		 ArrayList<Integer> divisors= new ArrayList<Integer>();
		int maxDivisorLimit=number/2+1;
		
	    for(int i=1;i<maxDivisorLimit;i++){
	    	if(number%i==0){
	    		divisors.add(i);
	    	}
	    }
		return divisors;
	}
	
	public static ArrayList<Long> getDivisors(long number){
		 ArrayList<Long> divisors= new ArrayList<Long>();
		long maxDivisorLimit=number/2+1;
		
	    for(long i=1;i<maxDivisorLimit;i++){
	    	if(number%i==0){
	    		divisors.add(i);
	    	}
	    }
		return divisors;
	}
}
