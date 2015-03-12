import java.util.*;

public class MyLinkedList{

    private LNode start;
    private LNode now;

    public MyLinkedList(){
	start = null;
    }

    public MyLinkedList(LNode begin){
	start = begin;
	now = begin;
    }

    public String toString(){
	String ret = "[ ";
	while (now!=null){
	    ret+=now.toString()+" ";
	    now = now.getNext();
	}
	now = start;
	return ret+"]";
    }

    public void add(int value){
	if (start==null){
	    start = new LNode(value);
	    now = start;
	} else {
	    while (now.getNext()!=null){
		now = now.getNext();
	    }
	    now.setNext(new LNode(value));
	    now = start;
	}
    }

    public void add(int index, int value){
	if (index<0 || index>size()){
	    throw new IndexOutOfBoundsException();
	} else if (index==size()){
	    add(value);
	} else{
	    int i=0;
	    while (i<index){
		now = now.getNext();
		i++;
	    }
	    //System.out.println(now);
	    now.setNext(new LNode(now.getData(),now.getNext()));
	    now.setData(value);
	    now = start;
	}
    }

    public int size(){
	int ret = 0;
	while (now!=null){
	    now = now.getNext();
	    ret++;
	}
	now = start;
	return ret;
    }

    public int set(int index, int value){	
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	int i=0;
	while (i<index){
	    now = now.getNext();
	    i++;
	}
        //LNode vale = new LNode(value,now.getNext().getNext());
	LNode old = now;
	now.setData(value);
	if (index==0){
	    start = now;
	} else{
	    now = start;
	}
	return old.getData();
    }

    public int get(int index){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	int i=0;
	while (i<index){
	    now = now.getNext();
	    i++;
	}
	LNode vale = now;
	now = start;
	return vale.getData();
    }

    public int remove(int index){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	if (index==0){
	    LNode vale = start;
	    start = now.getNext();
	    now = start;
	    return vale.getData();
	} else{
	    int i=0;
	    while (i<index-1){
		now = now.getNext();
		i++;
	    }
	    System.out.println(now);
	    LNode vale = now.getNext();
	    now.setNext(now.getNext().getNext());
	    now = start;
	    return vale.getData();
	}
    }

    public int indexOf(int value){
	int i=0;
	while (now!=null){
	    //System.out.println(now);
	    if (now.getData()==value){
		return i;
	    }
	    now = now.getNext();
	    i++;
	}
	now = start;
	return -1;
    }

}
