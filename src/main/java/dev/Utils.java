package dev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
	
	
	
	public static int fibnocii(int number){
    	if(number==0||number==1){
    		return 1;
    	}
    	else{
    		return fibnocii(number-2)+fibnocii(number-1);	
    	}
    	
    	
    }
	
	public static String fibnocii(String number2){
	     String sum1="0";
	     String sum2="0";
	     String fib="1";
    	if(number2.equals("0")||number2.equals("1")){
    		return 1+"";
    	}
    	for(int i=0;i<=new Integer(number2)-1;i++){
    		if(i==0){
    			sum1="0";
    			sum2="1";
    			
    		}else{
    			fib=add(sum1,sum2);
    			sum1=sum2;
    			sum2=fib;
    		}
    		
    	}
    	
    	return sum2;
    }
	
	
	public static String add(String number1,String number2){
	   	int[] number1Array=convertStringToIntArray(number1);
	   	int[] number2Array=convertStringToIntArray(number2);
	    int[][] array= new int[2][];
	    
	   	int diff=(number1Array.length-number2Array.length);
	
	   	if(diff<0){
	   		int[] ar=new int[number2Array.length];
	   		for(int i=0;i<(-1*diff);i++){
	   			ar[i]=0;
	   		}
	   		for(int i=(-1*diff),k=0;i<ar.length;i++,k++){
	   	
	   			ar[i]=number1Array[k];
	   		}
	   		array[0]=ar;
	   		array[1]=number2Array;
	   	}
	   	else{
	   		int[] ar=new int[number1Array.length];
	   		for(int i=0;i<(diff);i++){
	   			ar[i]=0;
	   		}
	   		for(int i=(diff),k=0;i<ar.length;i++,k++){
	   			ar[i]=number2Array[k];
	   		}
	   		array[0]=ar;
	   		array[1]=number1Array;
	   	}
	   	
		return  add(array);
	}

	
    public static String sub(String number1,String number2){
		
		
		return  null;
	}
	
	public static String factorial(String number){
			String factorial="1";
		if(number.equals("0")){
			return factorial;
		}
		else{
			
			Integer temp=new Integer(number);
			for(int i=1;i<=temp;i++){
				factorial=multiply(factorial,i+"" );
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
		if(index==0) {
			return 1;
		}
		return LargestPrimeNumberFactor.power(base, index);
	}
	public static ArrayList<Long> getDivisors(long number){
		ArrayList<Long> list=NonAbundantSums.getDivisors(number);
		list.add(number);
		return list;
	}
	
	public static ArrayList<Long> getDivisorsWithOutNumber(long number){
		ArrayList<Long> list=NonAbundantSums.getDivisors(number);
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
	
	
	public static void main(String[] args) {
		search(21);
		
	}
    public static void search(int size){
    	Count count=new Count();
    	ArrayGraph g= new ArrayGraph(size);
    	search2(size,0,0,count,-1,-1,g,new ArrayList<List<Node>>(),new ArrayList<Utils.Node>());
    	System.out.println(count.i);
    	
     }
	
    public static class Count{
    	long i=0;
    	public Count() {
			
		}
    }
    public static class ArrayGraph{
    	HashSet<Node> nodes=new HashSet<Utils.Node>();
    	Node[][] nodeArray;
    	public ArrayGraph(int size) {
    		nodeArray=new Node[size][size];
    		for(int i=0;i<size;i++){
	
    			for(int j=0;j<size;j++){
    				Node n=new Node(i, j);
    				nodes.add(n);
    				nodeArray[i][j]=n;
        		}
    		}
    	}    	
    	Node getNode(int row,int column){
    		return nodeArray[row][column];
    	}
    	
    }
    public static class Node{
    	int row;
    	int column;
    	boolean visited=false;
    	public Node(int row,int column) {
		
    		this.row=row;
    		this.column=column;
    		
    	}
    	@Override
    	public String toString() {
    		return "("+row+","+column+")";
    	}
    }
    

    public static  void search2(int size,int row,int column,Count count,int rPrev,int cPrev,ArrayGraph g,List<List<Node>> pathlist,List<Node> path){
		if(row==size-1&&column==size-1){
			count.i=count.i+1;
			System.out.println("count.."+count.i);
			g.getNode(row, column).visited=false;
			return;
		}
		
		if(g.getNode(row, column).visited){
			g.getNode(row, column).visited=false;
			return;
		}

			g.getNode(row, column).visited=true;
		
		
		if(row>=0 && row<= size-1&&(column+1<=size-1&&column+1>=0&&(row!=rPrev||column+1!=cPrev))){
				search2(size, row, column+1, count,row,column,g,pathlist,path);		

		}
		if(column>=0 && column<= size-1&&(row+1<=size-1&&row+1>=0&&(column!=cPrev||row+1!=rPrev))){

				search2(size, row+1, column, count,row,column,g,pathlist,path);	
	
		}
		g.getNode(row, column).visited=false;
	};

    
    
	public static  void search(int size,int row,int column,Count count,int rPrev,int cPrev,ArrayGraph g,List<List<Node>> pathlist,List<Node> path){
		//System.out.println("row=="+row+"column=="+column+" rPrev=="+rPrev+" cPrev==="+cPrev);
		if(row==size-1&&column==size-1){
			count.i=count.i+1;
			System.out.println("count.."+count.i);
			g.getNode(row, column).visited=false;
		/*	path.add(g.getNode(row, column));
			pathlist.add(path);
			path=new ArrayList<Utils.Node>();*/
		/*	for(int i=0;i<pathlist.size();i++){
				System.out.println(pathlist.get(i)+" "+pathlist.get(i).hashCode());
			}*/
			return;
		}
		
		if(g.getNode(row, column).visited){
			g.getNode(row, column).visited=false;
			//System.out.println("("+row+","+(column)+") visited");
			return;
		}
		else{
			g.getNode(row, column).visited=true;
			/*path.add(g.getNode(row, column));*/
		}
		
		if(row>=0 && row<= size-1){
			/*if(row==2&&column==1){
				System.out.println("column...trace ("+rPrev+","+cPrev+")---("+row+","+column+")" +(column+1<=size-1&&column+1>=0)+""+(row!=rPrev&&column+1!=cPrev));
			}*/
			if(column+1<=size-1&&column+1>=0&&(row!=rPrev||column+1!=cPrev)){
			//	System.out.println("column+1");
		/*		if(g.getNode(row, column+1).visited){
					g.getNode(row, column+1).visited=false;
					System.out.println("("+row+","+(column+1)+") visited");
				
				}
				else{*/
					search(size, row, column+1, count,row,column,g,pathlist,path);		
				/*}*/
			//	g.getNode(row, column+1).visited=true;
				
			}
		/*	else if((row==rPrev&&column+1==cPrev)){
				//System.out.println("column+1 try ("+rPrev+","+(cPrev)+") visited..");
			}*/
/*            if(column-1>=0&&column-1<=size-1&&(row!=rPrev||column-1!=cPrev)){
            	System.out.println("column-1");
            	if(g.getNode(row, column-1).visited){
					g.getNode(row, column-1).visited=false;
					System.out.println("("+row+","+(column-1)+") visited");
				}
            	else{
            		search(size, row, column-1, count,row,column,g,pathlist,path);	
            	}
            	//g.getNode(row, column-1).visited=true;
            		
			}
            else if(row==rPrev&&column-1==cPrev){
            	System.out.println("column-1 try ("+rPrev+","+(cPrev)+") visited..");
            }*/
		}
		if(column>=0 && column<= size-1){
			if(row+1<=size-1&&row+1>=0&&(column!=cPrev||row+1!=rPrev)){
				//System.out.println("row+1");
			/*	if(g.getNode(row+1, column).visited){
					g.getNode(row+1, column).visited=false;
					System.out.println("("+(row+1)+","+(column)+") visited");
				}
				else{*/
					search(size, row+1, column, count,row,column,g,pathlist,path);	
				/*}*/
				//g.getNode(row+1, column).visited=true;
				
			}
		/*	else if(column==cPrev&&row+1==rPrev){
				System.out.println("row+1 try ("+rPrev+","+(cPrev)+") visited..");
			}*/
          /*  if(row-1>=0&&row-1<=size-1&&(column!=cPrev||row-1!=rPrev)){
            	System.out.println("row-1");
            	
            	if(g.getNode(row-1, column).visited){
					g.getNode(row-1, column).visited=false;
					System.out.println("("+(row-1)+","+(column)+") visited");
				}
            	else{
            		search(size, row-1, column, count,row,column,g,pathlist,path);	
            	}
            	//g.getNode(row-1, column).visited=true;
            	
			}
            else if(column==cPrev&&row-1==rPrev){
            	System.out.println("row-1 try ("+rPrev+","+(cPrev)+") visited..");
            }*/
		}
		g.getNode(row, column).visited=false;
	};
	
}
