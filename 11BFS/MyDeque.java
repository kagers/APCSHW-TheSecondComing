import java.util.*;

public class MyDeque<T>{

    private Object[] data;
    private int[] priority;
    private int head;
    private int tail;
    private int size;
    private boolean pq;
    
    public MyDeque(boolean priorityQueue){
	data = new Object[10];
	head=5;
	tail=4;
	size=0;
	pq=priorityQueue;
	if (pq){
	    priority = new int[10];
	}
    }

    public MyDeque(){
	this(false);
    }

    public String name(){
	return "gershfeld.katherine";
    }

    public int size(){
	return size;
    }

    public void addFirst(T value){
	if (size==data.length){
	    resize();
	}	
	head--;
	if (head==-1){
	    head = data.length-1;
	}
	data[head] = value;
	size++;
    }

    public void addLast(T value){
	if (size==data.length){
	    resize();
	}	
	tail++;
	if (tail==data.length){
	    tail = 0;
	}
	data[tail] = value;
	size++;
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
	if (size==1 && (T)data[tail]==null){
	    return getFirst();
	}
	return (T)data[tail];
    }

    private void resize(){
	Object[] ret = new Object[data.length*2];
	int[] rett = new int[data.length*2];
	if (tail>=head){
	    int k=0;
	    for (int i=head;i<=tail;i++){
		if (pq){
		    rett[k]=priority[i];
		}
		ret[k]=data[i];
		k++;
	    }
	} else{
	    int j=0;
	    for (int i=head;i<data.length;i++){
		if (data[i]!=null){
		    if (pq){
			rett[j]=priority[i];
		    }
		    ret[j]=data[i];
		    j++;
		}
	    }
	    for (int i=0;i<=tail;i++){
		if (data[i]!=null){
		    if (pq){
			rett[j]=priority[i];
		    }
		    ret[j]=data[i];
		    j++;
		}
	    }
	}
	head=0;
	tail=data.length-1;
	data=ret;
	if (pq){
	    priority=rett;
	}
    }

    public String toString(){
	String ret = "[ ";
	if (size!=0){
	    //ret = Arrays.toString(data)+"\n"+head+" "+tail+" "+getFirst()+" "+getLast()+" "+"[ ";
	    if (head<=tail){
		for (int i=head;i<=tail;i++){
		    if (data[i]!=null){
			ret+=data[i]+" ";
		    }
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

    public void add(T value, int pr){
	addLast(value);
	priority[tail]=pr;	
    }

    public T removeSmallest(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	int index=head;
	if (head<=tail){
	    for (int i=head+1; i<=tail; i++){
		if (priority[i]<priority[index]){
		    index=i;
		}
	    }
	} else{
	    for (int i=head+1; i<priority.length; i++){
		if (priority[i]<priority[index]){
		    index=i;
		}
	    }
	    for (int i=0; i<=tail; i++){
		if (priority[i]<priority[index]){
		    index=i;
		}
	    }
	}
	Object ret=data[index];
	priority[index]=priority[head];
	priority[head]=0;
	data[index]=removeFirst();
	return (T)ret;
    }

    public static void main(String[] args){
	/*MyDeque<Integer> q = new MyDeque<Integer>();
	System.out.println(q);
	q.addFirst(0);
	System.out.println(q);
	q.addLast(1);
	System.out.println(q);
	q.addFirst(2);
	System.out.println(q);
	q.addLast(3);
	System.out.println(q);
	q.addFirst(4);
	System.out.println(q);
	q.addLast(5);
	System.out.println(q);
	q.addFirst(6);
	System.out.println(q);
	q.addLast(7);
	System.out.println(q);
	q.addFirst(8);
	System.out.println(q);
	q.addLast(9);
	System.out.println(q);
	q.addFirst(10);
	System.out.println(q);
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
	*/MyDeque<Integer> q = new MyDeque<Integer>(true);
	System.out.println(q);
	q.add(0,12);
	System.out.println(q);
	q.add(1,6);
	System.out.println(q);
	q.add(2,11);
	System.out.println(q);
	q.add(3,5);
	System.out.println(q);
	q.add(4,10);
	System.out.println(q);
	q.add(5,4);
	System.out.println(q);
	q.add(6,9);
	System.out.println(q);
	q.add(7,3);
	System.out.println(q);
	q.add(8,8);
	System.out.println(q);
	q.add(9,2);
	System.out.println(q);
	q.add(10,7);
	System.out.println(q);
	q.add(11,1);
	System.out.println(q);
	System.out.println(q.removeSmallest());
	System.out.println(q.removeSmallest());
	System.out.println(q.removeSmallest());
	System.out.println(q.removeSmallest());
	System.out.println(q.removeSmallest());	
	System.out.println(q.removeSmallest());
	System.out.println(q.removeSmallest());
	System.out.println(q.removeSmallest());
	System.out.println(q.removeSmallest());
	System.out.println(q.removeSmallest());
	System.out.println(q.removeSmallest());
	System.out.println(q.removeSmallest());
	System.out.println(q);	
    }

}
