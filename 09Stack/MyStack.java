import java.util.*;

public class MyStack<T>{
    
    private LinkedList<T> stack;

    public MyStack(){
	stack = new LinkedList<T>();
    }

    public T push(T item){
	stack.add(0,item);
	return item;
    }

    public T peek(){
	return stack.get(0);
    }

    public T pop(){
	peek();
	return stack.remove(0);
    }

    public boolean empty(){
	return stack.size()==0;
    }

}
