import java.util.*;

public class MyDeque<T>{

    private Object[] data;
    private int head;
    private int tail;
    private int size;
    
    public MyDeque(){
	data = new Object[10];
	head=0;
	tail=head;
	size=0;
    }

    public String name(){
	return "gershfeld.katherine";
    }

    public int size(){
	return size;
    }

    public void addFirst(T value){
	if (head>0 && head-1!=tail){
	    data[head-1]=value;
	    head--;
	    size++;
	} else if (head==0 && tail<data.length-1){
	    data[data.length-1]=value;
	    head=data.length-1;
	    size++;
	} else {
	    //System.out.println('j');
	    resize();
	    addFirst(value);
	}
	//System.out.println(Arrays.toString(data));
    }

    public void addLast(T value){
	if (tail<data.length-1 && tail+1!=head){
	    data[tail+1]=value;
	    tail++;
	    size++;
	} else if ((head==0 && tail==data.length-1)||(tail<data.length-1 && tail+1==head)){
	    resize();
	    addLast(value);
	} else{
	    data[0]=value;
	    tail=0;
	    size++;
	}
	//System.out.println(Arrays.toString(data));
    }

    public T removeFirst(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	T ret = getFirst();
	data[head]=null;
	head++;
	if (head>=data.length){
	    head=0;
	}
	size--;
	//System.out.println(Arrays.toString(data));
	return ret;
    }

    public T removeLast(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	T ret = getLast();
	data[tail]=null;
	tail--;
	if (tail<0){
	    tail=data.length-1;
	}
	size--;
	//System.out.println(Arrays.toString(data));
	return ret;
    }

    public T getFirst(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	return (T)data[head];
    }

    public T getLast(){
	if (size==0){
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
	    int j=0;
	    for (int i=head;i<data.length;i++){
		if (data[i]!=null){
		    ret[j]=data[i];
		    j++;
		}
	    }
	    for (int i=0;i<=tail;i++){
		if (data[i]!=null){
		    ret[j]=data[i];
		    j++;
		}
	    }
	}
	head=0;
	tail=data.length-2;
	data=ret;
    }

    public String toString(){
	String ret = "[ ";
	if (size!=0){
	    ret = getFirst()+" "+getLast()+" [ ";
	    if (head<=tail){
		for (int i=head;i<=tail;i++){
		    ret+=data[i]+" ";
		}
	    }else{
		for (int i=head;i<data.length;i++){
		    if (data[i]!=null){
			ret+=data[i]+" ";
		    }
		}
		for (int i=0;i<=tail;i++){
		    if (data[i]!=null){
			ret+=data[i]+" ";
		    }
		}
	    }
	}
	return ret+"]";
    }

    public static void main(String[] args){
	MyDeque<Integer> q = new MyDeque<Integer>();
	System.out.println(q);
	q.addFirst(0);
	q.addLast(1);
	q.addFirst(2);
	q.addLast(3);
	q.addFirst(4);
	q.addLast(5);
	q.addFirst(6);
	q.addLast(7);
	q.addFirst(8);
	q.addLast(9);
	q.addFirst(10);
	q.addLast(11);
	System.out.println(q);
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q);
    }

}
