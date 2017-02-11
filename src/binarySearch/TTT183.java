package binarySearch;

public class TTT183 {
	public int woodCut(int[] L, int k) {
        // write your code here
        // 1. implement the count() method to count how many pieces 
        // 2. binary search using count() >= k??
        
        if(L == null || L.length == 0){
            return 0;
        }
        
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        
        int start = 1, end = max;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            
            if(count(L,mid) > k){
                start = mid;
            }
            else if(count(L,mid) < k){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(count(L, start) >= k){
            return start;
        }
        else if(count(L, end) >= k){
            return end;
        }
        else{
            return 0;
        }
    }
        
        
        
        
        private int count(int[] L, int length){
            int count = 0;
            for(int i = 0; i < L.length; i++){
                count += L[i] / length;
            }
            return count;
        }
}
