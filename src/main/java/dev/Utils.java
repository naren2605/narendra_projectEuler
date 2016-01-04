package dev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

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
	
	public static long sumOfNaturalNumbers(long endIndex){
		return (endIndex*(endIndex+1))/2;
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
	
	
    public static String add(int[][] data){
    	int rlen=data.length;
    	int clen=data[0].length;
    	ArrayList<Integer> sumList=new ArrayList<Integer>(); 
    	for(int i=0;i<clen;i++){
    		int sum=0;
    		for(int j=0;j<rlen;j++){
    			sum=sum+data[j][i];
    			
    		}
    		
    		sumList.add(sum);
    	}
    	
    	Collections.reverse(sumList);
    	int overFlowSum=0;
		for(int i=0;i<sumList.size();i++){
			if(i+1==sumList.size()&&(sumList.get(i)/10>0)){
				int overflow=sumList.get(i)/10;
				int number=sumList.get(i)%10;
				sumList.set(i, number);
				sumList.add(i+1, overflow);
			}
			else if(i+1<sumList.size()){
				int overflow=sumList.get(i)/10;
				int number=sumList.get(i)%10;
				sumList.set(i, number);
				sumList.set(i+1, overflow+sumList.get(i+1));
			}
			
		}
		
		String sum="";
		for(int i:sumList){
			sum=i+sum;
		}
        return sum;		
    }
	
	
	public static String getStringDataFromFile(File file){
		String data="";
		try{
			FileReader fr= new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
		
			String line="";
			for(;(line=br.readLine())!=null;){
				data=data+line;
			}
		}
		catch(Exception e){
			
		}
		return data;
	}
	
	
	public static int[][] convertStringData(String data,int numberLength){
		int size=data.length()/numberLength;
		if(data.length()%2!=0){
			size=size+1;
		}
		int[][] sparseArray=new int[size][];
		
		for(int i=0,k=0;k<size;i=i+numberLength,k++){
			if(i>data.length()){
				
				sparseArray[k]=convertStringDataToNumericData(data.substring(i-numberLength, data.length()), 1);
			}
			else{
				
				sparseArray[k]=convertStringDataToNumericData(data.substring(i, i+numberLength), 1);
			
	
			}
					}
		
		
		return sparseArray;
	}

	
	public static int[] convertStringDataToNumericData(String data,int numberLength){
		byte[] dataBytes=data.getBytes();
		int size=dataBytes.length/numberLength;
		if(dataBytes.length%numberLength!=0){
			size++;
		}
		int[] dataIntArray=new int[size];
		int zero=(int)'0';
		for(int i=0,k=0;i<dataBytes.length;i=i+numberLength,k++){
		   int  localdata=-1;
			for(int j=0;j<numberLength&&(i+j)<dataBytes.length;j++){
	          if(localdata<0){
	        	  localdata=0;
	          }
	          localdata=(localdata*10+(((int)dataBytes[i+j])-zero));
			}
			if(localdata>0){
				
				dataIntArray[k]=localdata;
			}
		}
		return dataIntArray;
	} 
}
