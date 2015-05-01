import java.io.*;
import java.util.*;

public class BSTree<T extends Comparable>{

    private BSTreeNode<T> root;

    public BSTree(){
	root = null;
    }

    public boolean isEmpty(){
	return root==null;
    }

    public boolean isLeaf(BSTreeNode<T> t){
	return (t.getLeft()==null && t.getRight()==null);
    }

    public void add(T c){
	root = add(root, new BSTreeNode<T>(c));
    }

    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t){
	if (curr==null){
	    curr = t;
	    return curr;
	} else if (curr.compareTo(t)<0){
	    curr.setRight(add(curr.getRight(),t));
	    return curr;
	} else if (curr.compareTo(t)>0){
	    curr.setLeft(add(curr.getLeft(),t));
	    return curr;
	} else{
	    return null;
	}
    }

    public void remove(T c){
	remove(root,new BSTreeNode<T>(c));
    }

    private BSTreeNode<T> remove(BSTreeNode<T> curr, T c){
	return null;
    }

    public void inOrder(){
	inOrderHelper(root);
	System.out.println();
    }

    public void inOrderHelper(BSTreeNode<T> t){
	if (t!=null){
	    inOrderHelper(t.getLeft());
	    System.out.print(t.getData()+" ");
	    inOrderHelper(t.getRight());
	}
    }

    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(BSTreeNode<T> curr){
	if (curr==null){
	    return 0;
	} else if (curr.getLeft()==null && curr.getRight()==null){
	    return 1;
	} else if (curr.getLeft()==null){
	    return 1+getHeight(curr.getRight());
	} else if (curr.getRight()==null){
	    return 1+getHeight(curr.getLeft());
	} else{
	    return 1+Math.max(getHeight(curr.getLeft()),
			      getHeight(curr.getRight()));
	} 
    }

    private String getLevel(BSTreeNode<T> curr, int level){
	if (curr==null){
	    return "";
	} else if (level==0){
	    return curr.getData()+" ";
	} else{
	    return getLevel(curr.getLeft(),level-1)+
		getLevel(curr.getRight(),level-1);
	}
    }

    public String toString(){
	String ret = "";
	for (int i=0; i<getHeight(); i++){
	    ret+=getLevel(root,i)+"\n";
	}
	return ret;
    }

    public static void main(String[] args){
	BSTree<Integer> t = new BSTree<Integer>();
	t.inOrder();
	t.add(5);
	t.inOrder();
	t.add(0);
	t.inOrder();
	t.add(10);
	t.inOrder();
	t.add(3);
	t.inOrder();
	t.add(7);
	t.inOrder();
	System.out.println(t);


    }

}
