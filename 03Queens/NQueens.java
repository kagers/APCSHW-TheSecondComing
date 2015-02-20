public class NQueens{

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    private char[][] board;
    
    public NQueens(int size){
	board = new char[size][size];
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
	    if (solve(0,i)){
		return true;
	    }
	}
	return false;
    }

    public boolean solve(int x){
	return solve(x,0);
    }

    private boolean solve(int x, int y){
	System.out.println(this);
	wait(500);
	//System.out.println(x+" "+y);
	if (y == board.length){
	    return true;
	} else if (x<0 || y<0 || x>=board.length){
	    //System.out.println("a");
	    return false;
	} else {
	    //System.out.println("b");
	    board[y][x] = 'Q';
	    //System.out.println(this);
	    if (check(x,y,0,1) &&
		check(x,y,1,0) &&
		check(x,y,1,1) &&
		check(x,y,0,-1) &&
		check(x,y,-1,0) &&
		check(x,y,1,-1) &&
		check(x,y,-1,1) &&
		check(x,y,-1,-1)){
		for (int i=0; i<board[0].length; i++){
		//System.out.println("c");
		    if (solve(i,y+1)){
			return true;
		    }
		}
		return false;
	    } else {
		//System.out.println("d");
		board[y][x] = '_';
		return false;//solve(x+1,y);
	    }
	}
    }

    /*private boolean checkCol(int x){
	int q = 0;
	for (int i=0; i<board.length; i++){
	    if (board[i][x] == 'Q'){
	        q++;
	    }
	} 
	return q<=1;
    }

    private boolean checkRow(int y){
	int q = 0;
	for (int i=0; i<board.length; i++){
	    if (board[y][i] == 'Q'){
		q++;
	    }
	} 
	return q<=1;
    }*/

    public boolean check(int x, int y, int h, int v){
	/*board = new char[3][3];
	board[0][0] = 'Q';
	board[0][1] = '-';
	board[0][2] = '-';
	board[1][0] = '-';
	board[1][1] = 'Q';
	board[1][2] = '-';
	board[2][0] = '-';
	board[2][1] = '-';
	board[2][2] = 'Q';*/
	int q = 0;
	while (x<board.length-1 && y<board.length-1 && (x>0 || h==0) && (y>0 || v==0)){
	    //System.out.println(x+" 1 "+y);
	    x-=h;
	    y-=v;
	}
	//System.out.println(x+" "+y);
	//System.out.println(x>=0 && y>=0);
	while (x<board.length && y<board.length && x>=0 && y>=0){
	    //System.out.println(x+" 2 "+y);
	    if (board[y][x] == 'Q'){
		q++;
	    }
	    x+=h;
	    y+=v;
	}
	//System.out.println(q);
	return q<=1;
    }

}
