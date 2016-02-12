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
   
   public Data peek(){
	   if(list.next!=null){
		   return list.next.data; 
	   }
	   else{
		   return null;
	   }
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
	
	
	public Data get(int position){
		return list.get(position);
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
		public boolean equals(Object o) {
			
	        if(o instanceof StackList){
	        	StackList<Data> obj=(StackList<Data>) o;
	        	Iterator<Data> i1=this.iterator();
	        	Iterator<Data> i2=obj.iterator();
	        	for(;i1.hasNext()||i2.hasNext();){
	        		
	        		if(!i1.hasNext()){
	        			return false;
	        		}
	        		else if(!i2.hasNext()){
	        			return false;
	        		}
	        		if(!i1.next().equals(i2.next())){
	        			return false;
	        		}
	        	}
	        	return true;
	        }  	
		
			return super.equals(o);
		}

	public boolean beginswith(StackList<Data> o) {
		
     
        	StackList<Data> obj=o;
        	Iterator<Data> i1=this.iterator();
        	Iterator<Data> i2=obj.iterator();
        	for(;i1.hasNext()||i2.hasNext();){
        		
        		if(!i1.hasNext()){
        			break;
        		}
        		else if(!i2.hasNext()){
        			break;
        		}
        		if(!i1.next().equals(i2.next())){
        			return false;
        		}
        	}
        	return true;
	}
	
	
	
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "["+list.toString()+"]";
		}
	
	public static void main(String[] args) {
		
		
		StackList<String> stack= new StackList<String>();
		
		stack.push("a").push("b").push("c");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
}
