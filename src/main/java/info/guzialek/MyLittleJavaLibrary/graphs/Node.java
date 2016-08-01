package info.guzialek.MyLittleJavaLibrary.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    
    private int index;
    
    private List<Node> adjacentNodes;
    
    public Node(int index) {
        this.index = index;
        this.adjacentNodes = new ArrayList<>();
    }
    
    public int getIndex() {
        return index;
    }
    
    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }
    
    public void addToAdjacentNodes(Node node) {
        adjacentNodes.add(node);
    }
    
    public String toString() {
        return "Node " + index;
    } 
    
}
