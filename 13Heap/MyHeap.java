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

    public void add(int n){
	if (hepa[0] == hepa.length-1){
	    resize();
	}
	int size = hepa[0]+1;
	hepa[size] = n;
	hepa[0] = size;
	int i = size;
	while (getParent(i) > 0){
	    int p = getParent(i);
	    boolean m = false;
	    if (max){
		m = hepa[i]>hepa[p];
	    } else{
		m = hepa[i]<hepa[p];
	    }
	    if (m){
		swap(i,p);
	    }
	    i = p;
	}
    }

    public int remove(){
	int size = hepa[0];
	boolean m = false;
	if (size==0){
	    throw new NoSuchElementException();
	}else{
	    int ret=hepa[1];
	    hepa[1]=hepa[size];
	    hepa[0] = --size; 
	    int i = 1;
	    while (getLeft(i) <= size){
		int l = getLeft(i);
		int r = getRight(i);
	        if (r <= size){
		    if (max){
			m = hepa[i] < hepa[l] || hepa[i] < hepa[r];
		    } else{
			m = hepa[i] > hepa[l] || hepa[i] > hepa[r];
		    }
		    if (m){
			int dif = hepa[l]-hepa[r];
			if (!max){
			    dif*=-1;
			}
			if (dif > 0){
			    swap(i,l);
			    i = l;
			} else if (dif < 0){
			    swap(i, r);
			    i = r;
			}
		    }else{
			return ret;
		    }
		}else if (hepa[i] < hepa[l]){
		    swap(i,l);
		    i = l;
		}else{
		    return ret;
		}
	    }
	    return ret;
	}
	
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
	MyHeap hehe = new MyHeap(false);
	System.out.println(hehe);
	hehe.add(3);
	hehe.add(1);
	hehe.add(5);
	hehe.add(4);
	hehe.add(7);
	hehe.add(9);
	hehe.add(10);
	System.out.println(hehe);
	System.out.println(hehe.remove());
	System.out.println(hehe);
	System.out.println(hehe.remove());
	System.out.println(hehe);
    }

}
