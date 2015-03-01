import java.util.*;

public class Sorts{
    public static void mergey(int[] array, int starta, int enda, int startb, int endb){
	int i  = starta;
	int ia = 0;
	int ib = 0;
	int[] a = Arrays.copyOfRange(array,starta,enda+1);
	int[] b = Arrays.copyOfRange(array,startb,endb+1);
	while (ia<a.length && ib<b.length){
	    if (a[ia]<b[ib]){
		array[i] = a[ia];
		ia++;
	    } else{
		array[i] = b[ib];
		ib++;
	    }
	    i++;
	}
	while (ia<a.length){
	    array[i] = a[ia];
	    ia++;
	    i++;
	}
	while (ib<b.length){
	    array[i] = b[ib];
	    ib++;
	    i++;
	}		
    }
    public static void mergesort(int[] array){
	mergehelp(array,0,(array.length/2)-1,array.length/2,array.length-1);
    }
    public static void mergehelp(int[] array, int a, int b, int c, int d){
	if (b-a>0 || d-c>0){
	    mergehelp(array,a,((b-a)/2)+a,((b-a)/2)+1+a,b);
	    mergehelp(array,c,((d-c)/2)+c,((d-c)/2)+1+c,d);
	}
	mergey(array,a,b,c,d);	
    }
    public static boolean arrayEquals(int[] a, int[] b){
	for (int i=0; i<a.length; i++){
	    if (a[i]!=b[i]){
		return false;
	    }
	}
	return true;
    }
    public static void main(String[] args){

	if (args.length>0){

	    int[] f = new int[1000000];
	    Random r = new Random();

	    if (args[0].equals("1")){
		for (int i=0; i<f.length; i++){
		    f[i]=i;
		}
	    } else if (args[0].equals("2")){
		for (int i=0; i<f.length; i++){
		    f[i]=f.length-i;
		}
	    } else if (args[0].equals("3a")){
		for (int i=0; i<f.length; i++){
		    f[i]=r.nextInt(3)+1;
		}
	    } else if (args[0].equals("3b")){
		for (int i=0; i<f.length; i++){
		    f[i]=r.nextInt((1000000+1000000) + 1)-1000000;
		}
	    }

	    int[] g = new int[f.length];
	    System.arraycopy(f, 0, g, 0, f.length);

	    long start = System.currentTimeMillis();
	    Sorts.mergesort(f);
	    long end = System.currentTimeMillis();
	    System.out.println(end-start);
	    
	    start = System.currentTimeMillis();
	    Arrays.sort(g);
	    end = System.currentTimeMillis();
	    System.out.println(end-start);
	    
	    System.out.println(arrayEquals(f,g));
	}

	/*int[] a = {0,6,6};
	int[] b = {1,3,5};
	System.out.println(Arrays.toString(merge(a,b)));*/

	/*int[] c = {1,2,3,4,0,1,7,9};
	mergey(c,0,3,4,7);
	System.out.println(Arrays.toString(c));*/

	/*int[] c = {4,3};
	mergey(c,0,3,4,7);
	System.out.println(Arrays.toString(c));*/

	/*int[] d = {1,2,5,4,3,7,1,0,9};
	System.out.println(Arrays.toString(d));
	mergesort(d);
	System.out.println(Arrays.toString(d));*/

    }
}
