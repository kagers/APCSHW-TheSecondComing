import java.util.*;

public class BTree<T>{

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode<T> root;

    public BTree(){
	root = null;
    }

    public void add(T d){
	add(root,new TreeNode<T>(d));
    }

    private void add(TreeNode<T> curr, TreeNode<T> bn){
	if (curr == null){
	    curr = bn;
	} else {
	    Random r = new Random(24);
	    if (r.nextInt(1)==0){
		add(curr.getLeft(),bn);
	    } else {
		add(curr.getRight(),bn);
	    }
	}
    }

    public void traverse(int mode){
	if (mode==PRE_ORDER){
	    preOrder(root);
	} else if (mode==IN_ORDER){
	    inOrder(root);
	} else if (mode==POST_ORDER){
	    postOrder(root);
	}
    }

    public void preOrder(TreeNode<T> curr){
	if (curr!=null){
	    System.out.println(curr.getData());
	    preOrder(curr.getLeft());
	    preOrder(curr.getRight());
	}
    }

    public void inOrder(TreeNode<T> curr){
	if (curr!=null){
	    inOrder(curr.getLeft());
	    System.out.println(curr.getData());
	    inOrder(curr.getRight());
	}
    }

    public void postOrder(TreeNode<T> curr){
	if (curr!=null){
	    postOrder(curr.getLeft());
	    postOrder(curr.getRight());
	    System.out.println(curr.getData());
	}
    }

    /*public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(TreeNode<T> curr){
	
    }

    private String getLevel(){

    }

    public String toString(){

    }
    */
    public static void main(String[] args){
	
	BTree<Integer> t = new BTree<Integer>();

	for (int i=0; i<6; i++){
	    t.add(i);
	}
	System.out.println("Pre-order : ");
	t.traverse(PRE_ORDER);

    }

}
