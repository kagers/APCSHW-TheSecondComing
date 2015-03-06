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

    public static void main(String[] args){
	int [] a  = {16,8,7,5,3,2,10,41,1,13,91};
	Quick.partition(a,0,a.length-1);
	System.out.println();
	Quick.partition(a,1,4);
    }

}




