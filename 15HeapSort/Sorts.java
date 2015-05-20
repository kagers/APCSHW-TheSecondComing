import java.util.*;

public class Sorts{

    public static void heapsort(int[] argon){
	for (int i=argon.length-1; i>=0; i--){
	    pushDown(argon,i,argon.length-1);
	}
	for (int i=argon.length-1; i>=0; i--){
	    xchange(argon,0,i);
	    pushDown(argon,0,i-1);
	}
    }

    private static void xchange(int[] argon, int x, int y){
	int temp = argon[x];
	argon[x] = argon[y];
	argon[y] = temp;
    }

    private static void pushDown(int[] argon, int n, int max) {
	while (getLeft(n)<=max){
	    if (getRight(n)<=max){
		if (argon[n]<=argon[getLeft(n)] || (argon[n]<=argon[getRight(n)])){
		    if (argon[getLeft(n)]>argon[getRight(n)]){
			xchange(argon,n,getLeft(n));
			n = getLeft(n);
		    } else if (argon[getLeft(n)]<argon[getRight(n)]){
			xchange(argon,n,getRight(n));
			n = getRight(n);
		    }
		} else{
		    return;
		}
	    } else if (argon[n]<=argon[getLeft(n)]){
		xchange(argon,n,getLeft(n));
		n = getLeft(n);
	    } else{
		return;
	    }
	}
    }

    private static int getRight(int n) {
	return 2*(n+1);
    }

    private static int getLeft(int n) {
	return (2*n)+1;
    }

    public static void randomize(int[] ary, int gg){
	Random rand = new Random(gg);
        for (int i=0;i<ary.length;i++){
	    int bi = rand.nextInt(ary.length);
	    int hi = ary[i];
	    ary[i] = ary[bi];
	    ary[bi] = hi;
	}
    }

    public static boolean eql(int[] a, int[] b){
	for (int i=0; i<b.length; i++){
	    if (b[i]!=a[i]){
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args){
	int[] eins = {9,4,6,2,5,3,7,8,1,0};
	heapsort(eins);
	System.out.println(Arrays.toString(eins));
	int[] drei = new int[1000000];
	int[] funf = new int[1000000];
	for (int i=0; i<drei.length; i++){
	    drei[i]=i;
	}
	randomize(drei,24);
	System.arraycopy(drei, 0, funf, 0, 1000000);
	heapsort(drei);
	Arrays.sort(funf);
	System.out.println(eql(drei,funf));
    }

}
