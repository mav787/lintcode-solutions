package bFS;
import java.util.*;

public class TTT611 {
private static final int[][] offset = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
     
    
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        // false as empty and true as barrier ???
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        if(!isValid(source.x, source.y, grid) || !isValid(destination.x, destination.y, grid)){
            return -1;
        }
        if(grid[source.x][source.y] == true || grid[destination.x][destination.y] == true){
            return -1;
        }
        
        // int m = grid.length;
        // int n = grid[0].length;
        
        int steps = 0;
        
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(source);
        grid[source.x][source.y] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point point = queue.poll();
                
                if(reach(point, destination)){
                    return steps;
                }
//              if(!isValid(point, grid)){
//              	continue;
//          	}
                for(int j = 0; j < 8; j++){
                    if(isValid(point.x + offset[j][0], point.y + offset[j][1], grid)){
                        queue.offer(new Point(point.x + offset[j][0], point.y + offset[j][1]));
                        grid[point.x + offset[j][0]][point.y + offset[j][1]] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    
    private boolean isValid(int x, int y, boolean[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(x < 0 || x >= m || y < 0 || y >= n){
            return false;
        }
        if(grid[x][y] == true){
            return false;
        }
        return true;
    }
    
    
    private boolean reach(Point a, Point b){
        if(a.x == b.x && a.y == b.y){
            return true;
        }
        return false;
    }
}
