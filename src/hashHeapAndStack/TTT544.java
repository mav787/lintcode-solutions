package hashHeapAndStack;

import java.util.*;

public class TTT544 {
	public int[] topk(int[] nums, int k) {
        // Write your code here
        if(nums == null){
            return new int[0];
        }
        if(k > nums.length){
            k = nums.length;
        }
        int[] res = new int[k];
        Queue<Integer> heap = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            heap.offer(nums[i]);
        }
        
        for(int i = 0; i < k; i++){
            res[i] = heap.poll();
        }
        
        // Arrays.sort(nums);
        // for(int i = 0; i < k; i++){
        //     res[i] = nums[nums.length - i - 1];
        // }
        return res;
    }
}
