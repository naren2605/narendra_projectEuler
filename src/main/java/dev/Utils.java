package dev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

import dev.euler.prob23.NonAbundantSums;
import dev.euler.prob3.LargestPrimeNumberFactor;

public class Utils {
public static final	int ZERO=(int)'0';
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
	
	public static String power(String base,long index){
		String result="1";
		for(long i=0;i<index;i++){
			result=multiply(result, base).replaceFirst("0*", "");
		}
		return result;
	}
	public static String multiply(String number1,String number2){
		
		int[]number1Array=convertStringToIntArray(number1);
		int[]number2Array=convertStringToIntArray(number2);
		int[]temp=null;
		if(number2Array.length>number1Array.length){
			temp=number2Array;
			number2Array=number1Array;
			number1Array=temp;
		}
	    
		ArrayList<int[]> list= new ArrayList<int[]>();
		for(int i=number2Array.length-1;i>=0;i--){
		     int[][] duplicateRows=duplicateRows(number1Array, number2Array[i]);
		     
		     String result=add(duplicateRows);
			list.add(convertStringToIntArray(result));
			
			
		}
		int size1=number1Array.length;
		int size2=number2Array.length;
		
		int resultantSize=size1+size2;
		for(int i=0;i<list.size();i++){

				int[] array = list.get(i);
				int diff=resultantSize-array.length;
				list.set(i, rearrangeIntArray(array, i, diff, resultantSize));
				
			
			
		}
		
	
		int [][] result=new int [list.size()][resultantSize];
		
		for(int i=0;i<list.size();i++){
			result[i]=list.get(i);
		}
		String endResult=add(result);
		return endResult.replaceFirst("0*", "");
		
	}
	
	
	private static int[] rearrangeIntArray(int[] data,int i,int diff,int maxSize){
		int[] arrangedArray=new int[maxSize];
		int count=0;
		for(int k=0;k<diff-i;k++){
			arrangedArray[k]=0;
			count++;
		}
		for(int k=diff-i, p=0;k<arrangedArray.length-i;k++,p++){
			arrangedArray[k]=data[p];
		}
		for(int k=arrangedArray.length-i;k<arrangedArray.length;k++){
			arrangedArray[k]=0;
		}
		return arrangedArray;
	}
	
 public static void main(String[] args) {
	
	 String product=power("2", 1000);
	 System.out.println(product);
	 int[] productarray=convertStringToIntArray(product);
	 long sum=0L;
	 for(int i=0;i<productarray.length;i++){
		 sum=sum+productarray[i];
	 }
	 
	 System.out.println(sum);
}
	
	public static int[][] duplicateRows(int[] data,int rowsize){
		int[][] array=new int[rowsize][];
		
		
		for(int i=0;i<rowsize;i++){
			int[] duplicate=new int[data.length];
			for(int k=0;k<data.length;k++){
				duplicate[k]=data[k];
			}
			array[i]=duplicate;
		}
		
		return array;
	}
	
	public static int[] convertStringToIntArray(String number){
		int zero=(int)'0';
		byte[] data=number.getBytes();
		int[] numericData=new int[data.length];
		for(int i=0;i<data.length;i++){
			numericData[i]=((int)data[i]-zero);
		}
		return numericData;
 	}
	
    public static String add(int[][] data){
    	int rlen=data.length;
    	if(rlen==0){
    		return "0";
    	}
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
