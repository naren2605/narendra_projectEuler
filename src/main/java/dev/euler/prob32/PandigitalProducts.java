package dev.euler.prob32;

import java.util.HashSet;
import java.util.Set;

import dev.Utils;

public class PandigitalProducts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
	  System.out.println( pandigitNumberSplitWay(9));

	}

	
	public static long pandigitNumberSplitWay(int size){
		long total=0;
		for(int i=1;i<=size;i++){
			int k=size-i;
			for(int mr=1;mr<k-1;mr++){
				
				if(i+mr>=k-mr&&((i+mr==k-mr)||(i+mr-1==k-mr))){
					if(i>mr){
						break;
					}
					
					System.out.println(i+","+mr+","+(k-mr)+"==="+Utils.power(10, i-1)+","+Utils.power(10, mr-1));
					total=total+product( Utils.power(10, i-1), Utils.power(10, mr-1), size-i-mr,Utils.power(10, i), Utils.power(10, mr));
					
					
				}
			}
			
		}
		return total;
	}
	
	
	public static boolean  isPandigital(long md,long mr,long p){
		int length=(md+""+mr+""+p).length();
		Set<Long> set= new HashSet<Long>();
	     while(md!=0){
	    	 if(md%10==0){
	    		 return false;
	    	 }
	    	 set.add(md%10);
	    	 md=md/10;
	     }
	     while(mr!=0){
	    	 if(mr%10==0){
	    		 return false;
	    	 }
	    	 set.add(mr%10);
	    	 mr=mr/10;
	     }
	     while(p!=0){
	    	 if(p%10==0){
	    		 return false;
	    	 }
	    	 set.add(p%10);
	    	 p=p/10;
	     }
		if(length==set.size()&&length==9){
			return true;
		}
		return false;
	}
	
	public static long product(long md,long mr,int pSize,long mdLimit,long mrLimit){

		/**************************************
		 * multiplicand * multiplier = product
		 **************************************
		 *
		 *
		 */
		if((md+""+mr+""+(md*mr)).length()>9){
			
			
			
			return 0L;
		}
		
		
		Set<Long> set= new HashSet<Long>();
		for(long j=md;j<mdLimit;j++){
			for(long k=mr;k<mrLimit;k++){
				
				if((j*k+"").length()==pSize&&isPandigital(j, k, j*k)){
					System.out.println(j+","+k+","+(j*k)+"**");
				set.add(j*k);
				}
				/*else{
					System.out.println(j+","+k+","+(j*k));
				}*/
				
			}
			
		}
		long total=0;
		for(long i:set){
			total=total+i;
		}
		System.out.println("total====="+total);
		/*if(){
			
		}*/
		
		return total;
	}
}
