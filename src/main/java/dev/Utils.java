package dev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.spi.LocaleNameProvider;

import dev.euler.prob23.NonAbundantSums;
import dev.euler.prob3.LargestPrimeNumberFactor;
import edu.naren.StackList;

public class Utils {
public static final	int ZERO=(int)'0';

public static final boolean test=false;
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
		Integer  number1Precision=null;
		Integer number2Precision=null;
		int finalPrecision=0;
		if(number1.matches("\\d+\\.\\d+")){
			number1Precision=number1.replaceAll("^\\d+\\.", "").length();
			number1=number1.replaceAll("\\.", "");
		}
        if(number2.matches("\\d+\\.\\d+")){
        	number2Precision=number2.replaceAll("^\\d+\\.", "").length();
        	number2=number2.replaceAll("\\.", "");
         }
   

          if(number1Precision!=null&&number2Precision!=null){
        	  int diff=number1Precision-number2Precision;
        	  if(diff>0){
        		  finalPrecision=number1Precision;
        		  for(int i=0;i<diff;i++){
        			  number2=number2+"0";
        		  }
        	  }
        	  else{
        		  finalPrecision=number2Precision;
        		  for(int i=0;i<(-1*diff);i++){
        			  number1=number1+"0";
        		  }
        	  }
          }
          else if(number1Precision!=null){
        	
        		  finalPrecision=number1Precision;
        		  for(int i=0;i<finalPrecision;i++){
        			  number2=number2+"0";
        		  }
        	  
          }
          else if(number2Precision!=null){
        	  
        
        		  finalPrecision=number2Precision;
        		  for(int i=0;i<finalPrecision;i++){
        			  number1=number1+"0";
        		  }
        	  
          }
        
