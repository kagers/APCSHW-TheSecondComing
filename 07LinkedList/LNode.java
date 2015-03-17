public class LNode<T>{
 
    private T data;
    private LNode<T> next;
   
    public LNode(){
	//this(0,null);
    }
    
    public LNode(T value){
	this(value,null);
    }

    public LNode(T value, LNode<T> nxt){
	data = value;
	next = nxt;
    }

    public String toString(){
	return getData()+"";
    }

    public T getData(){
	return data;
    }

    public void setData(T value){
	data = value;
    }

    public LNode<T> getNext(){
	return next;
    }

    public void setNext(LNode<T> nxt){
	next = nxt;
    }

}
