import java.util.*;

public class MyDeque<T>{

    private Object[] data;
    private int[] priority;
    private int head;
    private int tail;
    private int size;
    private boolean priorityQueue;
    
    public MyDeque(boolean pq){
	data = new Object[10];
	head=0;
	tail=0;
	size=0;
	priorityQueue=pq;
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
	//adj();
    }

    public void adj(){
	if (size==1){
	    tail=head;
	} 
	if (data[tail]==null){
	    if (tail-1<0){
		tail=data.length-1;
	    } else{
		tail--;
	    }
	}
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
	//adj();
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
	//adj();
	return ret;
    }

    public T removeLast(){
	//adj();
	if (size==0){
	    throw new NoSuchElementException();
	}
	/*if (data[tail]==null && size>0){
	    System.out.println("KK"+data[tail]);
	    if (tail-1<0){
		tail=data.length-1;
	    } else{
		tail--;
	    }
	    }*/
	T ret = getLast();
	data[tail]=null;
	tail--;
	if (tail<0){
	    tail=data.length-1;
	}
	size--;
	//System.out.println(Arrays.toString(data));
	//adj();
	return ret;
    }

    public T getFirst(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	return (T)data[head];
    }

    public T getLast(){
	//adj();
	if (size==0){
	    throw new NoSuchElementException();
	}
	/*if (size==1 && (T)data[tail]==null){
	    return getFirst();
	}*/
	if (tail==0){
	    return (T)data[data.length-1];
	}
	return (T)data[tail-1];
    }

    /*private void resz(int[] L){
	int[] ret = new int[L.length*2];
	if (tail>=head){
	    int k=0;
	    for (int i=head;i<=tail;i++){
		ret[k]=L[i];
		k++;
	    }
	} else{
	    int j=0;
	    for (int i=head;i<L.length;i++){
		ret[j]=L[i];
		j++;
	    }
	    for (int i=0;i<=tail;i++){
		//if (L[i]!=null){
		    ret[j]=L[i];
		    j++;
		    //}
	    }
	}
	head=0;
	tail=L.length-2;
	L=ret;
	}*/

    private void resz(Object[] L){
	Object[] ret = new Object[L.length*2];
	if (tail>=head){
	    int k=0;
	    for (int i=head;i<=tail;i++){
		ret[k]=L[i];
		k++;
	    }
	} else{
	    int j=0;
	    for (int i=head;i<L.length;i++){
		if (L[i]!=null){
		    ret[j]=L[i];
		    j++;
		}
	    }
	    for (int i=0;i<=tail;i++){
		if (L[i]!=null){
		    ret[j]=L[i];
		    j++;
		}
	    }
	}
	head=0;
	tail=L.length-2;
	L=ret;
    }

    public void resize(){
	//if (priorityQueue){
	//    resz(priority);
	//}
	resz(data);
    }

    public String toString(){
	String ret = "[ ";
	if (size!=0){
	    ret = getFirst()+" "+getLast()+" "+"[ ";
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

    /*public void add(Object value,int pri){
	priority = new int[data.length];
	if (size==data.length){
	    resize();
	}
	addLast(value);
	priority[tail]=priority;
    }

    public T removeSmallest(){
	if (priority!=null){
	    int j;
	    if (size!=0){
		//ret = getFirst()+" "+getLast()+" "+"[ ";
		if (head<=tail){
		    for (int i=head;i<=tail;i++){
			j=i;
		    }
		}else{
		for (int i=head;i<data.length;i++){
		    if (data[i]!=null){
			j=i;
		    }
		}
		for (int i=0;i<=tail;i++){
		    if (data[i]!=null){
			j=i;
		    }
		}
		}
	    }
	    T ret = (T)priority[j];
	} else {
	    throw new NullPointerException();
	}
	}*/

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
