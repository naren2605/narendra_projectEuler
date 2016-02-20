package dev.euler.prob26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import dev.Utils;

public class ReciprocalCycleDetector {
	public static final List<Long> performance=new ArrayList<Long>();
public static void main(String[] args) {
	String less="5676567853627546374654637465364637567854554378239463783478943789347382947834783465738265724819486547821936738213657821936547281563478213567285678256732864732864286758264367874345672873687543457765";
	String more="67845678569468543678764345676434567543345754323467654323454567";

	
/*	String more="1000000000000000000000000000000000000";
	String less="1";*/
System.out.println(divide("5000000", "2"));
System.out.println(performance.size());
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
	
	if(compare>0){
		str="-"+str;
	}
	return str;
}


}
