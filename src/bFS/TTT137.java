package bFS;

import java.util.*;

public class TTT137 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null){
            return null;
        }
        // use bfs to get all nodes;
        ArrayList<UndirectedGraphNode> allNodes = bfsGraph(node);
        
        // clone nodes;
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        for(UndirectedGraphNode item: allNodes){
            map.put(item, new UndirectedGraphNode(item.label));
        }
        
        // clone edges;
        for(UndirectedGraphNode item:allNodes){
            UndirectedGraphNode newNode = map.get(item);
            for(UndirectedGraphNode nei: item.neighbors){
                UndirectedGraphNode newnei = map.get(nei);
                newNode.neighbors.add(newnei);
            }
        }
        
        return map.get(node);
    }
    
    
    
    
    
    private ArrayList<UndirectedGraphNode> bfsGraph(UndirectedGraphNode node){
        ArrayList<UndirectedGraphNode> res = new ArrayList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode item = queue.poll();
            if(set.contains(item)){
                continue;
            }
            set.add(item);
            res.add(item);
            for(UndirectedGraphNode nei: item.neighbors){
                queue.offer(nei);
            }
        }
        return res;
    }
}
