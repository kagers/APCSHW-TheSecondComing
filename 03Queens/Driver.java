public class Driver{
    public static void main(String[]args){
	NQueens n;
	int size;
	try{
	    size = Integer.parseInt(args[0]);
	} catch (Exception e){
	    size = 4;
	}
	n = new NQueens(size);
	//System.out.println(n.check(1,1,-1,-1));
	System.out.println(n.solve());
	System.out.println(n);
    }
}
