public class RunningMedian{

    private MyHeap min;
    private MyHeap max;

    public RunningMedian(){
	min = new MyHeap(false);
	max = new myheap(true);
    }

    public double getMedian(){
	if (min.size()<1 && max.size()<1){
	    throw new NoSuchElementException();
	} else if (min.size()<max.size()){
	    return max.peek();
	} else if (min.size()>max.size()){
	    return min.peek();
	} else{
	    return (max.peek()+min.peek())/2;
	}
    }

    public void add(int value){
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
    }

}
