package dev;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * this algorithm is a brute force permutation
 * but has a time impact, took almost a day to generate
 * 40320 permutations
 * perfomance:horrible :(
 * @author narendra kumar
 *
 */
public class RandomStringPermutiationAlgorithm {

	public static void main(String[] args) {

		Random pickRandomIndex=new Random();
		LinkedHashSet indexSet=new LinkedHashSet<Integer>();


		
		String sourceString="narendra";
		char[] sourcearray=sourceString.toCharArray();
		int sourceStringLength=sourceString.length();
		//System.out.println(factorial(sourceStringLength));
		int possibleStrings=0;
		int countSeedChange=0;
		List<LinkedHashSet<Integer>> indexList=new ArrayList<LinkedHashSet<Integer>>();
		while(Utils.factorial(sourceStringLength)!=possibleStrings){
	int iterations=0;		
		while(true){
			if(possibleStrings>0){
				//System.out.println(possibleStrings);
			}
			if(Utils.factorial(sourceStringLength)==possibleStrings){
				break;
			}
			//System.out.println("count:"+possibleStrings);
			if(indexSet.size()==sourceStringLength){
				iterations++;
				//System.out.println("prepared set:"+indexSet.toString());
				//System.out.println("prepared list:"+indexList.toString());
				if(possibleStrings>0){
					//System.out.println(possibleStrings);
				}
		        int beforSize=indexList.size();
		        boolean suspect=false;
		        boolean isForloop=false;
		        //System.out.println("iteration:"+iterations);
				 for(int i=0;i<beforSize;i++){
					 isForloop=true;
				    	if(indexList.get(i).toString().equals(indexSet.toString())){
				    		suspect=true;
				    		break;
				    	}
				    	
				  }
				 if(!suspect&&isForloop){
					 
					 indexList.add(indexSet);
					 System.out.println("improving...has increased from "+beforSize+" to" +indexList.size());
					 possibleStrings++;
					 break;
				 }
				 if(indexList.size()==0){
					 break;
				 }
				 else if(beforSize<indexList.size()){
					 break;
				 }
				 
			}
		
			if(iterations>3){
				indexSet=new LinkedHashSet<Integer>();
				//System.err.println("changing seed.."+countSeedChange++);
				pickRandomIndex.setSeed(pickRandomIndex.nextLong());
				iterations=0;
			}
			
			int nextindex=pickRandomIndex.nextInt();
			if(nextindex<0){
				nextindex=nextindex*-1;
				nextindex=nextindex % sourceStringLength;
			}
			else{
				nextindex=nextindex % sourceStringLength;
			}
		//	indexSet.add(pickRandomIndex.nextInt(sourceStringLength));
			indexSet.add(nextindex);	
			

		};
		
		//System.out.println();
		//System.out.println(indexSet);
	   
	   
	    if(indexList.size()==0){
	    	
	    	indexList.add(indexSet);
	    	possibleStrings++;
	    }
	    
		indexSet=new LinkedHashSet<Integer>();
		//System.out.println("list2:"+indexList.toString());
		}
		
		System.out.println(indexList.size());
	File file= new File("randomStringGenerator2_narendra");
	FileWriter fos=null;
		try {
			fos = new FileWriter(file, true);
		
		
		for(LinkedHashSet<Integer> set:indexList){
			String test="";
			for(Integer i:set){
				test=test+sourcearray[i];
				
			}
			fos.write(test+"\n");
		}
		fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*for(int i=1;i<30;i++){
	System.out.println(pickRandomIndex.nextInt(3));
}*/	
	}
	
	
}