	   	String res=add(equalizeNumbers(number1, number2));
	   	if(finalPrecision>0){
			res=res.substring(0,res.length()-finalPrecision)+"."+res.substring(res.length()-finalPrecision,res.length());
		}
	   	if(res.matches("^0*\\..*")){
	   		res=0+res.replaceFirst("^0+", "");	
		}
	   	return  res;
		
		
		
		
	}
	
	
	
	
	
	/**
	 * 
	 * @param number1
	 * @param number2
	 * @return if  number1 &gt;  number2 return -1 <br/>
	 * else if  number1 &lt;  number2 return 1 <br/>
	 * else return 0 <br/>
	 */
	public static int compare(String number1,String number2){
		String num1=number1.replaceAll("^0", "");
		String num2=number2.replaceAll("^0", "");
		int[][] arr=equalizeNumbers(number1, number2);
		String str="";
		for(int i:arr[1]){
			str=str+i;
		}
		str=str.replaceAll("^0","");
		if(str.equals(num1)&&str.equals(num2)){
			return 0;
		}
		else if(str.equals(num1)){
			return -1;
		}
		else {
			return 1;
		}
	}
	
	public static <Type> List<Type> getList(List<Type> list,Type[] array){
		for(Type t:array){
			list.add(t);
		}
		
		return list;
	}

	
	/**
	 * 
	 * @param number1
	 * @param number2
	 * @return int[1] will have larger number,int[0] will have smaller number
	 */
	public static  Integer[][] equalizeNumber(String number1,String number2){
		int[] number1Array=convertStringToIntArray(number1);
	   	int[] number2Array=convertStringToIntArray(number2);
	    Integer[][] array= new Integer[2][];
	    
	   	int diff=(number1Array.length-number2Array.length);
	
	   	if(diff<0){
	   		Integer[] ar=new Integer[number2Array.length];
	   		for(int i=0;i<(-1*diff);i++){
	   			ar[i]=0;
	   		}
	   		for(int i=(-1*diff),k=0;i<ar.length;i++,k++){
	   	
	   			ar[i]=number1Array[k];
	   		}
	   		array[0]=ar;
	   		array[1]=new Integer[number2Array.length];
	   		for(int k=0;k<number2Array.length;k++){
	   			array[1][k]=number2Array[k];	
	   		}
	   		
	   	}
	   	else{
	   		Integer[] ar=new Integer[number1Array.length];
	   		for(Integer i=0;i<(diff);i++){
	   			ar[i]=0;
	   		}
	   		for(Integer i=(diff),k=0;i<ar.length;i++,k++){
	   			ar[i]=number2Array[k];
	   		}
	   		array[0]=ar;
	   		array[1]=new Integer[number1Array.length];
	   		for(int k=0;k<number1Array.length;k++){
	   			array[1][k]=number1Array[k];	
	   		}
	   	}
	   	return array;
		
	}
	/**
	 * 
	 * @param number1
	 * @param number2
	 * @return int[1] will have larger number,int[0] will have smaller number
	 */
	public static  int[][] equalizeNumbers(String number1,String number2){
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
	   	return array;
	}

	
	public static  String sub(String number1,String number2){
		Integer  number1Precision=null;
		Integer number2Precision=null;
		
		int finalPrecision=0;
		
		if(number1.contains("-")&&!number2.contains("-")){
			return "-"+add(number1.replaceAll("-", ""),number2.replaceAll("-", ""));
		}
		else if(number2.contains("-")){
			//sub(String number1,String number2);
		}
		
		if(number1.matches("\\d+\\.\\d+")){
			number1Precision=number1.replaceAll("^\\d+\\.", "").length();
			number1=number1.replaceAll("\\.", "");
		}
        if(number2.matches("\\d+\\.\\d+")){
        	number2Precision=number2.replaceAll("^\\d+\\.", "").length();
        	number2=number2.replaceAll("\\.", "");
         }
   

          if(number1Precision!=null&&number2Precision!=null){
        	  int diff=number1Precision-number2Precision;
        	  if(diff>0){
        		  finalPrecision=number1Precision;
        		  for(int i=0;i<diff;i++){
        			  number2=number2+"0";
        		  }
        	  }
        	  else{
        		  finalPrecision=number2Precision;
        		  for(int i=0;i<(-1*diff);i++){
        			  number1=number1+"0";
        		  }
        	  }
          }
          else if(number1Precision!=null){
        	
        		  finalPrecision=number1Precision;
        		  for(int i=0;i<finalPrecision;i++){
        			  number2=number2+"0";
        		  }
        	  
          }
          else if(number2Precision!=null){
        	  
        
        		  finalPrecision=number2Precision;
        		  for(int i=0;i<finalPrecision;i++){
        			  number1=number1+"0";
        		  }
        	  
          }
		
		
          System.out.println("str1=="+number1);
          System.out.println("str2=="+number2);
          number1=number1.replaceAll("^0*", "");
          number2=number2.replaceAll("^0*", "");
          int compare=Utils.compare(number1, number2);
		Integer[][] arr=Utils.equalizeNumber(number1, number2);
		if(compare==0){
			return "0";
		}
		/**
		 * if compare lesthan 1 number1 is greater
		 * if comare eq 0 number1=number2
		 * else number2 is greater
		 */

	List<Integer> smallNumberList=new ArrayList<Integer>();
	List<Integer> largeNumberList=new ArrayList<Integer>();
	List<Integer> outputList=new ArrayList<Integer>();
	Utils.getList(smallNumberList,arr[0]);
	Utils.getList(largeNumberList,arr[1]);

	int size=smallNumberList.size();

		for(int i=size-1;i>=0;i--){
			int diff=largeNumberList.get(i)-smallNumberList.get(i);
			if(diff<0){
				int index=i-1;
			//	System.out.println("k.."+i);
				for(int k=i;k>0;k--){
					
					if(largeNumberList.get(k)<largeNumberList.get(k-1)){
			//	System.out.println("break.."+(k-1));
						index=k-1;
						break;
					}
					else{
					
					}
					//largeNumberList.
				}
				
				//System.out.println(i+"diff");
				for(int k=i,elem=largeNumberList.get(k);k>index;k--,elem=largeNumberList.get(k)){
					if(k-1<0)break;
					
					int elem2=largeNumberList.get(k-1);
					//if(elem2<elem){
					//System.out.println(i+"elm"+largeNumberList.get(k));
						
						
						if(elem==0){
							largeNumberList.set(k, 10);
							
						}
						else if(elem==9){
							
						}
						else{
							largeNumberList.set(k, elem+10);	
						}
						if(elem2==0){
							largeNumberList.set(k-1, 9);
						}
						else{
							largeNumberList.set(k-1, elem2-1);
						}
					
						//System.out.println(index+"diff"+largeNumberList);
				}	
			}
		//System.out.println(largeNumberList.get(i)+"test"+smallNumberList.get(i));
			diff=largeNumberList.get(i)-smallNumberList.get(i);
		//	System.out.println(diff);
			outputList.add(diff);
		}
		Collections.reverse(outputList);
		String str="";
		for(int i:outputList){
			str=str+i;
		}
		System.err.println(str);
		str=str.replaceAll("^0", "");
		
		if(finalPrecision>0){
			str=str.substring(0,str.length()-finalPrecision)+"."+str.substring(str.length()-finalPrecision,str.length());
		}
		System.err.println("......."+str);
	   	if(str.matches("^0*\\..*")){
	   		
	   		str=0+str.replaceFirst("^0+", "");	
		}
		
         if(str.matches("^-0*\\..*")){
	   		
	   		str="-"+0+str.replaceFirst("^-?0*", "");	
		}
		
		if(compare>0){
			str="-"+str;
		}
		return str;
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
		Integer  number1Precision=null;
		Integer number2Precision=null;
		int finalPrecision=0;
		boolean isNum1Negative=false;
		boolean isNum2Negative=false;
        if(number1.matches(".*-.*")){
        	number1=number1.replaceAll("-", "");
        	isNum1Negative=true;	
        }
        if(number2.matches(".*-.*")){
        	number2=number2.replaceAll("-", "");
        	isNum2Negative=true;
        }
		if(number1.matches("\\d+\\.\\d+")){
			number1Precision=number1.replaceAll("^\\d+\\.", "").length();
			number1=number1.replaceAll("\\.", "").replaceAll("-", "");
		}
        if(number2.matches("\\d+\\.\\d+")){
        	number2Precision=number2.replaceAll("^\\d+\\.", "").length();
        	number2=number2.replaceAll("\\.", "").replaceAll("-", "");
         }
        
        if(number1Precision!=null){
        	finalPrecision=number1Precision;
        }
        if(number2Precision!=null){
        	finalPrecision=finalPrecision+number2Precision;
        }

        
        
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
		
		if(finalPrecision>0){
			endResult=endResult.substring(0,endResult.length()-finalPrecision)+"."+endResult.substring(endResult.length()-finalPrecision,endResult.length());
		}
		if(endResult.matches("^0*\\..*")){
			endResult=0+endResult.replaceFirst("^0+", "");	
		}
		else{
			endResult=endResult.replaceFirst("0*", "");
		}
		if(!((isNum1Negative&&isNum2Negative)||(!isNum1Negative&&!isNum2Negative))){
			endResult="-"+endResult;
		}
		
		return endResult;
		
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
	
	public static List<List<String>> getStringArrayDataFromFile(File file){
		List<List<String>> stringdata=new ArrayList<List<String>>();
		try{
			FileReader fr= new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
		
			String line="";
			for(int i=1;(line=br.readLine())!=null;i++){
				ArrayList<String> data=new ArrayList<String>();
				
				for(String spaceSplit:line.split(" ")){
					data.add(spaceSplit);
				}
				stringdata.add(data);
				
			}
			
			
		}
		catch(Exception e){
			
		}
		return stringdata;
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
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		//System.setOut(new PrintStream(new File("test")));
		System.out.println(new Date());
		
	//	System.out.println(power(2+"", 10));
		System.out.println(LargestPrimeNumberFactor.getSquareRootApproxiDouble(6));
		//search(21);
		
		System.out.println(new Date());
		
		
	}
	
	private static void  refinePaths(StackList<StackList<Node>> totalpaths,StackList<StackList<Node>> refinepaths){
	  	Iterator<StackList<Node>> totalPathsIterator=totalpaths.iterator();
	  	StackList<Node> previouspath=null;
	  	int length=0;
		for(;totalPathsIterator.hasNext();){
	    	StackList<Node> nodes=totalPathsIterator.next();
	    		if(length==0){
	    			length=nodes.size();
	    			refinepaths.push(nodes);
	    			previouspath=nodes;	    			
	    		}
	    		else if(length==nodes.size()){
	    			
	    			previouspath=nodes;
	    			refinepaths.push(nodes);
	    		}
	    		else{
	    			
	    			StackList<Node> path= new StackList<Utils.Node>();
	    			Iterator<Node> nodeIterator=nodes.iterator();
	    			Iterator<Node> previousPathsIterator=previouspath.iterator();
	    			Node findelement=null;
	    			for(;nodeIterator.hasNext();){
	    				findelement=nodeIterator.next();
	    				break;
	    			}
	    			for(;previousPathsIterator.hasNext();){

	    				Node node=previousPathsIterator.next();
	    				if(node.equals(findelement)){
	    					break;
	    				}
	    				else{
	    					 path.push(node);
	    				}
	    			}
	    			path.push(findelement);
	    			for(;nodeIterator.hasNext();){
	    				path.push(nodeIterator.next());
	    			}
	    			refinepaths.push(path);
	    		   	previouspath=path;
	    		}
	    	}
	}
	
	
    public static void search(int size){
    	Count count=new Count();
    	Count track=new Count();
    	ArrayGraph g= new ArrayGraph(size);
    //	search2(size,0,0,count,-1,-1,g,new ArrayList<List<Node>>(),new ArrayList<Utils.Node>());
    	StackList<StackList<Node>> totalpaths=new StackList<StackList<Node>>();
    	//search3(size,0,0,count,-1,-1,g,totalpaths,new StackList<Utils.Node>(),track);
    	//search5(size,0,0,count,-1,-1,g,totalpaths,new StackList<Utils.Node>(),track);
    	//search4(size,0,0,count,-1,-1,g,totalpaths,new StackList<Utils.Node>(),track);
    	
    	System.out.println("search6 "+search6(new SearchParameterForRecursion(size,0,0,count,-1,-1,g,totalpaths,new StackList<Utils.Node>(),track),"",new HashMap<Utils.SearchParameterForRecursion, Long>()));
    	//System.out.println("total paths=="+count.i);
    	
    	/*StackList<StackList<Node>> refinepaths=new StackList<StackList<Node>>();
    	System.out.println("refining..");
    	refinePaths(totalpaths, refinepaths);
    	Iterator<StackList<Node>> refinepathsIterator=refinepaths.iterator();
    	
    	for(;refinepathsIterator.hasNext();){
    		refinepathsIterator.next().display();
    		System.out.println();
    	}
    	
    	System.out.println(count.i);*/
    	
    	
    	
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
    	public boolean equals(Object o) {
    	
    	
    		if(o instanceof Node){
    			Node node=(Node) o;
    			if(node.row==this.row&&node.column==this.column){
    				return true;
    			}
    		}
    		return super.equals(o);
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
	
	
	 
	public static class SearchParameterForRecursion{
		
		public static  Integer size=20;
		Integer row;
		Integer column;
		Integer rPrev;
	    Integer cPrev;
	    long noOfPaths;
	    @Override
	    public boolean equals(Object o) {
	    	if(o instanceof SearchParameterForRecursion){
	    		SearchParameterForRecursion param=(SearchParameterForRecursion) o;
	    		if(this.row.equals(param.row)&&this.column.equals(param.column)){
	    			return true;
	    		}
	    		else{
	    			return false;
	    		}
	    	}
	    	return super.equals(o);
	    }
	    @Override
	    public int hashCode() {
	    	// TODO Auto-generated method stub
	    	return this.toString().hashCode();
	    }
	    
	    @Override
	    public String toString() {
	    	// TODO Auto-generated method stub
	    	return "("+row+","+column+")";
	    }
	    public static Count count;
	    public static ArrayGraph g;
	    public static StackList<StackList<Node>> pathList;
	    public static StackList<Node> path;
	    public static Count track;
	    public SearchParameterForRecursion(int size,int row,int column,Count count,int rPrev,int cPrev,ArrayGraph g,StackList<StackList<Node>> pathList,StackList<Node> path,Count track) {

	    	SearchParameterForRecursion.size=size-1;
	    	SearchParameterForRecursion.track=track;
	    	SearchParameterForRecursion.g=g;
	    	SearchParameterForRecursion.count=count;
	    	SearchParameterForRecursion.pathList=pathList;
	    	SearchParameterForRecursion.path=path;
	    	SearchParameterForRecursion.track=track;
	    	this.row=row;
	    	this.column=column;
	    	this.rPrev=rPrev;
	    	this.cPrev=cPrev;
		}
	    public SearchParameterForRecursion(int row,int column,int rPrev,int cPrev) {
			this.row=row;
			this.column=column;
			this.rPrev=rPrev;
			this.cPrev=cPrev;
		}
	}
	
	
	/***
	 * search solution to use stacks instead of recursion 
	 * @param size
	 * @param row
	 * @param column
	 * @param count
	 * @param rPrev
	 * @param cPrev
	 * @param g
	 * @param pathList
	 * @param path
	 * @param track
	 */
	public static  void search5(int size,int row,int column,Count count,int rPrev,int cPrev,ArrayGraph g,StackList<StackList<Node>> pathList,StackList<Node> path,Count track){
		
	
		
		
		StackList<SearchParameterForRecursion> callList=new StackList<Utils.SearchParameterForRecursion>();
		callList.push(new SearchParameterForRecursion(size, row, column, count, rPrev, cPrev, g, pathList, path, track));
		
		
		while(!callList.isEmpty()){
			System.out.println("callist...");
			SearchParameterForRecursion call=callList.pop();
			System.out.println("row,col=("+call.row+","+call.column+")====rprev,cprev("+call.rPrev+","+call.cPrev+")");
			if(call.row==size-1&&call.column==size-1){
				System.out.println("reached..");
				call.count.i=call.count.i+1;
				
				call.path.push(call.g.getNode(row, column));
				call.pathList.push(call.path.clone());
				if(call.track.i==0){
					call.track.i=call.path.size();	
				}
				else if(call.track.i<0){
					call.track.i++;
				}
				call.path.empty();
				callList.pop();
			}
			else{
				if(call.row>=0 && call.row<= size-1&&(call.column+1<=size-1&&call.column+1>=0&&(call.row!=call.rPrev||call.column+1!=cPrev))){
					System.out.println("right"+call.g.getNode(call.row, call.column));
					call.path.push(call.g.getNode(call.row, call.column)); 
					callList.push(new SearchParameterForRecursion(size, call.row, call.column+1, call.count,call.row,call.column,call.g,call.pathList,call.path,call.track));
			         
				}
				if(call.column>=0 && call.column<= size-1&&(call.row+1<=size-1&&call.row+1>=0&&(call.column!=call.cPrev||call.row+1!=call.rPrev))){
					System.out.println("down"+call.g.getNode(call.row, call.column));
					call.path.push(call.g.getNode(call.row, call.column));
					callList.push(new SearchParameterForRecursion(size, call.row+1, call.column, call.count,call.row,call.column,call.g,call.pathList,call.path,call.track));
				}
				
			}
		}
	
	}
	
	
	
	
	
	/**
	 * improving search 3
	 * @param size
	 * @param row
	 * @param column
	 * @param count
	 * @param rPrev
	 * @param cPrev
	 * @param g
	 * @param pathlist
	 * @param path
	 */
    public static  void search3(int size,int row,int column,Count count,int rPrev,int cPrev,ArrayGraph g,StackList<StackList<Node>> pathList,StackList<Node> path,Count track){
		if(row==size-1&&column==size-1){
			count.i=count.i+1;
			
			path.push(g.getNode(row, column));
			pathList.push(path.clone());
			if(track.i==0){
				track.i=path.size();	
			}
			else if(track.i<0){
				track.i++;
			}
			path.empty();
			return;
		}

		
		
		
	
		
		
		if(row>=0 && row<= size-1&&(column+1<=size-1&&column+1>=0&&(row!=rPrev||column+1!=cPrev))){
			path.push(g.getNode(row, column)); 
			
			
			
			Iterator<StackList<Node>> pathsIterator=pathList.iterator();
			
			boolean pathFound=false;
			
			
			if(test){
			if(track.i>0){
				for(;pathsIterator.hasNext();){
					StackList<Node> localPath=pathsIterator.next();
					
					
					if(localPath.size()!=track.i){
						
						if(localPath.getFirst().equals(path.getFirst())){
							
							if(!localPath.beginswith(path)){
								continue;
							}
							pathList.push(localPath);
							count.i=count.i+1;
							pathFound=true;
							break;
						}
						
					}
					
				}	
					
					
				}
			else {
				search3(size, row, column+1, count,row,column,g,pathList,path,track);	
				
			}
			
			
			}
			
			if(!pathFound){
				search3(size, row, column+1, count,row,column,g,pathList,path,track);	
			}
			
			
		}
		if(column>=0 && column<= size-1&&(row+1<=size-1&&row+1>=0&&(column!=cPrev||row+1!=rPrev))){
			path.push(g.getNode(row, column));
			Iterator<StackList<Node>> pathsIterator=pathList.iterator();
			boolean pathFound=false;
			
			if(test){
			if(track.i>0){
				for(;pathsIterator.hasNext();){
					StackList<Node> localPath=pathsIterator.next();
					
					
					if(localPath.size()!=track.i){
						
						if(localPath.getFirst().equals(path.getFirst())){
							
							if(!localPath.beginswith(path)){
								continue;
							}
							pathList.push(localPath);
							count.i=count.i+1;
							pathFound=true;
							break;
						}
						
					}
					
				}	
					
					
				}
			else {
				
				search3(size, row+1, column, count,row,column,g,pathList,path,track);
			}
			
			}
			
			
			if(!pathFound){
				search3(size, row+1, column, count,row,column,g,pathList,path,track);	
			}
				
				
		}
	
	};
	
	
	
	
	
	
	
	
	/**
	 * optimized solution for lattice paths
	 * @param size
	 * @param row
	 * @param column
	 * @param count
	 * @param rPrev
	 * @param cPrev
	 * @param g
	 * @param pathlist
	 * @param path
	 */
    public static  Long search6(SearchParameterForRecursion call,String path,Map<SearchParameterForRecursion,Long> map){
    	
    	if(map.containsKey(call)){
    		return map.get(call);
    	}
		if(call.row==SearchParameterForRecursion.size&&call.column==SearchParameterForRecursion.size){
			SearchParameterForRecursion.count.i=SearchParameterForRecursion.count.i+1;
    		return call.noOfPaths;
		}
		long right=0;
		if((call.column+1<=SearchParameterForRecursion.size&&call.column+1>=0)){
			right=right+search6(new SearchParameterForRecursion(call.row, call.column+1,call.row,call.column),path,map);	
            if(right==0){
            	right=1;
            }		
		}
		 long down=0;
		if((call.row+1<=SearchParameterForRecursion.size&&call.row+1>=0)){
		   
			down=down+search6(new SearchParameterForRecursion(call.row+1, call.column,call.row,call.column),path,map);		
		    if(down==0){
		    	down=1;
		    }
		}
		long totalCount=right+down;
		map.put(call,totalCount);
		call=null;
		return totalCount;
	   
	};

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	private static void reCreatePaths(StackList<StackList<Node>> pathList,Node node,Count count,int size){
System.out.println("reacreate paths..");
		Iterator<StackList<Node>> peter=pathList.iterator();
		for(int i=0;peter.hasNext()&&i<size;i++){
			StackList<Node> temp=peter.next();
			System.out.println("comparing temp.."+temp);
			if(temp.getFirst().equals(node)){
				System.out.println("first hit..");
				count.i=count.i+1;
				pathList.push(temp);
				Iterator<Node> tempIter=temp.iterator();
				for(int k=0;tempIter.hasNext();k++){
					if(k>0){
						reCreatePaths(pathList, tempIter.next(), count, size);
					}
					else{
						tempIter.next();
					}
				}
				return;
			}
			
		}
	}
	
	
	
	
	
	
	/**
	 * implementation is not  yet finished
	 * @param size
	 * @param row
	 * @param column
	 * @param count
	 * @param rPrev
	 * @param cPrev
	 * @param g
	 * @param pathList
	 * @param path
	 * @param track
	 */
	 public static  void search4(int size,int row,int column,Count count,int rPrev,int cPrev,ArrayGraph g,StackList<StackList<Node>> pathList,StackList<Node> path,Count track){
			if(row==size-1&&column==size-1){
				count.i=count.i+1;
				
				path.push(g.getNode(row, column));
				pathList.push(path.clone());
				path.display();
				System.out.println();			
				path.empty();
				return;
			}

			
			
			/***
			 * find  a way to store paths traversed---done
			 * find a way to reutilise paths which are already traversed --?
			 * append already traversed path with path which we are about to traverse
			 * 
			 */
			
			
			
		
			
			
			if(row>=0 && row<= size-1&&(column+1<=size-1&&column+1>=0&&(row!=rPrev||column+1!=cPrev))){
				    boolean pathFound=false;
				    /*if(path.isEmpty()){*/
				    	Node node=g.getNode(row, column);
				    	Long c=count.i;
				    	reCreatePaths(pathList, node,count,pathList.size());
				    	if(c<count.i){
				    		System.out.println("path  found..");
				    		pathFound=true;
				    	}
				    /*}*/
				    if(!pathFound){
				    	path.push(g.getNode(row, column)); 
						search4(size, row, column+1, count,row,column,g,pathList,path,track);
				    }
				    	
				
				
				
			}
			if(column>=0 && column<= size-1&&(row+1<=size-1&&row+1>=0&&(column!=cPrev||row+1!=rPrev))){
				   boolean pathFound=false;
			
				Node node=g.getNode(row, column);
		    	Long c=count.i;
		    	reCreatePaths(pathList, node,count,pathList.size());
		    	if(c<count.i){
		    		System.out.println("path  found..");
		    		pathFound=true; 
		    	}
				
				if(!pathFound){
					path.push(g.getNode(row, column));
					search4(size, row+1, column, count,row,column,g,pathList,path,track);	
			
				}
				
					
					
			}
		
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
