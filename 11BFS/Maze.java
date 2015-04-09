import java.util.*;
import java.io.*;

public class Maze{
    
    private char[][] maze;
    private int maxx,maxy;
    private int startx,starty;
    private Frontier<Coordinate> deck;

    private static final int DFS = 1;
    private static final int BFS = 0;	

    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }
    
    private String go(int x,int y){
	return ("["+x+";"+y+"H");
    }
    
    private String clear(){
	return  "[2J";
    }
    
    private String hide(){
	return  "[?25l";
    }
    
    private String show(){
	return  "[?25h";
    }

    private String invert(){
	return  "[37";
    }

    public void clearTerminal(){
	System.out.println(clear());
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public String toString(){
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	//return ans;
	return hide()+invert()+go(0,0)+ans+"\n"+show();
    }
    
    public boolean solve(){
	//System.out.println(this);
	wait(100);
	Coordinate start = new Coordinate(0,0);
	//LNode<Coordinate> s = new LNode(start);
	for (int i=0; i<maze.length; i++){
	    for (int j=0; j<maze[0].length; j++){
		if (maze[i][j]=='S'){
		    start.setX(j);
		    start.setY(i);
		}
	    }
	}
	//System.out.println(deck);
        deck.add(start);
	//System.out.println(deck);
	//LNode<Coordinate> ampere = s;
	Coordinate temp = new Coordinate(0,0);
	System.out.println(deck);
	while (deck.size()>0){
	    System.out.println(this);
	    wait(100);
	    temp = deck.remove();
	    //System.out.println(deck);
	    //System.out.println(temp);
	    //System.out.println(maze[temp.getY()][temp.getX()]);
	    if (maze[temp.getY()][temp.getX()]==' ' ||
		maze[temp.getY()][temp.getX()]=='S'){
		maze[temp.getY()][temp.getX()]='@';
		deck.add(new Coordinate(temp.getX()+1,temp.getY()));
		deck.add(new Coordinate(temp.getX()-1,temp.getY()));
		deck.add(new Coordinate(temp.getX(),temp.getY()+1));
		deck.add(new Coordinate(temp.getX(),temp.getY()-1));
	    } else if (maze[temp.getY()][temp.getX()]=='#'||
		       maze[temp.getY()][temp.getX()]=='@'){
		//deck.remove();
	    } else if (maze[temp.getY()][temp.getX()]=='E'){
		break;
	    }
	    //System.out.println(deck+"L");
	}
	return true;
    }

    public boolean solveDFS(){
	deck = new Frontier<Coordinate>(true);
	return solve();
    }

    public boolean solveBFS(){
	deck = new Frontier<Coordinate>(false);
	return solve();
    }
    
    public class Coordinate{
	private int x;
	private int y;

	public Coordinate(int xx,int yy){
	    x=xx;
	    y=yy;
	}

	public String toString(){
	    return "("+x+","+y+")";
	}
	public void setX(int xx){
	    x=xx;
	}
	public void setY(int yy){
	    y=yy;
	}
	public int getX(){
	    return x;
	}
	public int getY(){
	    return y;
	}

    }

    public class Frontier<T>{
	private MyDeque<T> dq = new MyDeque<T>();
	private boolean stck;

	public Frontier(boolean stack){
	    stck = stack;
	}
	public void add(T value){
	    dq.addFirst(value);
	}
	public T remove(){
	    if (stck){
		return dq.removeFirst();
	    } else{
		return dq.removeLast();
	    }
	}
	public int size(){
	    return dq.size();
	}
	public String toString(){
	    return dq.toString();
	}

    }
    
}
