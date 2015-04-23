public class BTree<T>{

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode<E> root;

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
		
	    } else {

	    }
	}
    }

    public void traverse(int mode){
	if (mode==PRE_ORDER){
	    preOrder();
	} else if (mode==IN_ORDER){
	    inOrder();
	} else if (mode==POST_ORDER){
	    postOrder();
	}
    }

    public void preOrder(TreeNode<T> curr){
	
    }

    public void inOrder(TreeNode<T> curr){

    }

    public void postOrder(TreeNode<T> curr){
	
    }

    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(TreeNode<T> curr){
	
    }

    private String getLevel(){

    }

    public String toString(){

    }

    public static void main(String[] args){
	
	BTree<Integer> t = new BTree<Integer>();

	for (int i=0; i<8; i++){
	    t.add(i);
	}
	System,out.println("Pre-order : ");
	t.traverse(PRE_ORDER);

    }

}
