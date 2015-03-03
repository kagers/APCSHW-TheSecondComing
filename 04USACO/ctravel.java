import java.util.*;

public class ctravel{
    
    private int[] one = new int[3];
    private char[][] field;
    private int[][] paths;
    private int[][] paths2;
    private int[] three = new int[4];

    public ctravel(String filename){
	/*one[0] = 4;
	one[1] = 5;
	one[2] = 6;
	field = new char[][]{
	    {'.','.','.','*','.'},
	    {'.','.','.','*','.'},
	    {'.','.','.','.','.'},
	    {'.','.','.','.','.'}
	    };*/
	one[0] = 5;
	one[1] = 5;
	one[2] = 14;
	field = new char[][]{
	    {'.','.','.','.','*'},
	    {'.','.','.','.','.'},
	    {'.','.','*','.','.'},
	    {'.','.','.','.','.'},
	    {'*','.','.','.','.'}
	};
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
	//System.arraycopy(paths,0,paths2,0,paths.length);
	/*three[0] = 1;
	three[1] = 3;
	three[2] = 1;
	three[3] = 5;*/
	three[0] = 1;
	three[1] = 1;
	three[2] = 5;
	three[3] = 5;
    }

    public int solve(){
	paths2[three[0]-1][three[1]-1] = 1;
	for (int seconds=0; seconds<14; seconds++){
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
	*/for (int i=0; i<paths2.length; i++){
	    for (int j=0; j<paths2[0].length; j++){
		ret+=paths2[i][j]+"\t";
	    }
	    ret+="\n";
	}
	return ret;
    }

    public static void copy(int[][] a, int[][] b){
	for (int i=0; i<a.length; i++){
	    for (int j=0; j<a[i].length; j++){
		b[i][j]=a[i][j];
	    }
	}
    }

    public static void main(String[] args){
	ctravel screwthis = new ctravel("");
	System.out.println(screwthis.solve());
	//System.out.println(screwthis);
    }

}
