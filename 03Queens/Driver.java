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
	try{
	    System.out.println(n.solve(Integer.parseInt(args[1])));
	} catch (Exception f){
	    System.out.println(n.solve());
	}
	System.out.println(n);
    }
}
