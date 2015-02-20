public class NQueens{

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    private char[][] board;
    
    public NQueens(int size){
	board = new char[size][size];
	reset();
    }

    private void reset(){
	for (int i=0; i<board.length; i++){
	    for (int j=0; j<board[i].length; j++){
		board[i][j] = '_';
	    }
	}
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
	for (int i=0; i<board.length; i++){
	    if (solve(i,0)){
		return true;
	    }
	}
	return false;
    }

    public boolean solve(int x){
	return solve(x,0);
    }

    private boolean solve(int x, int y){
	if (y == board.length){
	    return true;
	} else if (x<0 || y<0 || x>=board.length){
	    return false;
	} else {
	    board[y][x] = 'Q';
	    if (check(x,y,0,1) &&
		check(x,y,1,0) &&
		check(x,y,1,1) &&
		check(x,y,1,-1) &&
		check(x,y,0,-1) &&
		check(x,y,-1,0) &&
		check(x,y,-1,-1) &&
		check(x,y,-1,1)){
		for (int i=0; i<board[0].length; i++){
		    if (solve(i,y+1)){
			return true;
		    }
		}
		board[y][x] = '_';
		return false;
	    } else {
		board[y][x] = '_';
		return false;
	    }
	}
    }

    public boolean check(int x, int y, int h, int v){
	int q = 0;
	while (x<board.length-1 && y<board.length-1 && (x>0 || h==0) && (y>0 || v==0)){
	    x-=h;
	    y-=v;
	}
	while (x<board.length && y<board.length && x>=0 && y>=0){
	    if (board[y][x] == 'Q'){
		q++;
	    }
	    x+=h;
	    y+=v;
	}
	return q<=1;
    }

}
