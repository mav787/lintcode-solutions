package linkedListAndArray;

public class TT41 {
	public int maxSubArray(int[] nums) {
        // write your code
        if(nums == null || nums.length == 0){
            return -1;
        }
        int sum = 0;
        int global = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            global = Math.max(global, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return global;
    }
}
