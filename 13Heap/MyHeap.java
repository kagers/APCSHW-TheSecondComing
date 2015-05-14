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
	String ret = "[";
	if (hepa[0]>0){
	    int i;
	    for (i=1; i<hepa[0]; i++){
		ret+=" "+hepa[i];
	    }
	    ret+=" "+hepa[i];
	}	
	return ret+" ]";
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
	if (hepa[0]<=0){
	    throw new NoSuchElementException();
	}
	int ret = hepa[1];
	hepa[1]=hepa[hepa[0]];
	int index = 1;
	hepa[hepa[0]]=0;
	hepa[0]=hepa[0]-1;
	remove(1);
	return ret;
    }

    public int remove(int i){
	if(peek()!=0 && i<hepa[0]){
	    int left = getLeft(i);
	    int right = getRight(i);
	    int dif = 0;
	    int d = -1;
	    boolean s = false;
	    if (left<=hepa[0]){
		dif = hepa[i]-hepa[left];
		d = 0;
	    } else if (right<=hepa[0]){
		dif = hepa[i]-hepa[right];
		d = 1;
	    }
	    if (max){
	        s = dif<0;
	    } else{
		s = dif>0;
	    }
	    int temp = hepa[i];
	    if (s){
		if (d == 0){
		    hepa[i]=hepa[left];
		    hepa[left]=temp;
		    remove(left); 
		} else if (d == 1){
		    hepa[i]=hepa[right];
		    hepa[right]=temp;
		    remove(right);
		}
	    }
	}
	return 0;
    }

    public void add(int value){
	    
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

    public static void main(String[] args){
	MyHeap hehe = new MyHeap();
    }

}
