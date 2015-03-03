import java.util.*;
import java.io.*;

public class ctravel{
    
    private int sec = 0;
    private char[][] field;
    private int[][] paths;
    private int[][] paths2;
    private int[] three = new int[4];

    public ctravel() throws IOException{
	Scanner s = new Scanner(new BufferedReader(new FileReader("ctravel.in")));
	field = new char[Integer.parseInt(s.next())][Integer.parseInt(s.next())];
	sec = Integer.parseInt(s.next());
	for (int i=0; i<field.length; i++){
	    String str = s.next();
	    //System.out.println(str);
	    //System.out.println(s.next());
	    for(int j=0; j<field[0].length; j++){
		field[i][j] = str.charAt(j);
	    }
	}
	paths = new int[field.length][field[0].length];
	for (int i=0; i<field.length; i++){
	    for (int j=0; j<field[0].length; j++){
		if (field[i][j]=='*'){
		    paths[i][j]=-1;
		}
	    }
	}
	paths2 = new int[paths.length][paths[0].length];
	copy(paths,paths2);
	for (int i=0; i<4; i++){
	    three[i] = Integer.parseInt(s.next());
	}
	s.close();
	System.out.println(sec);
	System.out.println(Arrays.toString(three));
	System.out.println(Arrays.deepToString(field));
    }

    public int solve(){
	return solve(three[0]-1,three[1]-1,0);
    }

    public int solve(int row, int col, int s){
	if (row < 0 || row >= field.length || col < 0 || col >= field[0].length){
	    return 0;
	}
	if (s == this.sec && (row != three[2]-1 || col != three[3]-1)){
	    return 0;
	}
	if (s == this.sec && row == three[2]-1 && col == three[3]-1){
	    return 1;
	}
	if (field[row][col] == '*'){
	    return 0;
	}
	return solve(row+1,col,s+1) + solve(row-1,col,s+1) + solve(row,col+1,s+1) + solve(row,col-1,s+1);
	
    }

    /*public int solve(){
	paths2[three[0]-1][three[1]-1] = 1;
	for (int seconds=0; seconds<this.sec; seconds++){
	    //System.out.println(this);
	    for (int i=0; i<paths.length; i++){
		for (int j=0; j<paths[i].length; j++){
		    if (paths[i][j]!=-1 && paths[i][j]!=0){
			add(i,j);
			if (seconds==0){
			    paths2[three[0]-1][three[1]-1] = 0;
			}
			//System.out.println(i+" "+j);
			//System.out.println(paths+" "+paths2);
		    }
		}
	    }
	    //System.out.println(this);
	    copy(paths2,paths);
	}
	return paths[three[2]-1][three[3]-1];
    }

    public void add(int i, int j){
	int[] a = {1,-1,0,0};
	int[] b = {0,0,1,-1};
	for (int k=0; k<a.length; k++){
	    //System.out.println((i+a[k])+" "+(j+b[k]));
	    if (i+a[k]>=0 &&
		j+b[k]>=0 &&
		i+a[k]<paths.length &&
		j+b[k]<paths[0].length &&
		paths[i+a[k]][j+b[k]]!=-1){
		//System.out.println((i+a[k])+" "+(j+b[k]));
		System.out.println(paths2[i][j]);
		paths2[i+a[k]][j+b[k]]+=paths2[i][j];
		//if (i==three[0]-1 && j==three[1]-1){
		//    paths2[i][j]=0;
		//}
	    }
	}
    }

    public String toString(){
	String ret = "";
	/*for (int i=0; i<paths.length; i++){
	    for (int j=0; j<paths[0].length; j++){
		ret+=paths[i][j]+"\t";
	    }
	    ret+="\n";
	}
	ret+="\n";
	for (int i=0; i<paths2.length; i++){
	    for (int j=0; j<paths2[0].length; j++){
		ret+=paths2[i][j]+"\t";
	    }
	    ret+="\n";
	}
	return ret;
	}*/

    public static void copy(int[][] a, int[][] b){
	for (int i=0; i<a.length; i++){
	    for (int j=0; j<a[i].length; j++){
		b[i][j]=a[i][j];
	    }
	}
    }

    public static void main(String[] args){
	try{
	    ctravel screwthis = new ctravel();
	    System.out.println(screwthis.solve());
	    //System.out.println(screwthis);
	    
	    PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("ctravel.out")));
	    // p.println(screwthis.solve());
	    p.close();
	} catch (IOException e){

	}
    }

}
