public class Driver{

    public static void main(String[] args){
	
	MyLinkedList zelda = new MyLinkedList();
	
	System.out.println(zelda);
	System.out.println(" "+zelda.size());
	zelda.add(1);
	System.out.println(zelda);
	System.out.println(" "+zelda.size());
	zelda.add(3);
	System.out.println(zelda);
	System.out.println(" "+zelda.size());
	zelda.add(1,2);
	System.out.println(zelda);
	System.out.println(" "+zelda.size());
	zelda.add(0,0);
	System.out.println(zelda);
	System.out.println(" "+zelda.size());
	zelda.add(4,6);
	System.out.println(zelda);
	System.out.println(" "+zelda.size());
	zelda.add(4,4);
	System.out.println(zelda);
	System.out.println(" "+zelda.size());
	
    	System.out.println();
	System.out.println(zelda.get(0));
	System.out.println(zelda.get(1));
	System.out.println(zelda.get(2));
	System.out.println(zelda.get(3));
	System.out.println(zelda.get(4));
	System.out.println(zelda.get(5));
	System.out.println(zelda.set(5,5));
	System.out.println(zelda.set(0,0));
	System.out.println(zelda);

	System.out.println();
	System.out.println(zelda);
	System.out.println(zelda.indexOf(5));
	System.out.println(zelda.indexOf(8));
	

	System.out.println();
	System.out.println(zelda.remove(1));
	System.out.println(zelda);
	System.out.println(zelda.remove(4));
	System.out.println(zelda);
	System.out.println(zelda.remove(3));
	System.out.println(zelda);
	System.out.println(zelda.remove(2));
	System.out.println(zelda);
	System.out.println(zelda.remove(0));
	System.out.println(zelda);
	System.out.println(zelda.remove(0));
	System.out.println(zelda);
	//System.out.println(zelda.remove(1));
	//System.out.println(zelda);

    }

}
