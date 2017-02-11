package bFS;

import java.util.*;

public class TTT598 {
	public int zombie(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        int days = 0, zombie = 0, people = 0, sum = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    queue.offer(new Coordinate(i,j));
                    zombie++;
                }
                if(grid[i][j] == 0){
                    people++;
                }
            }
        }
        sum = zombie + people;
        
        while(!queue.isEmpty()){
            ArrayList<Coordinate> level = new ArrayList<>();
            while(!queue.isEmpty()){
                level.add(queue.poll());
            }
            
            ArrayList<Coordinate> newLevel = infect(level, grid);
            for(Coordinate coord:newLevel){
                queue.offer(coord);
                zombie++;
            }
            days++;
            
            if(zombie == sum){
                return days;
            }
        }
        return -1;
    }
    
    
    
    private ArrayList<Coordinate> infect(ArrayList<Coordinate> formerLevel, int[][] grid){
        ArrayList<Coordinate> res = new ArrayList<>();
        
        for(Coordinate coord: formerLevel){
            int x = coord.x;
            int y = coord.y;
            
            if(x - 1 >= 0 && grid[x - 1][y] == 0){
                grid[x - 1][y] = 1;
                res.add(new Coordinate(x - 1, y));
            }
            if(y - 1 >= 0 && grid[x][y - 1] == 0){
                grid[x][y - 1] = 1;
                res.add(new Coordinate(x, y - 1));
            }
            if(x + 1 < grid.length && grid[x + 1][y] == 0){
                grid[x + 1][y] = 1;
                res.add(new Coordinate(x + 1, y));
            }
            if(y + 1 < grid[0].length && grid[x][y + 1] == 0){
                grid[x][y + 1] = 1;
                res.add(new Coordinate(x, y + 1));
            }
        }
        return res;
    }
}

class Coordinate{
    int x;
    int y;
    Coordinate(int a ,int b){
        x = a;
        y = b;
    }
}
