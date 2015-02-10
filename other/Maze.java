import java.util.*;

public class Maze{
    public static char[][] solveM(char[][] maze){
	int x=0;
	int y=0;
	for (int i=0; i<maze.length; i++){
	    for (int j=0; j<maze[i].length; j++){
		if (maze[i][j]=='S'){
		    x=j;
		    y=i;
		}
	    }
	}
	return solver(Arrays.copyOf(maze,maze.length), x, y);
    }
    public static char[][] solver(char[][] maze, int x, int y){
	if (maze[y][x] == 'E'){
	    maze[y][x] = '@';
	} else if (maze[y][x]=='S' || maze[y][x]==' '){
	    if (isHere(maze,'@')){
		maze[y][x]='@';
	    } else {
		maze[y][x]='.';
		if (isHere(solver(maze,x,y+1),'@') ||
		    isHere(solver(maze,x,y-1),'@') ||
		    isHere(solver(maze,x+1,y),'@') ||
		    isHere(solver(maze,x-1,y),'@')){
		    maze[y][x]='@';
		}
	    }
	}
	return maze;
    }
    public static boolean isHere(char[][] array, char target){
	for (int i=0; i<array.length; i++){
	    for (int j=0; j<array[i].length; j++){
		if (array[i][j]==target){
		    return true;
		}
	    }
	}
	return false;
    }
    public static void print(char[][] array){
	for (int i=0; i<array.length; i++){
	    System.out.println(Arrays.toString(array[i]));
	}
    }
    public static void main(String[] args){
	char[][] lab = {{'X','X','X','X','X','X'},
			{'X','S','X',' ',' ','X'},
			{'X',' ','X','X',' ','X'},
			{'X',' ',' ',' ',' ','X'},
			{'X',' ','X','X',' ','X'},
			{'X',' ','X','E',' ','X'},
			{'X','X','X','X','X','X'}};
        print(lab);
	System.out.println();
	print(solveM(lab));
	System.out.println();
	char[][] laby = {{'X','X','X','X','X','X'},
			 {'X','S','X',' ','X','X'},
			 {'X',' ','X','X',' ','X'},
			 {'X',' ',' ',' ',' ','X'},
			 {'X','X','X','X',' ','X'},
			 {'X','E',' ',' ',' ','X'},
			 {'X','X','X','X','X','X'}};
        print(laby);
	System.out.println();
	print(solveM(laby));
	System.out.println();		    
    }
}
