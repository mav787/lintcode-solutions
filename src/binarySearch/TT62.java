package binarySearch;

public class TT62 {
	public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        
        int start = 0, end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            
            
            // 1. A[mid] > A[start]
            if(A[mid] > A[start]){
                // <= , not <
                if(A[start] <= target && target <= A[mid]){
                    end = mid;
                }
                else{
                    start = mid;
                }
            }
            // 2. A[mid] <= A[start]
            else{
                if(A[mid] <= target && target <= A[start]){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        
        if(A[start] == target){
            return start;
        }
        else if(A[end] == target){
            return end;
        }
        else{
            return -1;
        }
    }
}
