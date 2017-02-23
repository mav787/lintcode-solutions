package twoPointers;
import java.util.*;

public class TTT533 {
	public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2){
            return -1;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while(left < right){
            int sum = nums[left] + nums[right];
            int diff = target - sum;
            res = Math.min(res, Math.abs(diff));
            if(diff > 0){
                // target > sum
                left++;
            }
            else if(diff < 0){
                right--;
            }
            else{
                return diff;
            }
        }
        return res;
    }
}
