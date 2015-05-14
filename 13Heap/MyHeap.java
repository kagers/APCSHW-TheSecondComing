public class MyHeap{

    private int[] hepa;
    private boolean max;

    public MyHeap(){
	this(true);
    }

    public MyHeap(boolean isMax){
	hepa = new int[10];
	max = isMax;
    }

    public String toString(){
	return "";
    }

    public int remove(){
	if (hepa[0]>0){
	    int ret = hepa[1];
	    for (int i=1; i<hepa[0]-1; i++){
		hepa[i] = hepa[i+1];
	    }
	    return ret;
	} else {
	    throw new Exception();
	}
    }

    public void add(int){

    }
    
    public int peek(){
	if (hepa[0]>0){
	    return hepa[1];
	}
	throw new Exception();
    }

}
