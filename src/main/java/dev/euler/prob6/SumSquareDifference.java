package dev.euler.prob6;

import dev.euler.prob3.LargestPrimeNumberFactor;

public class SumSquareDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            int wholeSquareSum=0;
            int sumOfSquares=0;
            for(int i=1;i<=100;i++){
            	sumOfSquares=sumOfSquares+(int)LargestPrimeNumberFactor.power(i, 2);
            	wholeSquareSum=wholeSquareSum+i;
            }
            wholeSquareSum=(int)LargestPrimeNumberFactor.power(wholeSquareSum, 2);
            System.out.println("difference===="+(wholeSquareSum-sumOfSquares));
	}

}
