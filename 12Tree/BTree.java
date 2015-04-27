import java.util.*;

public class BTree<T>{

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode<T> root;
    private Random arbre;

    public BTree(){
	root = null;
	arbre = new Random(24);
    }

    public void add(T d){
	if (root == null){
	    root = new TreeNode<T>(d);
	} else {
	    add(root,new TreeNode<T>(d));
	}
    }

    private void add(TreeNode<T> curr, TreeNode<T> bn){
	if (curr == null){
	    curr = bn; 
	} else if (curr.getLeft()==null){
	    curr.setLeft(bn);
	} else if (curr.getRight()==null){
	    curr.setRight(bn);
	} else {
	    if (arbre.nextInt(1)==0){
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
	System.out.println();
    }

    public void preOrder(TreeNode<T> curr){
	if (curr!=null){
	    System.out.print(curr.getData());
	    preOrder(curr.getLeft());
	    preOrder(curr.getRight());
	}
    }

    public void inOrder(TreeNode<T> curr){
	if (curr!=null){
	    inOrder(curr.getLeft());
	    System.out.print(curr.getData());
	    inOrder(curr.getRight());
	}
    }

    public void postOrder(TreeNode<T> curr){
	if (curr!=null){
	    postOrder(curr.getLeft());
	    postOrder(curr.getRight());
	    System.out.print(curr.getData());
	}
    }

    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(TreeNode<T> curr){
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

    /*private String getLevel(){

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
	System.out.println("In-order : ");
	t.traverse(IN_ORDER);
	System.out.println("Post-order : ");
	t.traverse(POST_ORDER);
	System.out.println("Height: "+t.getHeight());
	System.out.println(t);
    }

}
