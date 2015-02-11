import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private int[][]board;
    
    
    //terminal specific character to move the cursor
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
	//build your knights tour here...
	return hide + go(0,0) + ans + "\n" + show;
    }
    
    public KnightsTour(int size){
	board = new int[size][size];
    }
    
    public void solve(){
	solve(0,0);
    }

    public void solve(int startx, int starty){
	solve(startx, starty, 0);
    }
    
    
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	
	if (x>=size || x<0 || y>=size || y<0){
	    return false;
	}
	if (){
	    return true;
	}
	if (board[y][x]==-1){
	    board[y][x]=currentMoveNumber;
	    return (solve(x+2,y+1,currentMoveNumber+1) ||
		    solve(x+2,y-1,currentMoveNumber+1) ||
		    solve(x-2,y+1,currentMoveNumber+1) ||
		    solve(x-2,y-1,currentMoveNumber+1) ||
		    solve(x+1,y+2,currentMoveNumber+1) ||
		    solve(x+1,y-2,currentMoveNumber+1) ||
		    solve(x-1,y+2,currentMoveNumber+1) ||
		    solve(x-1,y-2,currentMoveNumber+1));
	}

	return false;
    }
    

}