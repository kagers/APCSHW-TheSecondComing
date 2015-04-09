import java.util.*;
import java.io.*;

public class Maze{
    
    private char[][] maze;
    private int maxx,maxy;
    private int startx,starty;
    private LNode<Coordinate> s;
    private Frontier<Coordinate> deck;

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";	

    /** Same constructor as before...*/
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
	s = new LNode<Coordinate>();
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

    private String go(int x, int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    private String invert(){
	return  "[37";
    }

    public void clearTerminal(){
	System.out.println(clear);
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public String toString(){
	//do not do the funky character codes, this is used for non-animated printing,
	//it is just the string representation of the maze (before or after solving).
	//String ans = ""+maxx+","+maxy+"\n";
	String ans = "";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return ans;
    }

    public String toString(boolean animate){
	//do the funky character codes when animate is true
	//this to string will be used in your animate, it would include the go(0,0) character, 
	//as well as the clear/hide/show characters as you need to use them.
	if (animate){
	    return hide+go(0,0)+toString()+"\n"+show;
	}
	return toString();
    }
    
    public boolean solve(boolean animate){
	Coordinate start = new Coordinate(0,0);
	s = new LNode<Coordinate>(start);
	for (int i=0; i<maze.length; i++){
	    for (int j=0; j<maze[0].length; j++){
		if (maze[i][j]=='S'){
		    start.setX(j);
		    start.setY(i);
		}
	    }
	}
        deck.add(start);
	LNode<Coordinate> ampere = new LNode<Coordinate>();
	Coordinate temp = new Coordinate(0,0);
	while (deck.size()>0){
	    if (animate){
		System.out.println(toString(true));
		wait(1);
	    }
	    //System.out.println(deck);
	    temp = deck.remove();
	    ampere.setNext(new LNode<Coordinate>(temp));
	    //System.out.println(temp);
	    try{
		if (maze[temp.getY()][temp.getX()]==' ' ||
		    maze[temp.getY()][temp.getX()]=='S'){
		    maze[temp.getY()][temp.getX()]='x';
		    deck.add(new Coordinate(temp.getX()+1,temp.getY()));
		    deck.add(new Coordinate(temp.getX()-1,temp.getY()));
		    deck.add(new Coordinate(temp.getX(),temp.getY()+1));
		    deck.add(new Coordinate(temp.getX(),temp.getY()-1));
		} else if (maze[temp.getY()][temp.getX()]=='E'){
		    s = ampere;
		    return true;
		} else if (maze[temp.getY()][temp.getX()]=='x' ||
			   maze[temp.getY()][temp.getX()]=='#'){
		    ampere = ampere.getNext();
		}
	    } catch(NullPointerException e){

	    }
	}
	s = ampere;
	return false;
    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){
	deck = new Frontier<Coordinate>(true);
	return solve(animate);
    }

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){
	deck = new Frontier<Coordinate>(false);
	return solve(animate);
    }
    
    public boolean solveDFS(){
	return solveDFS(false);
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    /**return an array [x1,y1,x2,y2,x3,y3...]
      *that contains the coordinates of the solution from start to end.
      *Precondition :  solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
      *Postcondition:  the correct solution is in the returned array
      */
    public int[] solutionCoordinates(){
	System.out.println(s);
	while (s.getNext()!=null){
	    System.out.println(s.getData());
	    s=s.getNext();
	}
	return new int[0];
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
