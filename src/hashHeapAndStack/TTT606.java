package hashHeapAndStack;
import java.util.*;

public class TTT606 {
	public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        if(nums == null || nums.length < k){
            return 0;
        }
        
        Queue<Integer> pq = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
        }
        int res = 0;
        for(int i = 0; i < k; i++){
            res = pq.poll();
        }
        return res;
    }
}
