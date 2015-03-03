import java.util.*;
import java.io.*;

public class makelake{
    
    public static int lake(int d, int[][] two, int[][] three){
	//two = directions(two, three);
	//System.out.println("hello !");
	//two = directions(two, four);
	for (int i=0; i<three.length; i++){
	    two = directions(two, three[i]);
	}
	int depth = d;
	int adepth = 0;
	for (int i = 0; i < two.length; i++){
	    for (int j = 0; j < two[i].length; j++){
		if (two[i][j] < depth){
		    two[i][j] = depth - two[i][j];
		}else{
		    two[i][j] = 0;
		}
		adepth += two[i][j];
	    }
	}
	return adepth*72*72;
    }

    public static int[] findMax(int[][] array, int startRow, int startCol, int endRow, int endCol){
	int max = array[startRow][startCol];
	int[] index = new int[2];
	for (int i = startRow; i < endRow; i++){
	    for (int j = startCol; j < endCol; j++){
		if (array[i][j] >= max){
		    max = array[i][j];
		    index[0] = i;
		    index[1] = j;
		}
	    }
	}
	return index;
    }

    public static int[][] directions(int[][] map, int[] instructions){
	int startRow = instructions[0] - 1;
	int startCol = instructions[1] - 1;
	int[] index = findMax(map, startRow, startCol, startRow + 3, startCol + 3);
	int ans = map[index[0]][index[1]] - instructions[2];
	for (int i = startRow; i < startRow + 3; i++){
	    for (int j = startCol; j < startCol + 3; j++){
		if (map[i][j] > ans){
		    map[i][j] = ans;
		}
	    }
	}
	return map;
	
    }

    public static String printA(int[][] map){
	String ans = "{";
	for (int i = 0; i < map.length; i++){
	    ans += "{";
	    for (int j = 0; j < map[i].length; j++){
		ans += map[i][j] + ",";
	    }
	    ans += "}\n";
	}
	ans += "}";
	return ans;
    }

    public static void main(String[]args) throws IOException{
	/*int[][] map = new int[][]{
	    {28,25,20,32,34,36},
	    {27,25,20,20,30,34},
	    {24,20,20,20,20,30},
	    {20,20,14,14,20,20}
	};
	int[] one = {4,6,22,2};
	int[] three = {1,4,4};
	int[] four = {1,1,10};*/

	
	PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("makelake.out")));

	Scanner s = new Scanner(new BufferedReader(new FileReader("makelake.in")));
	int[][] pasture = new int[Integer.parseInt(s.next())][Integer.parseInt(s.next())];
	int d = Integer.parseInt(s.next());
	int[][] instructions = new int[Integer.parseInt(s.next())][3];
	for(int i = 0; i < pasture.length; i++){
	    for(int j = 0; j < pasture[0].length; j++){
		pasture[i][j] = Integer.parseInt(s.next());
	    }
	}
	for(int i = 0; i < instructions.length; i++){
	    for(int j = 0; j < instructions[0].length; j++){
		instructions[i][j] = Integer.parseInt(s.next());
	    }
	}
	p.println(lake(d,pasture,instructions));
	p.close();
	s.close();
    }
}
