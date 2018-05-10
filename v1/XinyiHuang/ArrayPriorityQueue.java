// Xinyi Huang
// APCS2 pd2
// HW46 -- Arrr, There Be Priorities Here Matey
// 2018-05-10

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

    private ArrayList _storage;
    private int _size;

    public ArrayPriorityQueue{
	_storage = new ArrayList<String>();
	_size = 0;
    }

    public void add(String s){
	if (isEmpty()){
	    _storage.add(s);
	}
	else{
	    for(int i = 0; i < _size; i++){
		if (s.compareTo(_storage[i]) > 0)
		    _storage.add(i,s);
	    }
	}
	_size++;
    }
    
    public boolean isEmpty(){
	return _size == 0;
    }
    
    public String peekMin(){
	return _storage[0];
    }
    
    public String removeMin(){
	String temp = _storage[0];
	_storage.remove(0);
	return temp;
    }

    public static void main(String[] args){
	PriorityQueue test = new ArrayPriorityQueue();
	//testing isEmpty
	System.out.println("Is empty? " + test.isEmpty()); //true
	
	//testing add
	test.add("foo");
	test.add("boo");
	test.add("goo");
	test.add("doo");
	
	//testing isEmpty
	System.out.println("Is empty? " + test.isEmpty()); //false
	
	System.out.println(test.peekMin()); //boo
	System.out.println(test.removeMin());
	System.out.println(test.peekMin()); //doo
	System.out.println(test.removeMin());
    }	
}
