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

    public boolean isLeaf(){
	return (t.getLeft()==null && t.getRight()==null);
    }

    public void add(T c){
	root = add(root, new BSTreeNode<T>(c));
    }

    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t){
	if (curr==null){
	    curr = t;
	    return t;
	} else if (curr.compareTo(t)>0){
	    curr.setRight(add(curr.getRight(),t));
	    return curr;
	} else if (curr.compareTo(t)<0){
	    
	} else {

	}
    }

    public void remove(T c){

    }

    private BSTreeNode<T> remove(BSTreeNode<T> curr, T c){

    }

    public void inOrder(){
	inOrderHelper(root);
	System.out.println();
    }

    public void inOrderHelper(BSTreeNode<T> t){
	if (t==null){
	    return
	}
	inOrderHelper(t.getLeft());
	System.out.print(t.getData()+" ");
	inOrderHelper(t.getRight());
    }

    public static void main(String[] args){

    }

}
