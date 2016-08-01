package info.guzialek.MyLittleJavaLibrary.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphTraverser {
    
    private List<Node> graph;
    
    private Map<Node, Boolean> discovered;
    
    public GraphTraverser(List<Node> graph) {
        this.graph = graph;
        this.discovered = new HashMap<>();
        
        clearNodeStatuses();
    }

    private void clearNodeStatuses() {
        for (Node node : graph) {
            discovered.put(node, false);
        }
    }
    
    private List<Node> bfs(Node startingNode) {
        List<Node> bfsOrder = new ArrayList<>();
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(startingNode);       
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (!discovered.get(node)) {
                discovered.put(node, true);
                
                bfsOrder.add(node);
                
                for (Node adjacentNode : node.getAdjacentNodes()) {
                    queue.add(adjacentNode);
                }
            } else {
                discovered.put(node, true);
            }
        }
        
        return bfsOrder;
    }
    
    public List<Node> bfs() {
        clearNodeStatuses();
        return bfs(graph.get(0));
    }
    
    }

}
