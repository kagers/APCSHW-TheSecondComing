import java.util.*;

public class Quick{
    
    public static void partition(int[] ary, int si, int ei){
	System.out.println(Arrays.toString(ary));
	int[] D = new int[ary.length];
	for (int i=ei+1;i<D.length;i++){
	    D[i]=ary[i];
	}
	for (int i=0;i<si;i++){
	    D[i]=ary[i];
	}
	System.out.println(Arrays.toString(D));
	int pivot = ary[si];
	System.out.println(pivot);
	int ie = ei;
	for (int i=0; i<ie+1; i++){
	    if (ary[i]<pivot && ary[i]!=pivot){
		D[si++]=ary[i];
	    } else if (ary[i]!=pivot){
		D[ei--]=ary[i];
	    }
	}
	D[si]=pivot;
	System.out.println(Arrays.toString(D));
    }

    public static int quickselect(int[] ary, int n){
	return partition(ary,n,0,ary.length-1);
    }

    public static int partition(int[] ary, int n, int si, int ei){
	int[] D = new int[ary.length];
	for (int i=0;i<D.length;i++){
	    if (i<si || i>ei){
		D[i]=ary[i];
	    }
	}
	Random ayn = new Random();
	int pi = ayn.nextInt(ei-si+1)+si;
	int ie = ei;
	int is = si;
	for (int i=si; i<=ie; i++){
	    if (ary[i]<ary[pi]){
		D[si++]=ary[i];
	    } else if (ary[i]!=ary[pi]){
		D[ei--]=ary[i];
	    }
	}
	D[si]=ary[pi];
	if (n<ei){
	    return partition(D,n,is,si);
	} else if (n>ei){
	    return partition(D,n,ei,ie);
	} else{
	    return D[ei];
	}
	
    }

    public static int ipquickselect(int[] ary, int n){
	return ippartition(ary,n,0,ary.length-1);
    }

    public static int ippartition(int[] ary, int n, int si, int ei){
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
	if (n<ei){
	    return ippartition(ary,n,is,si);
	} else if (n>ei){
	    return ippartition(ary,n,ei,ie);
	} else{
	    return ary[ei];
	}
    }
    
    public static void randomize(int[] ary){
	Random rand = new Random();
        for (int i=0;i<ary.length;i++){
	    int bi = rand.nextInt(ary.length);
	    int hi = ary[i];
	    ary[i] = ary[bi];
	    ary[bi] = hi;
	}
    }

    public static void main(String[] args){
	int[] a = {16,8,7,5,3,2,10,41,1,13,91};
	int[] b = {0,1,55,3,4,5,6,7,8,9,10};
	Quick.randomize(b);
	System.out.println(Arrays.toString(b));
	/*Quick.ippartition(a,0,a.length-1);
	System.out.println();
	Quick.ippartition(a,1,4);
	*/try{
	    System.out.println(Quick.quickselect(b,Integer.parseInt(args[0])));
	    System.out.println(Quick.ipquickselect(b,Integer.parseInt(args[0])));
	} catch(Exception e){
	    System.out.println(Quick.quickselect(b,2));
	    System.out.println(Quick.ipquickselect(b,2));
	}
    }

}




