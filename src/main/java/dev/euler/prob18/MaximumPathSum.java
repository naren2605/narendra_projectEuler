package dev.euler.prob18;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dev.Utils;
import edu.naren.StackList;

public class MaximumPathSum {

	
	
	
	public static void main(String[] args) {

		List<List<Integer>> data=getNumericData();
		StackList<Integer> path=new StackList<Integer>();
		
		
		
		
		
		StackList<Integer> mxpath=new StackList<Integer>();
	getMaximumPath(data, 0, 0, data.get(0).get(0),0, path,mxpath);;
	mxpath.display();
	Iterator<Integer> mxpathIterator=mxpath.iterator();
	int maxpathSum=0;
	for(;mxpathIterator.hasNext();){
		maxpathSum=maxpathSum+mxpathIterator.next();
				
	}
	System.out.println();
	System.out.println(maxpathSum);
	}

	
private static	List<List<Integer>>  getNumericData(){
	List<List<String>> data=Utils.getStringArrayDataFromFile(new File("problem18Data"));

	List<List<Integer>> integerData= new ArrayList<List<Integer>>();
	
	for(List<String> l:data){
		List<Integer> list= new ArrayList<Integer>();
		for(String str:l){
			list.add(new Integer(str));
		}
		integerData.add(list);
	}
	
		return integerData;
	}
	


private static void getMaximumPath(List<List<Integer>> data,int depth,int maxFlow,int parent,int child,StackList<Integer> path,StackList<Integer> maxpath){
	
	if(depth==data.size()-1){
		path.push(parent);
/*	path.display();
		System.out.println("============");
		System.out.println(parent);*/
		int i=0;
		Iterator<Integer> itr=path.iterator();
		for(;itr.hasNext();){
			i=i+itr.next();
		}
		
		Iterator<Integer> maxpathitr=maxpath.iterator();
		maxFlow=0;
		for(;maxpathitr.hasNext();){
			maxFlow=maxFlow+maxpathitr.next();
		}

		if(i>maxFlow){
			System.out.println("mx"+maxFlow+" i="+i);
			maxFlow=i;
			Iterator<Integer> itr2=path.iterator();
			maxpath.empty();
			for(;itr2.hasNext();){
				maxpath.push(itr2.next());
			}
			
		}
		
	}
	else{
		/*path.push(parent);*/
		path.push(parent);
		/*System.out.println(parent+"depth==="+depth);*/
			getMaximumPath(data, depth+1, maxFlow, data.get(depth+1).get(child),child, path,maxpath);
			path.pop();
		/*System.out.println(parent+"depth==="+depth);*/
			getMaximumPath(data, depth+1, maxFlow, data.get(depth+1).get(child+1),child+1, path,maxpath);
			path.pop();		
			
			
				
			}
			
		}
		
		
	
	

}



