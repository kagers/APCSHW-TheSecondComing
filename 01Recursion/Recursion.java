public class Recursion implements hw1{
    public String name(){
	return "Gershfeld,Katherine";
    }
    public int fact(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	} else if (n==0){
	    return 1;
	} else {
	    return (n*(fact(n-1)));
	}
    }
    public int fib(int n){
	return (fibit(1,0,n));
    }
    public int fibit(int a, int b, int n){
	if (n<0){
	    throw new IllegalArgumentException();
	} else if (n==0){
	    return b;
	} else {
	    return (fibit(a+b,a,n-1));
	}
    }
    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	} else if (n==0){
	    return 0;
	} else {
	    return squirt(n,1);
	}
    }
    public double squirt(double n, double g){
	if (Math.abs(g*g-n) <= 0.00001){
	    return g;
	} else {
	    return squirt(n,(g+(n/g))/2);
	}
    }
    public static void main(String[]args){
	Recursion cur = new Recursion();
	System.out.println(cur.fact(0));
	System.out.println(cur.fact(1));
	System.out.println(cur.fact(5));
	try{
	    System.out.println(cur.fact(-1));
	} catch (IllegalArgumentException t){
	    System.out.println(cur.fib(0));
	    System.out.println(cur.fib(2));
	    System.out.println(cur.fib(5));
	    System.out.println(cur.fib(10));
	    try{
	    System.out.println(cur.fib(-1));
	    } catch (IllegalArgumentException r){
		System.out.println(cur.sqrt(169.0));
		System.out.println(cur.sqrt(1.0));
		System.out.println(cur.sqrt(1.0E-8));
		System.out.println(cur.sqrt(0.0));
		try {
		System.out.println(cur.sqrt(-100));
		} catch (IllegalArgumentException e){

		}
	    }
	}
    }
}
