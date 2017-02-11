package binarySearch;

public class TT75 {
	public int findPeak(int[] A) {
        // write your code here
        // return the INDEX
        if(A == null || A.length == 0){
            return -1;
        }
        
        int start = 0, end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            
            if(mid == 0 || mid == A.length - 1){
                continue;
            }
            
            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
                return mid;
            }
            else if (A[mid] > A[mid - 1]){
                start = mid;
            }
            else if (A[mid] > A[mid + 1]){
                end = mid;
            }
            else{
                start = mid;
                //else will do
            }
        }
        return 0;
    }
}
