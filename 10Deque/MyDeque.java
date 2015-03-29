import java.util.*;

public class MyDeque<T>{

    private Object[] data;
    private int head;
    private int tail;
    
    public MyDeque(){
	Object[] data = new Object[100];
	head=0;
	tail=head;
    }

    public String name(){
	return "gershfeld.katherine";
    }

    public void addFirst(T value){
	if (head>0 && head-1!=tail){
	    data[head-1]=value;
	    head--;
	} else if (head==0 && tail<data.length-1){
	    data[data.length-1]=value;
	    head=data.length-1;
	} else {
	    resize();
	    addFirst(value);
	}
    }

    public void addLast(T value){
	if (tail<data.length-1 && tail+1!=head){
	    data[tail+1]=value;
	    tail++;
	} else if (head<tail && tail==data.length-1){
	    resize();
	    addLast(value);
	}
    }

    public T removeFirst(){
	if (head==tail){
	    throw new NoSuchElementException();
	}
	return (T)"f";
    }

    public T removeLast(){
	if (head==tail){
	    throw new NoSuchElementException();
	}
	return (T)"f";
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

    private void resize(){
	Object[] ret = new Object[data.length*2];
	if (tail>=head){
	    int k=0;
	    for (int i=head;i<=tail;i++){
		ret[k]=data[i];
		k++;
	    }
	} else{
	    for (int i=head;i<data.length;i++){
		ret[i]=data[i];
	    }
	    for (int i=0;i<=tail;i++){
		ret[i+data.length+1] = data[i];
		tail+=data.length+1;
	    }
	}
	head=0;
	tail=data.length;
	data=ret;
    }

    public String toString(){
	String ret = "[ ";
	if (Math.abs(tail-head)!=0){
	    if (head<=tail){
		for (int i=head;i<=tail;i++){
		    ret+=data[i]+" ";
		}
	    }else{
		for (int i=head;i<data.length;i++){
		    ret+=data[i]+" ";
		}
		for (int i=0;i<=tail;i++){
		    ret+=data[i]+" ";
		}
	    }
	}
	return ret+"]";
    }

    public static void main(String[] args){
	MyDeque<String> d = new MyDeque<String>();
	System.out.println(d);
	d.addFirst("a");
	d.addLast("b");
	d.addFirst("c");
	d.addFirst("d");
	d.addLast("e");
	d.addLast("f");
	d.addFirst("g");
	System.out.println(d);
    }

}
