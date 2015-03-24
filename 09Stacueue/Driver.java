public class Driver{

    public static void main(String[] args){
	
	if (args.length == 0){

	    MyStack<Integer> s = new MyStack<Integer>();
	    
	    System.out.println(s.empty());
	    System.out.println(s.push(5));
	    System.out.println(s.push(4));
	    System.out.println(s.push(3));
	    System.out.println(s.push(2));
	    System.out.println(s.push(1));
	    System.out.println(s.push(0));
	    
	    System.out.println(s.empty());
	    System.out.println(s.peek());
	    System.out.println(s.pop());
	    System.out.println(s.peek());
	    System.out.println(s.pop());
	    System.out.println(s.peek());
	    System.out.println(s.pop());
	    System.out.println(s.peek());
	    System.out.println(s.pop());
	    System.out.println(s.peek());
	    System.out.println(s.pop());
	    System.out.println(s.peek());
	    System.out.println(s.pop());
	    
	    System.out.println(s.empty());
	    
	    //s.pop();

	} else{
	    
	    MyQueue<Integer> q = new MyQueue<Integer>();
	    
	    System.out.println(q.empty());
	    System.out.println(q.enqueue(5));
	    System.out.println(q.enqueue(4));
	    System.out.println(q.enqueue(3));
	    System.out.println(q.enqueue(2));
	    System.out.println(q.enqueue(1));
	    System.out.println(q.enqueue(0));
	    
	    System.out.println(q.empty());
	    System.out.println(q.dequeue());
	    System.out.println(q.dequeue());
	    System.out.println(q.dequeue());
	    System.out.println(q.dequeue());
	    System.out.println(q.dequeue());
	    System.out.println(q.dequeue());
	    
	    System.out.println(q.empty());
		
	}
	
    }
    
}
