package dev.euler.prob24;

import java.util.ArrayList;
import java.util.List;

import dev.Utils;

public class LexicographicPermutations {

	public static void main(String[] args) {
	
LinkedList list= new LinkedList();
list.add(1).add(2);

int size=3;
LinkedList[] lists=new LinkedList[size];
ArrayList<Integer> control=new ArrayList<Integer>();
for(int i=0;i<size;i++){
	LinkedList localList= new LinkedList();
	for(int j=0;j<size;j++){
		localList.add(j);
	}
	lists[i]=localList;
	/*listControl[i]=0;*/
	control.add(size-1-i);
}



/*while(true){
	boolean isAllRotated=false;
	
	long total=0;
	for(int i=0;i<size;i++){
		total=total+listControl[i];
	}
	
	if(total==size*size){
		break;
	}
	
	
}

*/


	}
	
	private static void combinations(LinkedList[] lists,List<Integer> list){
		
		for(int i:list){
			
			while(!lists[i].rotate()){
				
			}
		}
		
	}
	
	
	private static class Node{	
		int data;
		Node front=null;
		Node rear=null;
		public Node(int data) {
			this.data=data;
		}
	}
    
	private static class LinkedList{
		Node start=null;
		Node presentNode=null;
		Node bookMark=null;
		int rotations=1;
		public LinkedList(int data) {
			start=new Node(data);
			presentNode=start;
			bookMark=start;
		}
		public LinkedList() {
		
		}
		public LinkedList add(int i){
			if(start==null){
				start=new Node(i);
				presentNode=start;
				bookMark=start;
			}
			else if(presentNode==start){
				start.front=new Node(i);
				presentNode=start.front;
				start.front.front=start;
			}
			else{
				Node temp=new Node(i);
				temp.front=presentNode.front;
				presentNode.front=temp;
				presentNode=temp;
			}
		
			return this;
		}
		
		public int getBookMarkData(){
			return bookMark.data;
		}
		
		public boolean rotate(){
			bookMark=bookMark.front;
			rotations++;
			if(bookMark==start){
				return true;
			}
			else{
				return false;
			}
		}
	}
}
