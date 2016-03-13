package edu.naren;

import java.io.File;
import java.util.Date;

import dev.Utils;

public class Sorting {

	
	public static <Type extends Comparable<Type>> void mergeSort(Type[] array){

		/**
		 * clear static array and create new instance
		 */
		auxarrayMerge = (Type[])new Comparable[array.length];
		
		 mergeSort(array,0, array.length-1);
	}
	private static <Type extends Comparable<Type>> void mergeSort(Type[] array,int lo,int hi){
		
        if(hi<=lo) return;
       int  mid= lo+(hi-lo)/2;
        mergeSort(array,lo,mid);
        mergeSort(array,mid+1,hi);
        merge(array, lo, mid, hi);
	}

	public static abstract class Instance<Type>{
		 abstract Type getInstance();
		 abstract Type[] getInstanceArray(int size);
	}
	private static Object auxarrayMerge=null;
	public static <Type extends Comparable<Type>> void merge(Type[] array,int lo,int mid,int hi){
		int i=lo,j=mid+1;
		Type auxArray[]=null;
	
			auxArray=(Type[])auxarrayMerge;
		
	    for(int k=lo;k<=hi;k++){
	    	auxArray[k]=array[k];
	    }
	    for(int k=lo;k<=hi;k++){
	    	if(i>mid){
	    		
	    		array[k]=auxArray[j++];
	    		System.out.println("copying1 "+array[k]+" "+(j-1));
	    	}
	    	else if(j>hi){
	    		array[k]=auxArray[i++];
	    		System.out.println("copying2 "+array[k]+" "+(i-1));
	    	}
	    	else if(auxArray[i].compareTo(auxArray[j])<0){
	    		
	    		array[k]=auxArray[i++];
	    		System.out.println("copying3 "+array[k]+" "+(i-1));
	    	}
	    	else{
	    		array[k]=auxArray[j++];
	    		System.out.println("copying4 "+array[k]+" "+(j-1));
	    	}
	    }
	    
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
