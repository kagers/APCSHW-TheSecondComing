import java.util.*;

public class MyStack<T>{
    
    private LinkedList<T> stack;

    public MyStack(){
	stack = new LinkedList<T>();
    }
    
    public String name(){
    	return "gershfeld.katherine";
    }

    public T push(T item){
	stack.add(0,item);
	return item;
    }

    public T peek(){
	if (!empty()){
	    return stack.get(0);
	}
	throw new EmptyStackException();
    }

    public T pop(){
	if (!empty()){
	    peek();
	    return stack.remove(0);
	}
	throw new EmptyStackException();
    }

    public boolean empty(){
	return stack.size()==0;
    }

}
