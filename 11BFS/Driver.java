public class Driver{
    
    public static void main(String[]args){
	Maze f;
	if(args.length < 1){
	    f = new Maze("data1.dat");
	}else{
	    f = new Maze(args[0]);
	}
	f.clearTerminal();
	if (args.length > 2){
	    f.solveDFS(true);
	} else {
	    f.solveBFS(true);
	}
    }

}
