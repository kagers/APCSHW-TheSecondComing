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
	hepa[1] = hepa[hepa[0]];
	hepa[0]--;
	int i = 0;
	while (getLeft(i)<=hepa[0]){
	    int left = getLeft(i);
	    int right = getRight(i);
	    if (right<=hepa[0]){
		if (hepa[i]<hepa[left] || hepa[i]<hepa[right]){
		    if (hepa[left]>hepa[right]){
			swap(i,left);
			i = left;
		    } else if (hepa[left]<hepa[right]){
			swap(i,right);
			i = right;
		    }
		} else{
		    return ret;
		} 
	    } else if (hepa[i]<hepa[left]){
		swap(i,left);
		i = left;
	    } else{
		return ret;
	    }
	}
	return ret;
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

}
