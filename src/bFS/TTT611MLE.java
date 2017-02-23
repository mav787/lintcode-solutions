package bFS;

import java.util.*;

public class TTT611MLE {
	public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        // 0 as empty and 1 as barrier ???
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        if(!isValid(source, grid) || !isValid(destination, grid)){
            return -1;
        }
        if(grid[source.x][source.y] == true || grid[destination.x][destination.y] == true){
            return -1;
        }
        

        int steps = 0;
        
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(source);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point point = queue.poll();
                
                if(reach(point, destination)){
                    return steps;
                }
//                if(!isValid(point, grid)){
//                    continue;
//                }
                grid[point.x][point.y] = true;
                
                Point[] arr = neighbors(point);
                for(int j = 0; j < 8; j++){
                    if(isValid(arr[j], grid)){
                        queue.offer(arr[j]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    
    private boolean isValid(Point point, boolean[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        
        int x = point.x;
        int y = point.y;
        
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
    
    private Point[] neighbors(Point point){
        int x = point.x;
        int y = point.y;
                
        Point[] arr = new Point[8];
        arr[0] = new Point(x - 2, y - 1);
        arr[1] = new Point(x - 1, y - 2);
        arr[2] = new Point(x + 2, y - 1);
        arr[3] = new Point(x + 1, y - 2);
        arr[4] = new Point(x - 2, y + 1);
        arr[5] = new Point(x - 1, y + 2);
        arr[6] = new Point(x + 2, y + 1);
        arr[7] = new Point(x + 1, y + 2);
        
        return arr;
    }
}


class Point {
	      public int x, y;
	      public Point() { x = 0; y = 0; }
	      public Point(int a, int b) { x = a; y = b; }
	  }
