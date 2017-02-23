package hashHeapAndStack;

import java.util.Arrays;
import java.util.Comparator;

public class TTT612 {
	public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        if(points == null || k <= 0){
            return new Point[0];
        }
        // this check is necessary??
        if(points.length < k){
            k = points.length;
        }

        WrapperType[] wrappers = new WrapperType[points.length];
        for(int i = 0; i < points.length; i++){
            long distance = calculateDistance(points[i], origin);
            wrappers[i] = new WrapperType(points[i], distance);
        }
       
        // sort wrappers
        Arrays.sort(wrappers, new Comparator<WrapperType>(){
        	public int compare(WrapperType p1, WrapperType p2){
        		if(p1.distance < p2.distance)	return -1;
        		else if(p1.distance == p2.distance){
        			if(p1.point.x <  p2.point.x) return 1;
        			else if(p1.point.x == p2.point.x){
        				if(p1.point.y < p2.point.y) return 1;
        				else if(p1.point.y == p2.point.y) return 0;
        				else return -1;
        			}
        			else return -1;
        		}
        		else return 1;
        	}
        });
        
        Point[] res = new Point[k];
        for(int i = 0; i < k; i++){
            res[i] = wrappers[i].point;
        }
        return res;
    }
    
    private long calculateDistance(Point p1, Point p2){
        return (long)Math.pow(p1.x - p2.x, 2) + (long)Math.pow(p1.y - p2.y, 2);
    }
}


class WrapperType{
    Point point;
    long distance;
    WrapperType(Point p, long d){
        point = p;
        distance = d;
    }
}


class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }