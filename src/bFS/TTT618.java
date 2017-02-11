package bFS;

import java.util.*;

public class TTT618 {
	public UndirectedGraphNode searchNode   (ArrayList<UndirectedGraphNode> graph,
											Map<UndirectedGraphNode, Integer> values, 
											UndirectedGraphNode node, 
											int target) {
		if(graph == null || values == null || node == null){
            return null;
        }
        
        if(!values.containsValue(target)){
            return null;
        }
        
        Set<UndirectedGraphNode> set = new HashSet<>();
        
        Queue <UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        //set.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                UndirectedGraphNode candidate = queue.poll();
                if(set.contains(candidate)){
                    continue;
                }
                set.add(candidate);
                
                if(values.get(candidate) == target){
                    return candidate;
                }
            
                for(UndirectedGraphNode neighbor: candidate.neighbors){
                    if(!set.contains(neighbor)){
                        queue.offer(neighbor);
                        //set.add(neighbor);
                    }
                }
            }
        }
        return null;
    
    }
}


class UndirectedGraphNode {
	      int label;
	      ArrayList<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { 
	          label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
	      }
	  }
