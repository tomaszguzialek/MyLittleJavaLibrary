package info.guzialek.MyLittleJavaLibrary.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTraverserTest {

    @Test
    public void testBfs() {
        List<Node> graph = buildTestGraph();
        
        GraphTraverser graphTraverser = new GraphTraverser(graph);
        List<Node> bfsOrder = graphTraverser.bfs();
        List<Integer> indexes = bfsOrder.stream().map(x -> x.getIndex()).collect(Collectors.toList());
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 5, 6, 3, 4)), indexes);
    }
    
    @Test
    public void testDfs() {
        List<Node> graph = buildTestGraph();
        
        GraphTraverser graphTraverser = new GraphTraverser(graph);
        List<Node> dfsOrder = graphTraverser.dfs();
        List<Integer> indexes = dfsOrder.stream().map(x -> x.getIndex()).collect(Collectors.toList());
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), indexes);
    }

    private List<Node> buildTestGraph() {
        List<Node> graph = new ArrayList<>();
        
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        
        node1.addToAdjacentNodes(node2);
        node1.addToAdjacentNodes(node5);
        node1.addToAdjacentNodes(node6);
        
        node2.addToAdjacentNodes(node1);
        node2.addToAdjacentNodes(node3);
        node2.addToAdjacentNodes(node5);
        
        node3.addToAdjacentNodes(node2);
        node3.addToAdjacentNodes(node4);
        
        node4.addToAdjacentNodes(node3);
        node4.addToAdjacentNodes(node5);
        
        node5.addToAdjacentNodes(node1);
        node5.addToAdjacentNodes(node2);
        node5.addToAdjacentNodes(node4);
        
        node6.addToAdjacentNodes(node1);
        
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        graph.add(node5);
        graph.add(node6);
        return graph;
    }

}
