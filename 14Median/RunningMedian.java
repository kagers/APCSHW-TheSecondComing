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
	} else if (min.size()<1){
	    return max.peek();
	} else if (max.size()<1){
	    return min.peek();
	} else{
	    return (max.peek()+min.peek())/2;
	}
    }

    public void add(int value){

    }

}