public class Recursion{
    public String name(){
	return "Gershfeld,Katherine";
    }
    public int fact(int n){
	if (n<0){
	    throw new IllegalArgumentException("Can't exclaim your argument!!!!!");
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
	    throw new IllegalArgumentException("Domain Error");
	} else if (n==0){
	    return b;
	} else {
	    return (fibit(a+b,a,n-1));
	}
    }
    //public double sqrt(double n);
    public static void main(String[]args){
	Recursion cur = new Recursion();
	System.out.println(cur.fact(4));
	System.out.println(cur.fib(9));
    }
}
