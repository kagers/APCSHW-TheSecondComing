import java.util.*;

public class Driver{

    public static void main(String[]args){
	Maze f;
	if(args.length < 1){
	    f = new Maze("data1.dat");
	}else{
	    f = new Maze(args[0]);
	}
	//f.clearTerminal();
	if (args.length > 2){
	    if (args[1].equals("0")){
	        f.solveDFS(true);
	    } else if (args[2].equals("1")){
	        f.solveBFS(true);
	    } else if (args[2].equals("2")){
		f.solveDFS(false);
	    } else{
		f.solveBFS(false);
	    }
	}
	System.out.println(Arrays.toString(f.solutionCoordinates()));
    }

}
