package edu.naren;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Sorting {

	public static void main(String[] args) {

		int[] ar = new int[] { 5, 4, 3, 2, 1, 20, 13, 12 };
		System.out.println(partition(ar, 0, ar.length-1));
		
		
		
		
	

	}

	public static int compare(int num1, int num2) {

		if (num1 > num2) {
			return 1;
		} else if (num1 < num2) {
			return -1;
		} else {
			return 0;
		}
	}

	public static void exch(int[] ar, int i, int j) {
		int temp = ar[j];
		ar[j] = ar[i];
		ar[i] = temp;
	}

	public static int partition(int[] aray, int lo, int hi) {
		int k = aray[lo];
		int i = lo;
		int j = hi + 1;

		while (true) {
              
			while(compare(aray[++i],k)<0) if(i==hi) break;
			while(compare(k,aray[--j])<0) if(j==lo) break;
			if(i>=j)break;
			exch(aray, i, j);
		}
    exch(aray,lo, j);
    for(int t=lo;t<=hi;t++){
    	System.out.print(aray[t] +" ");
    }
    System.out.println();
    return j;
	}
}
