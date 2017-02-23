package binarySearch;

public class TT75 {
	public int findPeak(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int start = 1, end = A.length - 2;
        while(start + 1 < end){
            int mid = start + (end - start) / 2 ;
            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
                return mid;
            }
            else if(A[mid] > A[mid - 1]){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        return A[start] > A[end]? start: end;
    }
}
