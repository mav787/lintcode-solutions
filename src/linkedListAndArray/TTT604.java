package linkedListAndArray;

public class TTT604 {
	public int[] winSum(int[] nums, int k) {
        // write your code here
        
        if(nums == null || nums.length == 0 || nums.length < k){
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        res[0] = sum;
        
        for(int i = 1; i < res.length; i++){

            res[i] = res[i - 1] - nums[i - 1] + nums[i - 1 + k];
        }
        
        return res;
        
    }
}
