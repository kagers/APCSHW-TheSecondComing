import java.util.*;

public class MyLinkedList{

    private LNode start;
    private LNode end;
    private int size;
    //private LNode now;

    public MyLinkedList(){
	this(null);
    }

    public MyLinkedList(LNode begin){
	start = begin;
	end = start;
	size = 0;
	//now = begin;
    }

    public String toString(){
	LNode now = start;
	String ret = "[ ";
	while (now!=null){
	    ret+=now.toString()+",";
	    now = now.getNext();
	}
	//now = start;
	return ret.substring(0,ret.length()-1)+" ]";
    }

    public boolean add(int value){
	LNode now = start;
	if (start==null){
	    start = new LNode(value);
	    end = start;
	    //now = start;
	} else {
	    //end = new LNode(value);
	    while (now.getNext()!=null){
		now = now.getNext();
	    }
	    now.setNext(new LNode(value));
	    //now = start;
	}
	size++;
	return true;
    }

    public boolean add(int index, int value){
	LNode now = start;
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
	    //now = start;
	    size++;
	}
	return true;
    }

    public int size(){
	/*LNode now = start;
	int ret = 0;
	while (now!=null){
	    now = now.getNext();
	    ret++;
	}
	//now = start;
	return ret;
	*/return size;
    }

    public int set(int index, int value){
	LNode now = start;
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
	LNode now = start;
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
	LNode now = start;
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	if (index==0){
	    LNode vale = start;
	    start = now.getNext();
	    //now = start;
	    size--;
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
	    //now = start;
	    size--;
	    return vale.getData();
	}
    }

    public int indexOf(int value){
	LNode now = start;
	int i=0;
	while (now!=null){
	    //System.out.println(now);
	    if (now.getData()==value){
		return i;
	    }
	    now = now.getNext();
	    i++;
	}
	//now = start;
	return -1;
    }

}
