package edu.naren.tables;

public abstract class ST<Key,Value> {
	abstract void put(Key key, Value val);
	abstract Value get(Key key);
	abstract void delete(Key key);
	abstract boolean contains(Key key);
	abstract boolean isEmpty();
	abstract int size();
	abstract Key min();       
	abstract Key max() ;          
	abstract Key floor(Key key);  
	abstract Key ceiling(Key key);
	abstract int rank(Key key);   
	abstract Key select(int k);   
	abstract void deleteMin() ;   
	abstract void deleteMax()  ;  
	abstract int size(Key lo, Key hi);            
	abstract Iterable<Key> keys(Key lo, Key hi) ; 
	abstract Iterable<Key> keys();
}
