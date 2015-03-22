import java.util.*;

public class Sorts{

    public static String name(){
	return "gershfeld.katherine";
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

    public static void quickSort(int[] ary){
	quicksorth(ary,0,ary.length-1);
    }

    public static void quicksorth(int[] ary, int si, int ei){
	if (ei-si>0){
	    //System.out.println(Arrays.toString(ary));
	    //System.out.println(si+" "+ei);
	    Random ayn = new Random();
	    int pivot = ary[ayn.nextInt(ei-si+1)+si];
	    int ie = ei;
	    int is = si;
	    while (si<ei){
		if (ary[si]>pivot){
		    int hi = ary[si];
		    ary[si] = ary[ei];
		    ary[ei] = hi;
		    ei--;
		} else if (ary[si]<pivot){
		    si++;
		} else{
		    ary[si]=ary[ei];
		    ary[ei]=pivot;
		}
	    }
	    quicksorth(ary,is,si-1);
	    quicksorth(ary,ei+1,ie);
	}
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
    }

    public static void switcheroo(int[] ary, int ai, int bi){
	int hi = ary[ai];
	ary[ai] = ary[bi];
	ary[bi] = hi;
    }

    public static void main(String[] args){
	int[] a = {16,8,7,5,3,2,10,41,1,13,91};
	int[] b = {20,1,2,4,3,5,6,7,8,9,10};
	//int[] c = {0,0,0,0};
	//int[] d = {5,6,3,-1,14,6,2,7,15,6,4};

	Sorts.randomize(b,Integer.parseInt(args[0]));
	System.out.println(Arrays.toString(b));
	/*Quick.ippartition(a,0,a.length-1);
	System.out.println();
	Quick.ippartition(a,1,4);
	try{
	    System.out.println(Quick.badquickselect(b,Integer.parseInt(args[0])));
	    System.out.println(Quick.quickselect(b,Integer.parseInt(args[0])));
	} catch(Exception e){
	    System.out.println(Quick.badquickselect(b,2));
	    System.out.println(Quick.quickselect(b,2));
	}
	*/
	Sorts.quickSort(b);
	System.out.println(Arrays.toString(b));
    }

}




