import java.util.*;

public class MyQueue<T>{
    
    private MyLinkedList<T> q;

    public MyQueue(){
	q = new MyLinkedList<T>();
    }

    public String name(){
	return "gershfeld.katherine";
    }

    public boolean enqueue(T item){
	q.add(item);
	return true;
    }

    public T dequeue(){
	if (q.size()== 0){
	    throw new NoSuchElementException();
	}
	return q.remove(0);
    }

    public boolean empty(){
	return q.size()==0;
    }

}
