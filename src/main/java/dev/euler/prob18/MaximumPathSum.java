package dev.euler.prob18;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import dev.Utils;
import edu.naren.StackList;
import edu.naren.StackListSet;

public class MaximumPathSum {

	
	public static void main(String[] args) {
		
	}
	
	public static void main2(String[] args) {

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
	
private static void getMaximumPath2(List<List<Integer>> data,int depth,int maxFlow,int parent,int child,StackList<Integer> path,StackList<Integer> maxpath){
	
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
		

public static 	int[][] convertToIntArray(int len){
	List<List<String>> arrayList=Utils.getStringArrayDataFromFile(new File("data.txt"));
	int[][] data=new int[len][];
	for(int t=0;t<arrayList.size();t++){
		List<String> list=arrayList.get(t);
		int[] dataa=new int[len];
		data[t]=dataa;
		for(int i=0,k=0;i<list.size();i++){
			if(!list.get(i).trim().equals("")){
				dataa[k]=new Integer(list.get(i).trim());
				k++;
			}
		}
	}
	return data;
}

public static StackList<Integer> prevPath=new StackListSet<Integer>();
public static HashMap<HashSet<Integer>, HashMap<Integer,HashMap<Integer,Integer>>> dymamicPathSum= new HashMap<HashSet<Integer>,HashMap<Integer,HashMap<Integer,Integer>>>();
public static int[][] data= convertToIntArray(15);

public static void maxPathMatrix(){
System.out.println("conversion");

System.out.println("conv..");
System.out.println("start====="+new Date());
System.out.println(maxSumPath(-1, -1/*,""*/));
System.out.println("end====="+new Date());


}


public static int maxSumPath(int row,int column/*,String path*/){
	if(column>data.length-1){
	//	System.out.println(path);
		return 0;
	}
	
	else if(row==-1&&column==-1){
		int max=0;
		
		for(int irow=0;irow<data.length;irow++){
		   prevPath.push(irow);
		//   System.err.println("path=-="+prevPath.size());
			int submax=data[irow][column+1]+maxSumPath(irow, column+2/*,path+"("+irow+"-"+(column+1)+")"*/);
			//System.out.println("submax"+submax);
		    if(submax>max){
		    	max=submax;
		    }
		    prevPath.pop();
		}
		return max;
	}
	else{
		int max=0;
		HashSet<Integer> setHashSet=new HashSet<Integer>();
        for(HashSet<Integer> set:dymamicPathSum.keySet()){
       	 if(prevPath.equals(set)){
       	//	System.err.println("path1 "+prevPath +" --- "+set);
       		 setHashSet=set;
      		 break;
          }
        }
        
        if(setHashSet.size()==0){
   		 for(Iterator<Integer> itr=prevPath.iterator();itr.hasNext();){
   		 setHashSet.add(itr.next());
   		 }
   		 dymamicPathSum.put(setHashSet, new HashMap<Integer, HashMap<Integer,Integer>>());
   	     }
		for(int irow=0;irow<data.length;irow++){             
             if(setHashSet.size()>0&&dymamicPathSum.get(setHashSet).get(irow)!=null&&dymamicPathSum.get(setHashSet).get(irow).get(column)!=null){
            	 int submax=dymamicPathSum.get(setHashSet).get(irow).get(column);
            	System.err.println(setHashSet+" found sum in table "+irow+"-"+column+" == "+submax);
            	 if(submax>max){
            		 max=submax;
            	 }
             }
             else{
            	 
			if(!prevPath.contains(irow)){
				
				//System.out.println("row=="+irow);
				if(dymamicPathSum.get(setHashSet).get(irow)==null){
					dymamicPathSum.get(setHashSet).put(irow, new HashMap<Integer, Integer>());
				}
				prevPath.push(irow);
				/*String tempPath=path+"("+irow+"-"+(column)+")";*/
				//System.err.println(tempPath);
				int submax=data[irow][column]+maxSumPath(irow,column+1/*,tempPath*/);
				dymamicPathSum.get(setHashSet).get(irow).put(column, submax);
				if(submax>max){
			    	max=submax;
			    }
				 prevPath.pop();
			}
			}
			
		}
		return max;
	}
	

}


static{
	System.out.println("=========static 1= problem 345========");	

	maxPathMatrix();
	System.out.println("=========static 1 ends=========");
}	






	
	

}



