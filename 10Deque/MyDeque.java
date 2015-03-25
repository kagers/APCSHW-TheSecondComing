import java.util.*;

public class MyDeque<T>{

    private Object[] data;
    private int head;
    private int tail;
    
    public MyDeque(){
	Object[] data = new Object[100];
    }

    public void addFirst(T value){
	
    }

    public void addLast(T value){

    }

    public T removeFirst(){
	if (head==tail){
	    throw new NoSuchElementException();
	}
	//return (T)1;
    }

    public T removeLast(){
	if (head==tail){
	    throw new NoSuchElementException();
	}
	//return (T)1;
    }

    public T getFirst(){
	if (head==tail){
	    throw new NoSuchElementException();
	}
	return (T)data[head];
    }

    public T getLast(){
	if (head==tail){
	    throw new NoSuchElementException();
	}
	return (T)data[tail];
    }

}
