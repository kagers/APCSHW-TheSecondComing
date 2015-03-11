public class LNode{
 
    private int data;
    private Lnode next;
   
    public LNode(){
	data = 0;
    }
    
    public LNode(int value){
	data = value;
    }

    public String toString(){
	return getData();
    }

    public String getData(){
	return data;
    }

    public void setValue(int value){
	data = value;
    }

    public LNode getNext(){
	return next;
    }

    public void setNext(LNode nxt){
	next = nxt;
    }

}
