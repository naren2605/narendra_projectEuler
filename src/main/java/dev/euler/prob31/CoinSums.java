package dev.euler.prob31;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dev.Utils;
import dev.euler.prob3.LargestPrimeNumberFactor;

public class CoinSums {
	
	public static Integer[] arr= new Integer[]{
    	1,2,3,4,5/*,2,5,10,20,50,100,200*/
    };
	public static List<Integer> denominations=Utils.getList(new ArrayList<Integer>(),arr);

	public static int size=arr.length;
	public static int ammount=6;

	
	static int target = 100;
	 public static int[][] dyarray=new int[target+1][target+1];  
	public static void main(String[] args) {
     

    Date date= new Date();
    
    System.out.println(LargestPrimeNumberFactor.getSquareRootApproxiDouble(10));
 //   System.out.println(Utils.factorial(5));
    System.out.println(new Date());
  System.out.println(combinationsOfDenominations1(0,"",0));
   // System.out.println(permutationsOfDenominations1(0,""));
 System.out.println(new Date());
		
 //System.out.println(split(target, target, ""));
		
 split(target,target,"");
		System.out.println(dyarray[target][target]);

	}
	
	
/**
 * problem 76 resolved 	
 * @param n
 * @param max
 * @param path
 * @return
 */
	public static int split(int n,int max,String path){
		//System.out.println("n="+n+" max="+max);
		int count=0;
		if(n==1){
			//System.out.println(path +" "+1);
			dyarray[n][max]=1;
			return 1;
		}
		if(n<=0||max<0){
			
			return 0;
		}

		
		if(n<=max){
			//System.out.println("n="+n+" max="+max);
			if(n!=target&&n<=max){
				
				count++;
			}
			for(int k=n-1;k>=1;k--){
				
				if((n-k)==k){
					path=path+" "+k;
					if(dyarray[n-k][k]>0){
						count=count+dyarray[n-k][k];
					}
					else{
						count=count+split(n-k,k,path);	
					}
				
					path="";
				}
				else{
					path=path+" "+k;
					if(dyarray[n-k][k]>0){
						count=count+dyarray[n-k][k];	
					}
					else{
						count=count+split(n-k,k,path);	
					}
					path="";
				}
				
			}	
		}
		else{		
			String p=path;
			if(dyarray[n-max][max]>0){
				count=count+dyarray[n-max][max];
			}
			else{
				count=count+split(n-max,max,max+" "+p);	
			}
			for(int k=max-1;k>=1;k--){
				path=path+" "+k;	
				if(dyarray[n-k][k]>0){
					count=count+dyarray[n-k][k];
				}
				else{
					count=count+split(n-k,k,path);	
				}
				
				path="";
		
			}
		}
		dyarray[n][max]=count;
		return count;
		
	}
	
	
    public static long permutationsOfDenominations1(long total,String str){
    //	System.out.println(count);
    /*	if(count>size){
    		return 0;
    	}*/
    	if(total==ammount){
    	//	System.out.println("total..");
    		System.out.println(str);
    		return 1;
    	}
    	else if(total>ammount){
    		return 0;
    	}
    	
    	long localtotal=0;
    	for(int i=0;i<size;i++){
    		long localp=localtotal;
    		localtotal=localtotal+permutationsOfDenominations1(total+denominations.get(i),str+" "+denominations.get(i));
    		if(localtotal==localp){
    			break;
    		}
    	}
    	
    	return localtotal;
    }
    
    public static long combinationsOfDenominations1(long total,String str,int i){
       // System.out.println(str);
    	//	System.out.println(count);
        /*	if(count>size){
        		return 0;
        	}*/
        	if(total==ammount){
        	//	System.out.println("total..");
        		System.out.println(str);
        		return 1;
        	}
        	else if(total>ammount){
        		return 0;
        	}
        	if(i==size){
        		return 0;
        	}
        	
        	long localtotal=0;
        	
        		
        		for(Integer k=0;k<=ammount/arr[i];k++){
        			
        			localtotal=localtotal+combinationsOfDenominations1(total+arr[i]*k,str+" "+denominations.get(i)+"*"+k+" ",(i+1));
        		
        	
        		}
        		
        	
        	
        	return localtotal;
        }

    
}
