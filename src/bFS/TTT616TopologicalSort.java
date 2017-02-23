package bFS;
import java.util.*;

public class TTT616TopologicalSort {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<Integer>());
        }
        
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] res = new int[numCourses];
        int index = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            res[index++] = course;
            for(int nei: edges.get(course)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }
        if(index == numCourses) return res;
        return new int[0];
    }
}
