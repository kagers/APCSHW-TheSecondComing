public class BSTreeNode<T extends Comparable>{
    
    private T data;
    private BSTreeNode<T> leaft;
    private BSTreeNode<T> right;
    
    public BSTreeNode(T d){
	data = d;
	leaft = right = null;
    }

    public int compareTo(BSTreeNode<T> t){
	return (Integer)getData()-(Integer)t.getData();
    }

    public T getData(){
	return data;
    }
    public void setData(T lf){
	data = lf;
    }

    public BSTreeNode<T> getLeft(){
	return leaft;
    }
    public void setLeft(BSTreeNode<T> lf){
	leaft = lf;
    }

    public BSTreeNode<T> getRight(){
	return right;
    }
    public void setRight(BSTreeNode<T> lf){
	right = lf;
    }

}
