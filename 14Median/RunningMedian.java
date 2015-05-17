import java.util.*;

public class RunningMedian{

    private MyHeap min;
    private MyHeap max;

    public RunningMedian(){
	min = new MyHeap(false);
	max = new MyHeap(true);
    }

    public double getMedian(){
	//System.out.println(max.size()+" "+min.size());
	if (min.size()<1 && max.size()<1){
	    throw new NoSuchElementException();
	} else if (min.size()<max.size()){
	    return max.peek();
	} else if (min.size()>max.size()){
	    return min.peek();
	} else{
	    return (max.peek()+min.peek())/2.0;
	}
    }

    public void add(int value){
	if (min.size()==0 && max.size()==0){
	    max.add(value);
	} else{
	    if (value>getMedian()){
		min.add(value);
	    } else if (value<getMedian()){
		max.add(value);
	    } else{
		if (min.size()>max.size()){
		    max.add(value);
		} else{
		    min.add(value);
		}
	    }
	    if (min.size()-max.size()>1){
		max.add(min.remove());
	    } else if (max.size()-min.size()>1){
		min.add(max.remove());
	    }
	}
    }

    public String toString(){
	return max+" "+min;
    }

    public static void main(String[] args){
	RunningMedian saigon = new RunningMedian();
	saigon.add(10);
	System.out.println(saigon.getMedian());
	System.out.println(saigon);
	saigon.add(5);
	System.out.println(saigon.getMedian());
	System.out.println(saigon);
	saigon.add(3);
	System.out.println(saigon.getMedian());	
	System.out.println(saigon);
	saigon.add(0);
	System.out.println(saigon.getMedian());	
	System.out.println(saigon);
	saigon.add(7);
	System.out.println(saigon.getMedian());	
	System.out.println(saigon);
	saigon.add(6);
	System.out.println(saigon.getMedian());	
	System.out.println(saigon);
	saigon.add(4);
	System.out.println(saigon.getMedian());	
	System.out.println(saigon);
	saigon.add(1);
	System.out.println(saigon.getMedian());	
	System.out.println(saigon);
	saigon.add(9);
	System.out.println(saigon.getMedian());	
	System.out.println(saigon);
	saigon.add(8);
	System.out.println(saigon.getMedian());	
	System.out.println(saigon);
	saigon.add(2);
	System.out.println(saigon.getMedian());	
	System.out.println(saigon);
    }

}
