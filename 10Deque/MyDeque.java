import java.util.*;

public class MyDeque<T>{

    private Object[] data;
    private int head;
    private int tail;
    
    public MyDeque(){
	Object[] data = new Object[100];
    }

    public String name(){
	return "gershfeld.katherine";
    }

    public void addFirst(T value){
	if (head>1 && head-1!=tail){
	    data[head-1]=value;
	    head--;
	}
    }

    public void addLast(T value){
	if (tail<data.length-1 && tail+1!=head){
	    data[tail+1]=value;
	    tail++;
	} else if (head<tail && tail==data.length-1){
	    data = resize();
	    addLast(value);
	}
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

    private Object[] resize(){
	Object[] ret = new Object[data.length*2];
	if (tail>head){
	    for (int i=0;i<data.length;i++){
		ret[i]=data[i];
	    }
	}
	return ret;
    }

}
