public class Driver{

    public static void main(String[]args){
	KnightsTour k;
	int size;
	try{
	    size = Integer.parseInt(args[0]);
	} catch (Exception e){
	    size = 4;
	}
	k = new KnightsTour(size);
	System.out.println(k.solve());
	System.out.println(k);
    }

}
