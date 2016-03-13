package dev.euler.prob26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import dev.Utils;

public class ReciprocalCycleDetector {
	public static final List<Long> performance=new ArrayList<Long>();
public static void main(String[] args) {
	
	
  int max=0;
  System.out.println(new Date());
	for(int i=2;i<=1000;i++){
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		String q=div(i,list, true, "");
		//System.out.println(1+"/"+i+" === 0."+q);
		if(q.matches(".*\\(.+\\).*")){
			int len=q.replaceFirst(".*\\(", "").replaceFirst("\\).*", "").length();
			//System.out.println(i+"=="+len);
			if(len>max){
				max=i;
			}
			
		}
	}
	System.out.println("max=="+max);
	 System.out.println(new Date());	
	//System.out.println(max);
	
}

private static String div(Integer Y,List<Integer> list,boolean isFirst,String Q){
	int length=list.size();
	for(int index=length-2;index>=0;index--){
	     if(list.get(index).equals(list.get(length-1))){
	    	 //System.out.println("repetetion detected");
	    	 String Q1="";
	    	 int lastItem=list.get(length-1);
	    		while(lastItem<Y){
	    			if(isFirst){
	    				isFirst=false;
	    				lastItem=lastItem*10;
	    			}
	    			else{
	    				lastItem=lastItem*10;
	    				Q1=Q1+"0";
	    			}
	    		}
	    		Q1=Q1+(lastItem/Y);
	    		
	    		Q=Q.replaceFirst(Q1, "("+Q1);
                Q=Q+")";
	    	 
	    	 return Q;
	     }
	}
	int lastItem=list.get(length-1);
	while(lastItem<Y){
		if(isFirst){
			isFirst=false;
			lastItem=lastItem*10;
		}
		else{
			lastItem=lastItem*10;
			Q=Q+"0";
		}
	}
	Q=Q+(lastItem/Y);
	int partialReminder=lastItem-((lastItem/Y)*Y);
	if(partialReminder==0){
		return Q;
	}
	else{
		list.add(partialReminder);
		return div(Y, list, true, Q);
	}
}




public static String reciprocals(int ten,int number,String precision){
	if(ten%number==0){
		
		precision=(ten/number)+"";
	    return precision;
	}
	else{
		
		precision=reciprocals(10*ten,number,precision);
		
	}
	return  precision;
}






/**
 * fast approach with long division is required for solving reciprocal cycle detection
 * choosing fast division algorithm
 * giving a try with newton-raphson's fast division.
 * 
 * f(x)=xD-1
 * x
 */




private static String nextXEstimate(String x){
	
	return null;
}







/**
 * 
 * @param ten
 * @param number
 * @param temp
 * @param precision
 * @return
 */


public static String reciprocals2(long ten,long number,long temp,String precision){

	
	if(ten%number==0&&temp!=0){
	    return precision+temp;
	}
	
	else{
		String str=""+temp;
		
	//System.out.println("precision : "+precision);
		if(precision.contains(str)&&(!str.equals("0"))){
			precision=precision.replaceAll(str, "("+str);
		    precision=precision+")";
		}
		else{
			if(temp!=-1){
				precision=precision+temp;
			}
			else{
				ten=10;
			}
			long test=(ten/number)%10;
			long testR=ten-((ten/number)*number);
			if(testR>0){
				if(number!=test){
					ten=ten*10;
					System.out.println("incrementing tne.."+test);
					test=test*10+testR*10/number;
					if(test==0){
						precision="0"+precision;
					}
				}
				
				
				//test=ten-((ten/number)*number);
				
		 
			}
			  System.out.println("temp : "+temp+" ten : "+ten*10+" precision : "+precision+" next temp:("+ten+"/"+number+")"+(ten/number)%10+" number: "+test);
			precision=reciprocals2(10*ten,number,test,precision);	
		}
		
		
	}
	return  precision;
}















/**
 * dividend <code>></code>  divisor
 * @return
 * return quotient
 */
public static String  divide(String dividend,String divisor){
	String diff=dividend;
	int i=0;
	String str="0";
	boolean exceed=false;
	Date date1=new Date();
	while(Utils.compare((diff=sub(diff,divisor)), divisor)<=0){
		performance.add(new Date().getTime()-date1.getTime());
	  i++;
	  if(i<0){
		  exceed=true;
		  
		  str=Utils.add(str, i+"");
		  i=0;
	  }
date1=new Date();
	}
	if(!exceed){
		str=i+"";
	}
	else{
		if(i>0){
			str=Utils.add(str, i+"");
		}
	}
	//System.err.println(i);
	return str;
}

public static  String sub(String number1,String number2){
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
	str=str.replaceAll("^0", "");
	if(finalPrecision>0){
		str=str.substring(0,str.length()-finalPrecision)+"."+str.substring(str.length()-finalPrecision,str.length());
	}
   	if(str.matches("^0*\\..*")){
   		str=0+str.replaceFirst("^0+", "");	
	}
	if(compare>0){
		str="-"+str;
	}
	
	return str;
}


}
