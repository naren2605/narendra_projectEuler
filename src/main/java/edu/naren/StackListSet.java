package edu.naren;

import java.util.HashSet;

public class StackListSet<Data> extends StackList<Data> {

private HashSet<Data> set = new HashSet<Data>();
@Override
public boolean equals(Object o) {
	if(o instanceof HashSet){
		//System.err.println("equals in  stacklistset..");
		return set.equals(o);
		
	}
		
		return super.equals(o);
	}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return set.toString();
	}
@Override
	public boolean contains(Data data) {

	//System.err.println("contains in  stacklistset..");
		return set.contains(data);
	}
@Override
	public StackList<Data> push(Data data) {
		// TODO Auto-generated method stub
	set.add(data);
		return super.push(data);
	}
@Override
	public Data pop() {
	Data data=super.pop();
	set.remove(data);
		return data;
	}

}
