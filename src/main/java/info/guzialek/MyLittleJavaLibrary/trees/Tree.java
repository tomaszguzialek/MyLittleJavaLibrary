package info.guzialek.MyLittleJavaLibrary.trees;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {

    private TreeNode<T> root;
    
    public Tree(List<T> values) {
        for (T value : values) {
            add(value);
        }
    } 
    
    public void add(T value) {
        if (root == null) {
            root = new TreeNode<>(value);
            return;
        }
        
        TreeNode<T> parent = null;
        TreeNode<T> current = root;
        while (current != null) {
            parent = current;
            if (value.compareTo(current.getKey()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        
        if (value.compareTo(parent.getKey()) < 0) {
            parent.setLeft(new TreeNode<>(value));
        } else {
            parent.setRight(new TreeNode<>(value));
        }
    }
    
    public List<TreeNode<T>> inOrderTreeWalk() {
        return inOrderTreeWalk(root);
    }
    
    private List<TreeNode<T>> inOrderTreeWalk(TreeNode<T> node) {
        List<TreeNode<T>> inOrder = new ArrayList<>();
        
        if (node != null) {
            inOrder.addAll(inOrderTreeWalk(node.getLeft()));
            inOrder.add(node);
            inOrder.addAll(inOrderTreeWalk(node.getRight()));
        }
        
        return inOrder;
    }
    
}
