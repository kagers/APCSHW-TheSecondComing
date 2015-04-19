import java.util.*;

public class Driver{

    public static void main(String[]args){
	Maze f;
	if(args.length < 1){
	    f = new Maze("data1.dat");
	}else{
	    f = new Maze(args[0]);
	}
	f.clearTerminal();
	if (args.length > 1){
	    if (args[1].equals("0")){
		System.out.println("r");
	        f.solveDFS(true);
	    } else if (args[1].equals("1")){
	        f.solveBFS(true);
	    } else if (args[1].equals("2")){
		f.solveDFS(false);
	    } else{
		f.solveBFS(false);
	    }
	}
	System.out.println(Arrays.toString(f.solutionCoordinates()));
    }

}
