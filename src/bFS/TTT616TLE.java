package bFS;
import java.util.*;

public class TTT616TLE {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] res= new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0){
            for(int i = 0; i < numCourses; i++){
                res[i] = i;
            }
            return res;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int inclass = prerequisites[i][0];
            indegree[inclass]++;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        fillQueue(indegree, queue, set, prerequisites);
        int index = 0;
        while(!queue.isEmpty()){
            res[index++] = queue.poll();
            fillQueue(indegree, queue,set, prerequisites);
        }
        if(set.size() == numCourses){
            return res;
        }
        return new int[0];
    }
    
    
    private void fillQueue(int[] indegree, Queue<Integer> queue, Set<Integer> set, int[][] preq){
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0 && !set.contains(i)){
                queue.offer(i);
                set.add(i);
                // delete neighboring indegrees
                for(int j = 0; j < preq.length; j++){
                    if(preq[j][1] == i){
                        int nextclass = preq[j][0];
                        indegree[nextclass]--;
                    }
                }
            }
        }
    }
}
