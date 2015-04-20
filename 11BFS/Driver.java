import java.util.*;

public class Driver{

    public static void main(String[]args){
	Maze f;
	if(args.length < 1){
	    f = new Maze("data1.dat");
	}else{
	    f = new Maze(args[0]);
	}
	boolean b = true;
	f.clearTerminal();
	if (args.length > 1){
	    if (args[1].equals("0")){
	        f.solveDFS(b);
	    } else if (args[1].equals("1")){
	        f.solveBFS(b);
	    } else if (args[1].equals("2")){
		f.solveBest(b);
	    } else{
		f.solveAStar(b);
	    }
	}
	System.out.println(Arrays.toString(f.solutionCoordinates()));
    }

}
