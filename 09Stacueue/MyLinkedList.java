import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

    private LNode<T> start;
    private LNode<T> end;
    private int size;
    //private LNode now;

    public MyLinkedList(){
	this(null);
	//this(new LNode<T>());
    }

    public String name(){
	return "katherine.gershfeld";
    }

    public MyLinkedList(LNode<T> begin){
	start = begin;
	end = start;
	size = 0;
    }

    public Iterator<T> iterator(){
	return new MyLinkedListIterator<T>(start);
    }

    public String toString(){
	LNode<T> now = start;
	String ret = "[ ";
	while (now!=null){
	    ret+=now.toString()+",";
	    now = now.getNext();
	}
	return ret.substring(0,ret.length()-1)+" ]";
    }

    public boolean add(T value){
	if (value == null){
	    throw new NullPointerException();
	}
	LNode<T> now = start;
	if (size==0){
	    start = new LNode<T>(value);
	    end = start;
	} else {
	    end.setNext(new LNode<T>(value));
	    end = end.getNext();
	}
	size++;
	return true;
    }

    public boolean add(int index, T value){
	if (value == null){
	    throw new NullPointerException();
	}
	LNode<T> now = start;
	if (index<0 || index>size()){
	    throw new IndexOutOfBoundsException();
	} else if (index==size()){
	    add(value);
	} else if (index==0){
	    LNode<T> hi = new LNode<T>(value,start);
	    start = hi;
	    size++;
	} else{
	    int i=0;
	    while (i<index-1){
		now = now.getNext();
		i++;
	    }
	    now.setNext(new LNode<T>(value,now.getNext()));
	    size++;
	}
	return true;
    }

    public int size(){
        return size;
    }

    public T set(int index, T value){
	LNode<T> now = start;
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	int i=0;
	while (i<index){
	    now = now.getNext();
	    i++;
	}
       	T old = now.getData();
	now.setData(value);
	if (index==0){
	    start = now;
	} else if (index==size()-1){
	    end = now;
	}
	return old;
    }

    public T get(int index){
	LNode<T> now = start;
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	int i=0;
	while (i<index){
	    now = now.getNext();
	    i++;
	}
	return now.getData();
    }

    public T remove(int index){
	LNode<T> now = start;
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	if (index==0){
	    LNode<T> vale = start;
	    start = now.getNext();
	    end = start;
	    size--;
	    return vale.getData();
	} else{
	    int i=0;
	    while (i<index-1){
		now = now.getNext();
		i++;
	    }
	    LNode<T> vale = now.getNext();
	    now.setNext(now.getNext().getNext());
	    size--;
	    if (index==size){
		end = now;
	    }
	    return vale.getData();
	}
    }

    public int indexOf(T value){
	LNode<T> now = start;
	int i=0;
	while (now!=null){
	    if (now.getData().equals(value)){
		return i;
	    }
	    now = now.getNext();
	    i++;
	} 
	return -1;
    }

    public void clear(){
	size = 0;
	start = new LNode<T>();
	end = start;	    
    }

    public class MyLinkedListIterator<T> implements Iterator<T>{
	
	private LNode<T> start;
	
	public MyLinkedListIterator(LNode<T> hi){
	    start = hi;
	}

	public boolean hasNext(){
	    return (start.getNext() != null);
	}

	public T next(){
	    start = start.getNext();
	    if (start.getData() == null){
		throw new NoSuchElementException();
	    }
	    return start.getData();
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}

    }

}
