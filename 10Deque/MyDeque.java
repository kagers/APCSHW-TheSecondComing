import java.util.*;

public class MyDeque<T>{

    private Object[] data;
    private int head;
    private int tail;
    
    public MyDeque(){
	data = new Object[10];
	head=0;
	tail=head;
    }

    public String name(){
	return "gershfeld.katherine";
    }

    public void addFirst(T value){
	System.out.println(Arrays.toString(data));
	if (head>0 && head-1!=tail){
	    data[head-1]=value;
	    head--;
	} else if (head==0 && tail<data.length-1){
	    data[data.length-1]=value;
	    head=data.length-1;
	} else {
	    System.out.println('j');
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
	    int j=0;
	    for (int i=head;i<data.length;i++){
		if (data[i]!=null){
		    ret[j]=data[i];
		    j++;
		}
	    }
	    System.out.println(Arrays.toString(ret));
	    for (int i=0;i<=tail;i++){
		System.out.println(data[i]+" "+i);
		if (data[i]!=null){
		    System.out.println("kkk");
		    ret[j]=data[i];
		    j++;
		}
	    }
	    System.out.println(Arrays.toString(ret));
	}
	head=0;
	tail=data.length-1;
	data=ret;
    }

    public String toString(){
	String ret = getFirst()+" "+getLast()+" [ ";
	if (Math.abs(tail-head)!=0){
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
	System.out.println(Arrays.toString(data));
	return ret+"]";
    }

    public static void main(String[] args){
	MyDeque<Integer> d = new MyDeque<Integer>();
	//System.out.println(d);
	d.addFirst(0);
	d.addLast(1);
	d.addFirst(2);
	d.addLast(3);
	d.addFirst(4);
	d.addLast(5);
	d.addFirst(6);
	d.addLast(7);
	d.addFirst(8);
	d.addLast(9);
	d.addFirst(10);
	d.addLast(11);
	System.out.println(d);
    }

}
