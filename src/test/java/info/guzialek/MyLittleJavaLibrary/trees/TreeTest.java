package info.guzialek.MyLittleJavaLibrary.trees;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import junit.framework.Assert;

public class TreeTest {

    @Test
    public void testInOrderTreeWalk() {
        Tree<Integer> tree = new Tree<>(Arrays.asList(10, 5, 7, 6, 9));
        List<TreeNode<Integer>> inOrder = tree.inOrderTreeWalk();
        Assert.assertEquals(Arrays.asList(5, 6, 7, 9, 10), inOrder.stream().map(node -> node.getKey()).collect(Collectors.toList()));
    }
    
}
