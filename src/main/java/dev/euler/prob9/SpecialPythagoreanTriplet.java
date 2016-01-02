package dev.euler.prob9;

import dev.euler.prob3.LargestPrimeNumberFactor;

public class SpecialPythagoreanTriplet {

	public static void main(String[] args) {
		int pythogorianTrippleSum=1000;
	//15140625=15140625	  we got tripple..200,375,425
		for(int a=1;a<=pythogorianTrippleSum;a++){
			for(int b=a+1;b<=pythogorianTrippleSum;b++){
				if(a+b<pythogorianTrippleSum){
					int c= pythogorianTrippleSum-a-b;
					if(c*c==((a*a)+(b*b))){
						System.out.println("we got tripple.."+a+","+b+","+c+"==="+(c*c)+"="+(a*a)+"+"+(b*b)+"==abc="+(a*b*c));
					}
				}
				else{
					break;
				}
				
			}
		}

	}

}
