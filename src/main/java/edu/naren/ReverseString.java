package edu.naren;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String data="0123456789";
		StackList<String> permStack= new StackList<String>();
		System.out.println(new Date());
      permute(data, "", 0, data.length(),permStack);
      System.out.println(new Date());
     Iterator<String> allpermutations=permStack.iterator();
System.out.println(permStack.size());

String millonthPosibility="";
for(int i=1;allpermutations.hasNext();i++){

	
	
	
	if(i==1000000){
		millonthPosibility=allpermutations.next();
	}
	else{
		allpermutations.next();
	}
}

System.out.println(millonthPosibility);

	}

	
	
	public static String reverseStringRecursive(String str){
		if(str.length()==1){
			return str;
		}
		else{
			return reverseStringRecursive(str.substring(1, str.length()))+str.substring(0,1);
		}
		
	}
	
	public static String getCharInString(String str,int position){
	return str.substring(position, position+1);
	}
	public static String appendCharInFirstPosition(String str,int position){

		return str.substring(position, position+1)+str.substring(0,position)+str.substring(position+1,str.length());
		}
	
	public static void  permute(String data,String perm,int start,int size,StackList<String> permStack){
		if(start==size){
			
	       permStack.push(perm);
			return;
		}
		
		else{

		/*	if(map.get(data)!=null){
				map.get(data).add(perm);
			}
			else{
				map.put(data, new ArrayList<String>());
				map.get(data).add(perm);
			}
			*/
			for(int i=start;i<size;i++){
				permute(appendCharInFirstPosition(data, i), perm+getCharInString(data, i), start+1, size,permStack);				
			}
			
		}
	}
	
}
