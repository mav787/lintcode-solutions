package twoPointers;
import java.util.*;

public class TTT587ii {
	public int twoSum6(int[] nums, int target) {
        // Write your code here
		//two pointers version
        if(nums == null || nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                res++;
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right + 1]){
                    right--;
                }
            }
            else if(nums[left] + nums[right] < target){
                left++;
            }
            else{
                right--;
            }
        }
        return res;
    }
}
