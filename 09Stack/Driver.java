public class Driver{

    public static void main(String[] args){
	
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
	
	s.pop();

    }

}
