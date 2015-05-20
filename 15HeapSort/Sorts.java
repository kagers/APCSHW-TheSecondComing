public class Sorts{

    public static void heapSort(int[] argon){
	for (int i=argon.length-1; i>=0; i--){
	    pushUp(argon,i);
	}
    }

    public static void xchange(int[] argon, int x, int y){
	int temp = argon[x];
	argon[x] = argon[y];
	argon[y] = temp;
    }

    public static void pushUp(int[] argon, int n){
	if (n!=0){
	    if (argon[n]>argon[(n-1)/2]){
		xchange(argon,n,(n-1)/2);
		pushUp(argon,(n-1));
	    }
	}
    }

}
