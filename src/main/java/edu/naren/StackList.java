package edu.naren;

import java.util.Iterator;

public class StackList<Data>  implements Iterable<Data>{
LinkedList<Data> list = new LinkedList<Data>();

   public Iterator<Data> iterator() {
		return list.iterator();
	}
    
   public int size(){
	   return list.size();
   }
   
   public boolean isEmpty(){
	   
	   if(list.root==null){
		   return true;
	   }else{
		   return false;
	   }
   }
   
   public void empty(){
	   while(!this.isEmpty()){
		   this.pop();
	   }
   }

	public StackList<Data> push(Data data){
		list.add(data);
		return this;
	}
	public Data pop(){
		if(list.next==null){
			throw  new RuntimeException("stack is empty");	
		}
		Data data= list.next.data;
		list.delete(list.next);
		return data;
	}
	
	public Data getFirst(){
	   return list.root.data;
	}

	
	public Data delete(int position){
		return list.deleteAndReturnData(position);
	}
	
	
	public void display(){
		list.display();
	}
	
	public  StackList<Data> clone(){
		StackList<Data> cloneStack=new StackList<Data>();
		Iterator<Data> itr= iterator();
		for(;itr.hasNext();){
			cloneStack.push(itr.next());
		}
		return cloneStack;
		
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return list.toString();
		}
	
	public static void main(String[] args) {
		
		
		StackList<String> stack= new StackList<String>();
		
		stack.push("a").push("b").push("c");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
}
