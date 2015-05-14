import java.util.*;

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

    private int getParent(int i){
	return i/2;
    }

    private int getLeft(int i){
	return i*2;
    }

    private int getRight(int i){
	return i*2+1;
    }

    private void swap(int j, int k){
	int temp = hepa[j];
	hepa[j] = hepa[k];
	hepa[k] = temp;
    }

    public int remove(){
	if (hepa[0]>0){
	    int ret = hepa[1];
	    hepa[1] = hepa[hepa[0]];
	    hepa[0]--;
	    int i = 0;
	    while (
	    return ret;
	} else {
	    throw new NoSuchElementException();
	}
    }

    public void add(int ){

    }

    private void resize(){
	hepa = Arrays.copyOf(hepa,hepa[0]*2);
    }
    
    public int peek(){
	if (hepa[0]>0){
	    return hepa[1];
	}
	throw new NoSuchElementException();
    }

}
