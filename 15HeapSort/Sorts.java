public class Sorts{

    public static void heapSort(int[] argon){
	for (int i=argon.length-1; i>=0; i--){
	    pushUp(argon,i);
	}
	for (int i=0; i<argon.length; i++) {
	    xchange(argon,0,argon.length-1-i);
	    pushDown(argon,0,argon.length-1-i);
	}
    }

    private static void xchange(int[] argon, int x, int y){
	int temp = argon[x];
	argon[x] = argon[y];
	argon[y] = temp;
    }

    private static void pushUp(int[] argon, int n){
	if (n!=0){
	    if (argon[n]>argon[(n-1)/2]){
		xchange(argon,n,(n-1)/2);
		pushUp(argon,(n-1));
	    }
	}
    }

    private static void pushDown(int[] argon, int n, int max) {
	if (getLeft(n)<max){
	    if (argon[n]<argon[getRight(n)]){
		xchange(argon,n,getRight(n));
		pushDown(argon,getRight(n),max);
	    } else if (argon[n]<argon[getLeft(n)]){
		xchange(argon,n,getLeft(n));
		pushDown(argon,getLeft(n),max);
	    }
	}
    }

    private static int getRight(int n) {
	return 2*(n+1);
    }

    private static int getLeft(int n) {
	return (2*n)+1;
    }

    public static void main(String[] args){
	
    }

}
