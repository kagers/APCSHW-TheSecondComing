public class NQueens{

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    private boolean[][] board;
    
    public NQueens(int size){
	board = new boolean[size][size];
    }

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	for (int i=0; i<board.length; i++){
	    for (int j=0; j<board[i].length; j++){
		ans+=board[i][j]+"\t";
	    }
	    ans+="\n\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public String name(){
	return "gershfeld.katherine";
    }

    public boolean solve(){
	return solve(0,1);
    }

    public boolean solve(int x){
	return solve(x,1);
    }

    private boolean solve(int x, int y){
	return false;
    }

    private boolean checkCol(int x){
	return false;
    }

    private boolean checkDia(int x, int y){
	return false;
    }

}
