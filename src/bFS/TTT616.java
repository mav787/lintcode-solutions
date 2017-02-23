package bFS;
import java.util.*;

public class TTT616 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> relateTo = new HashMap<Integer, Set<Integer>>();
        int[] degree = new int[numCourses];
        int[] res = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i ++) {
            if (!relateTo.containsKey(prerequisites[i][1]))
                relateTo.put(prerequisites[i][1], new HashSet<Integer>());
            if (relateTo.get(prerequisites[i][1]).add(prerequisites[i][0]))
                degree[prerequisites[i][0]] ++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i ++)
            if (degree[i] == 0) q.offer(i);
        
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            res[index ++] = node;
            Set<Integer> next = relateTo.get(node);
            if (next != null)
                for (int i: next) 
                    if (-- degree[i] == 0) q.offer(i);
        }
        
        if (index == numCourses) return res;
        return new int[0];
    }
}
