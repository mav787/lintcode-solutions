package twoPointers;

public class TTT608 {
	public int[] twoSum(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2){
            return null;
        }
        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                return new int[]{left + 1, right + 1};
            }
            else if(nums[left] + nums[right] < target){
                left++;
            }
            else{
                right--;
            }
        }
        return null;
    }
}
