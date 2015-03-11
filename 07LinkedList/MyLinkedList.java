public class MyLinkedList{

    private LNode start;
    private LNode now;

    public MyLinkedList(){

    }

    public MyLinkedList(LNode begin){
	start = begin;
	now = begin;
    }

    public String toString(){
	String ret = "[";
	while (!now.equals(null)){
	    ret+=now.toString();+", "
	    now = now.getNext();
	}
	now = start;
	return ret+"]";
    }

    public void add(int value){

    }

    public void add(int index, int value){

    }

    public int size(){

    }

    public void set(int index, int value){

    }

    public void get(int index){

    }

    public void remove(int index){

    }

    public void indexOf(int value){

    }

}
