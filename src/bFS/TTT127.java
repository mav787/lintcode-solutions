package bFS;

import java.util.*;

public class TTT127 {
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        if(graph == null || graph.size() == 0){
            return res;
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        
        for(DirectedGraphNode node: graph){
            for(DirectedGraphNode nei: node.neighbors){
                if(!map.containsKey(nei)){
                    map.put(nei, 1);
                }
                else{
                    map.put(nei, map.get(nei) + 1);
                }
            }
        }
        
        for(DirectedGraphNode node: graph){
            if(!map.containsKey(node)){
                queue.offer(node);
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                DirectedGraphNode node = queue.poll();
                res.add(node);
                for(DirectedGraphNode nei: node.neighbors){
                    map.put(nei, map.get(nei) - 1);
                    if(map.get(nei) == 0){
                        queue.offer(nei);
                    }
                }
            }
        }
        return res;
    }
}


class DirectedGraphNode {
	      int label;
	      ArrayList<DirectedGraphNode> neighbors;
	      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
	  }
