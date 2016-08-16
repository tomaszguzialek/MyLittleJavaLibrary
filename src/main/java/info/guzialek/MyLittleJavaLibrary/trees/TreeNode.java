package info.guzialek.MyLittleJavaLibrary.trees;

public class TreeNode<T> {
    
    private T key;
    
    private TreeNode<T> left;
    
    private TreeNode<T> right;
    
    public TreeNode(T key) {
        this.key = key;
    }
    
    public T getKey() {
        return key;
    }
    
    public TreeNode<T> getLeft() {
        return left;
    }
    
    public TreeNode<T> getRight() {
        return right;
    }
    
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }
    
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
    
}
