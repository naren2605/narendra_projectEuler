package edu.naren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*	System.out.println(reverseStringRecursive("kumar"));
	
	int i=10;
	int k=20;
	k=k+i;
	i=k-i;
	k=k-i;
	System.out.println(i);
	System.out.println(k);
	*/
/*permute("ab", "");
*/	
		
		String data="nar";
		HashMap<String, ArrayList<String>> map= new HashMap<String, ArrayList<String>>();
permute(data, "", 0, data.length(),map);	

for(String dat:map.keySet()){
	System.out.print(data+"---->");

}
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
	
	public static void  permute(String data,String perm,int start,int size,Map<String,ArrayList<String>> map){
		if(start==size){
	        if(map.get(data)!=null){
				map.get(data).add(perm);
			}
			else{
				map.put(data, new ArrayList<String>());
				map.get(data).add(perm);
			}
			return;
		}
		
		else{

			if(map.get(data)!=null){
				map.get(data).add(perm);
			}
			else{
				map.put(data, new ArrayList<String>());
				map.get(data).add(perm);
			}
			
			for(int i=start;i<size;i++){
				permute(appendCharInFirstPosition(data, i), perm+getCharInString(data, i), start+1, size,map);				
			}
			
		}
	}
	
}
