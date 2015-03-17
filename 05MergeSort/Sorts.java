import java.util.*;

public class Sorts{
    public String name(){
	return "gershfeld.katherine";
    }
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
	//System.out.println(Arrays.toString(array));
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
	
	int[] a = {0,1,2,3,4,5,6,7};
	int[] b = {3,1,7,4,6,0,2,5};
	int[] c = {7,5,3,1,6,4,2,0};

	mergesort(c);
	
	if (args.length>0){

	    int size = 1000000;
	    try{
		size = Integer.parseInt(args[0]);}
	    catch (Exception e){}

	    int[] eins = new int[size]; //sorted
	    int[] zwei = new int[size]; //reverse sorted
	    int[] drei = new int[size]; //small random range
	    int[] vier = new int[size]; //large random range
	    int[] funf = new int[size]; //Arrays.sort

	    Random r = new Random();

	    for (int i=0; i<eins.length; i++){
		eins[i]=i;
	    }
	    
	    for (int i=0; i<zwei.length; i++){
		zwei[i]=zwei.length-i;
	    }
	    
	    for (int i=0; i<drei.length; i++){
		drei[i]=r.nextInt(3)+1;
	    }
	    
	    for (int i=0; i<vier.length; i++){
		vier[i]=r.nextInt((1000000+1000000) + 1)-1000000;
	    }
	   
	    System.out.println("sorted:");
	    System.arraycopy(eins, 0, funf, 0, size);
	    long start = System.currentTimeMillis();
	    Sorts.mergesort(eins);
	    long end = System.currentTimeMillis();
	    System.out.println(end-start);
	    
	    start = System.currentTimeMillis();
	    Arrays.sort(funf);
	    end = System.currentTimeMillis();
	    System.out.println(end-start);
	    
	    System.out.println(arrayEquals(eins,funf));
	    
	    
	    System.out.println("\nreverse sorted:");
	    System.arraycopy(zwei, 0, funf, 0, size);
	    start = System.currentTimeMillis();
	    Sorts.mergesort(zwei);
	    end = System.currentTimeMillis();
	    System.out.println(end-start);
	    
	    start = System.currentTimeMillis();
	    Arrays.sort(funf);
	    end = System.currentTimeMillis();
	    System.out.println(end-start);
	    
	    System.out.println(arrayEquals(zwei,funf));


	    System.out.println("\nsmall random range:");
	    System.arraycopy(drei, 0, funf, 0, size);
	    start = System.currentTimeMillis();
	    Sorts.mergesort(drei);
	    end = System.currentTimeMillis();
	    System.out.println(end-start);
	    
	    start = System.currentTimeMillis();
	    Arrays.sort(funf);
	    end = System.currentTimeMillis();
	    System.out.println(end-start);
	    
	    System.out.println(arrayEquals(drei,funf));

	    
	    System.out.println("\nlarge random range:");
	    System.arraycopy(vier, 0, funf, 0, size);
	    start = System.currentTimeMillis();
	    Sorts.mergesort(vier);
	    end = System.currentTimeMillis();
	    System.out.println(end-start);
	    
	    start = System.currentTimeMillis();
	    Arrays.sort(funf);
	    end = System.currentTimeMillis();
	    System.out.println(end-start);
	    
	    System.out.println(arrayEquals(vier,funf));
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
