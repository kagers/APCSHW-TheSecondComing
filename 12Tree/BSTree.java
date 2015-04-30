import java.io.*;
import java.util.*;

public class BSTree<T implements Comparable>{

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
	return null;
    }

}
