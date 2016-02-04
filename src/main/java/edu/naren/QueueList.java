package edu.naren;

public class QueueList<Data extends Comparable<Data>> {

	private LinkedList<Data> list=new LinkedList();
	
	

	
	public Data dequeue(){
		
		if(list.root==null){
			throw new RuntimeException("queue is empty");
		}
		else{
			Data data=list.root.data;
			list.delete(list.root);	
			return data;
		}
	}
	public QueueList<Data> enqueue(Data data){
		list.add(data);
		return this;
	}
	
	
	public QueueList<Data> delete(int position){
		list.delete(position);
		return this;
	}
	
    public QueueList<Data> delete(Data data){
		list.delete(data);
		return this;
	}
    
    public void display(){
    	list.display();
    }
	
	public static void main(String[] args) {
	  QueueList<String> queue=new QueueList<String>();
	  queue.enqueue("1").enqueue("2").enqueue("3").enqueue("4");
	  queue.dequeue();
	  queue.dequeue();
	  queue.dequeue();
	  queue.dequeue();
	  queue.dequeue();
	  queue.display();

	}

}
