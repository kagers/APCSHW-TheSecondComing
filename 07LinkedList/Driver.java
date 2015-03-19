import java.util.*;

public class Driver{

    public static void main(String[] args){
	
	try{

	    if (Integer.parseInt(args[0]) == 0){

		MyLinkedList<Integer> zelda = new MyLinkedList<Integer>();
		ArrayList<Integer> link = new ArrayList<Integer>();
		
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add(1);
		link.add(1);
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add(3);
		link.add(3);
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add(1,2);
		link.add(1,2);
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add(0,0);
		link.add(0,0);
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add(4,6);
		link.add(4,6);
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add(4,4);
		link.add(4,4);
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
	
		System.out.println();
		System.out.println(zelda.get(0));
		System.out.println(link.get(0));
		System.out.println(zelda.get(1));
		System.out.println(link.get(1));
		System.out.println(zelda.get(2));
		System.out.println(link.get(2));
		System.out.println(zelda.get(3));
		System.out.println(link.get(3));
		System.out.println(zelda.get(4));
		System.out.println(link.get(4));
		System.out.println(zelda.get(5));
		System.out.println(link.get(5));
		System.out.println(zelda.set(5,5));
		System.out.println(link.set(5,5));
		System.out.println(zelda.set(0,0));
		System.out.println(link.set(0,0));
		System.out.println(zelda);
		System.out.println(link);
		
		System.out.println();
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(zelda.indexOf(5));
		System.out.println(link.indexOf(5));
		System.out.println(zelda.indexOf(8));
		System.out.println(link.indexOf(8));
		
		System.out.println();
		System.out.println(zelda.remove(1));
		System.out.println(link.remove(1));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		System.out.println(zelda.remove(4));
		System.out.println(link.remove(4));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		System.out.println(zelda.remove(3));
		System.out.println(link.remove(3));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		System.out.println(zelda.remove(2));
		System.out.println(link.remove(2));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		System.out.println(zelda.remove(0));
		System.out.println(link.remove(0));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		System.out.println(zelda.remove(0));
		System.out.println(link.remove(0));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		//System.out.println(zelda.remove(1));
		//System.out.println(zelda);

	    } else if (Integer.parseInt(args[0]) == 1){

		MyLinkedList<String> zelda = new MyLinkedList<String>();
		ArrayList<String> link = new ArrayList<String>();
		
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add("bb");
		link.add("bb");
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add("dd");
		link.add("dd");
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add(1,"cc");
		link.add(1,"cc");
		System.out.println("j");
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add(0,"aa");
		link.add(0,"aa");
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.add(4,"gg");
		link.add(4,"gg");
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		//for (int i=0; i<zelda.size(); i++){
		//    System.out.println(zelda.get(i)+" "+zelda.get(i+1));
		//}
		zelda.add(4,"ee");
		link.add(4,"ee");
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());

		zelda.add("oof");
		link.add("oof");
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.remove(zelda.size()-1);
		link.remove(link.size()-1);
		System.out.println(zelda);
		System.out.println(link);

		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		zelda.set(zelda.size()-1,"oof");
		link.set(link.size()-1,"oof");
		System.out.println(zelda);
		System.out.println(link);
		zelda.set(zelda.size()-1,"gg");
		link.set(link.size()-1,"gg");
		System.out.println(zelda);
		System.out.println(link);

		System.out.println();
		System.out.println(zelda.get(0));
		System.out.println(link.get(0));
		System.out.println(zelda.get(1));
		System.out.println(link.get(1));
		System.out.println(zelda.get(2));
		System.out.println(link.get(2));
		System.out.println(zelda.get(3));
		System.out.println(link.get(3));
		System.out.println(zelda.get(4));
		System.out.println(link.get(4));
		System.out.println(zelda.get(5));
		System.out.println(link.get(5));
		System.out.println(zelda.set(5,"ff"));
		System.out.println(link.set(5,"ff"));
		System.out.println(zelda.set(0,"zz"));
		System.out.println(link.set(0,"zz"));
		System.out.println(zelda);
		System.out.println(link);
		
		System.out.println();
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(zelda.indexOf("ff"));
		System.out.println(link.indexOf("ff"));
		System.out.println(zelda.indexOf("kk"));
		System.out.println(link.indexOf("kk"));
		
		System.out.println();
		System.out.println(zelda.remove(1));
		System.out.println(link.remove(1));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		System.out.println(zelda.remove(4));
		System.out.println(link.remove(4));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		System.out.println(zelda.remove(3));
		System.out.println(link.remove(3));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		System.out.println(zelda.remove(2));
		System.out.println(link.remove(2));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		System.out.println(zelda.remove(0));
		System.out.println(link.remove(0));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());
		System.out.println(zelda.remove(0));
		System.out.println(link.remove(0));
		System.out.println(zelda);
		System.out.println(link);
		System.out.println(" "+zelda.size());
		System.out.println(" "+link.size());

	    } else if (Integer.parseInt(args[0])==2){
		MyLinkedList<Integer> hello = new MyLinkedList<Integer>();
		hello.add(0);
		hello.add(9);
		hello.add(1);
		hello.add(8);
		hello.add(2);
		hello.add(7);
		hello.add(3);
		hello.add(6);
		hello.add(4);
		hello.add(5);
		for (int i : hello){
		    System.out.println(i);
		}
	    }

	} catch(NoSuchElementException e){

	}

    }

}
