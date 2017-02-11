package binarySearch;

public class TT61 {
	public int[] searchRange(int[] A, int target) {
        // write your code here
        int e1 = -1, e2 = -1;
        int[] res = {e1,e2};
        if (A == null || A.length == 0) return res;
        
        int start = 0, end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (A[mid] == target) end = mid;    //finding the 1st match
            else if (A[mid] < target) start = mid;
            else end = mid;
        }
        if (A[start] == target) e1 = start;
        else if (A[end] == target) e1 = end;
        else e1 = -1;
        
          start = 0;
          end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (A[mid] == target) start = mid;    //finding the last match
            else if (A[mid] < target) start = mid;
            else end = mid;
        }
        if (A[end] == target) e2 = end;
        else if (A[start] == target) e2 = start;
        else e2 = -1;
        
        int[] rr = {e1,e2};
        return rr;   
    }
}
