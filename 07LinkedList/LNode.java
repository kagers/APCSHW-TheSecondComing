public class LNode{
 
    private int data;
    private LNode next;
   
    public LNode(){
	this(0,null);
    }
    
    public LNode(int value){
	this(value,null);
    }

    public LNode(int value, LNode nxt){
	data = value;
	next = nxt;
    }

    public String toString(){
	return getData()+"";
    }

    public int getData(){
	return data;
    }

    public void setData(int value){
	data = value;
    }

    public LNode getNext(){
	return next;
    }

    public void setNext(LNode nxt){
	next = nxt;
    }

}
