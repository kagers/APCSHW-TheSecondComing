public class TreeNode<T>{
    
    private T species;
    private TreeNode<T> leaft;
    private TreeNode<T> ryet;

    public TreeNode(){
	this(null,null,null);
    }
    
    public TreeNode(T s){
	this(s,null,null);
    }

    public TreeNode(T s, TreeNode<T> l, TreeNode<T> r){
	species=s;
	leaft=l;
	ryet=r;
    }

    public T getData(){
	return species;
    }

    public void setData(T lf){
	species = lf;
    }

    public TreeNode<T> getLeft(){
	return leaft;
    }

    public void setLeft(TreeNode<T> lf){
	leaft = lf;
    }

    public TreeNode<T> getRight(){
	return ryet;
    }
    
    public void setRight(TreeNode<T> lf){
	ryet = lf;
    }

}
