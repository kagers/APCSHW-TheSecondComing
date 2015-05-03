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
	} else if (curr.compareTo(t)<0){
	    curr.setRight(add(curr.getRight(),t));
	} else if (curr.compareTo(t)>0){
	    curr.setLeft(add(curr.getLeft(),t));
	} else{
	    return null;
	}
	return curr;
    }

    public void remove(T c){
	root = remove(root,c);
    }

    private BSTreeNode<T> remove(BSTreeNode<T> curr, T c){
	if (curr==null){
	    return curr;
	}
	if (curr.getData().equals(c)){
	    if (isLeaf(curr)){
		return null;
	    } else if (curr.getLeft()!=null && curr.getRight()==null){
		return curr.getLeft();
	    } else if (curr.getLeft()==null && curr.getRight()!=null){
		return curr.getRight();
	    } else{

	    }
	}
	//System.out.println(curr.getRight());
	//System.out.println(curr);
	/*if (curr.getRight()!=null && curr.getRight().getData().equals(c)){
	    BSTreeNode<T> cr=curr.getRight();
	    if (isLeaf(cr)){
		curr.setRight(null);
	    } else if (cr.getLeft()==null && cr.getRight()!=null){
		curr.setRight(cr.getRight());
	    } else if (cr.getRight()==null && cr.getLeft()!=null){
		curr.setRight(cr.getLeft());
	    } else{
	       
	    }
	    return curr;
	} if (curr.getLeft()!=null && curr.getLeft().getData().equals(c)){
	    BSTreeNode<T> cr=curr.getLeft();
	    if (isLeaf(cr)){
		curr.setLeft(null);
	    } else if (cr.getLeft()==null && cr.getRight()!=null){
		curr.setLeft(cr.getRight());
	    } else if (cr.getRight()==null && cr.getLeft()!=null){
		curr.setLeft(cr.getLeft());
	    }
	    return curr;
	}*/ else{
	    //System.out.println("l");
	    if (c.compareTo(curr.getData())<0){
		curr.setLeft(remove(curr.getLeft(),c));
	    } else{
		curr.setRight(remove(curr.getRight(),c));
	    }
	}
	return curr;
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

    /**
     * stolen from: Dennis Yatunin
     * (no not really stolen from, donated by)
     */
    
    public int getHeight(){
	return getHeight(root);
    }
    
    private int getHeight(BSTreeNode<T> r ){
	if(r == null){
	    return 0;
	}else{
	    //System.out.println("recursion height");
	    return 1 + Math.max(getHeight(r.getLeft()),
				getHeight(r.getRight()));
	}
    }
    
    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }
    
    private int maxLength(BSTreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }
    
    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }
    
    private String getLevel(BSTreeNode<T> curr, int currLevel, 
			    int targetLevel, int height, int wordLength) {
	if (currLevel == 1){
	    return curr.toString() + 
		spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * 
		       Math.pow(2, height - targetLevel + 1) - 
		       wordLength);
	}
	String result = "";
	if (curr.getLeft() != null){
	    result += getLevel(curr.getLeft(), currLevel - 1,
			       targetLevel, height, wordLength);
	}else{
	    result += spaces(wordLength * 
			     Math.pow(2, height - targetLevel + currLevel - 1));
	}
	if (curr.getRight() != null){
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, 
			       height, wordLength);
	}else{ 
	    result += spaces(wordLength * 
			     Math.pow(2, height - targetLevel + currLevel - 1));
	}
	return result;
    }
    
    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++){
	    // remove extra spaces from the end of each level's 
	    // String to prevent lines from getting unnecessarily 
	    // long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) + getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") + "\n";
	}
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
	
	return result;
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
	System.out.println();
	t.remove(3);
	System.out.println(t);
	System.out.println();
	t.remove(10);
	System.out.println(t);
	/*t.remove(3);
	System.out.println(t);
	System.out.println();
	*/}

}
