package dp;
import java.util.*;

public class TT76 {
	public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                int thisLength = dp[j];
                if(nums[i] > nums[j]){
                    thisLength++;
                    dp[i] = Math.max(dp[i], thisLength);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
