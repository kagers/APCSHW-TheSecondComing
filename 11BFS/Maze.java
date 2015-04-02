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
	return hide()+invert()+go(0,0)+ans+"\n"+show();
    }
    
    public boolean solve(){
	Coordinate start = new Coordinate(0,0);
	LNode<Coordinate> s = new LNode(start);
	for (int i=0; i<maze.length; i++){
	    for (int j=0; j<maze[0].length){
		if (maze[i][j]=='S'){
		    start.setX(j);
		    start.setY(i);
		}
	    }
	}
        deck.addFirst(start);
	LNode<Coordinate> ampere = s;
	Coordinate temp = new Coordinate();;
	while (deck.size()>0){
	    temp = deck.remove();
	    if (maze[temp.getY()][temp.getX()]=='.'){
		maze[temp.getY()][temp.getX()]='@';
		deck.add(new Coordinate(temp.getX()+1,temp.getY()));
		deck.add(new Coordinate(temp.getX()-1,temp.getY()));
		deck.add(new Coordinate(temp.getX(),temp.getY()+1));
		deck.add(new Coordinate(temp.getX(),temp.getY()-1));
	    } else if (maze[temp.getY()][temp.getX()]=='#'||
		       maze[temp.getY()][temp.getX()]=='@'){
		deck.removeLast();
	    } else if (maze[temp.getY()][temp.getX()]=='E'){
		break;
	    }
	}
       
    }

    public boolean solveDFS(){
	deck = new Frontier<Coordinate>(true);
	solve();
    }

    public boolean solveBFS(){
	deck = new Frontier<Coordinate>(false);
	solve();
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
	private MyDeque<T> = new MyDeque<T>();
	private boolean stck;

	public Frontier(boolean stack){
	    stck = stack;
	}
	public void add(T value){
	    addFirst();
	}
	public T remove(){
	    if (stack){
		removeFirst();
	    } else{
		removeLast();
	    }
	}
	public String toString(){
	    return "";
	}
    }

}
