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
	//now = begin;
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
	//now = start;
	return ret.substring(0,ret.length()-1)+" ]";
    }

    public boolean add(T value){
	LNode<T> now = start;
	if (size==0){
	    start = new LNode<T>(value);
	    end = start;
	    //now = start;
	} else {
	    //end = new LNode(value);
	    while (now.getNext()!=null){
		now = now.getNext();
	    }
	    now.setNext(new LNode<T>(value));
	    //now = start;
	}
	size++;
	return true;
    }

    public boolean add(int index, T value){
	LNode<T> now = start;
	if (index<0 || index>size()){
	    throw new IndexOutOfBoundsException();
	} else if (index==size()){
	    add(value);
	} else{
	    int i=0;
	    while (i<index){
		now = now.getNext();
		i++;
	    }
	    //System.out.println(now);
	    now.setNext(new LNode<T>(now.getData(),now.getNext()));
	    now.setData(value);
	    //now = start;
	    size++;
	}
	return true;
    }

    public int size(){
	/*LNode now = start;
	int ret = 0;
	while (now!=null){
	    now = now.getNext();
	    ret++;
	}
	//now = start;
	return ret;
	*/return size;
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
        //LNode vale = new LNode(value,now.getNext().getNext());
	T old = now.getData();
	now.setData(value);
	if (index==0){
	    start = now;
	} else{
	    now = start;
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
	//LNode<T> vale = now;
	//now = start;
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
	    //now = start;
	    size--;
	    return vale.getData();
	} else{
	    int i=0;
	    while (i<index-1){
		now = now.getNext();
		i++;
	    }
	    //System.out.println(now);
	    LNode<T> vale = now.getNext();
	    now.setNext(now.getNext().getNext());
	    //now = start;
	    size--;
	    return vale.getData();
	}
    }

    public int indexOf(T value){
	LNode<T> now = start;
	int i=0;
	while (now!=null){
	    //System.out.println(now);
	    if (now.getData().equals(value)){
		return i;
	    }
	    now = now.getNext();
	    i++;
	} 
	//now = start;
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
	    return (start != null);
	}

	public T next(){
	    T data = start.getData();
	    start = start.getNext();
	    return data;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}

    }

}
