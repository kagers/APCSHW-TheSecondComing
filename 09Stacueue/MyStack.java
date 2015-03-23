import java.util.*;

public class MyStack<T>{
    
    private MyLinkedList<T> ll;

    public String name(){
	return "gershfeld.katherine";
    }
    
    public MyStack(){
	ll = new MyLinkedList<T>();
    }

    public T push(T item){
	ll.add(0,item);
	return item;
    }

    public T pop(){
	if (!empty()){
	    //peek();
	    return ll.remove(0);
	}
	throw new EmptyStackException();
    }

    public T peek(){
	if (!empty()){
	    return ll.get(0);
	}
	throw new EmptyStackException();
    }

    public boolean empty(){
	return ll.size()==0;
    }

}
