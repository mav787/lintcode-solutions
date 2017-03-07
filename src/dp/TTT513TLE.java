package dp;
import java.util.*;

public class TTT513TLE {
	public int numSquares(int n) {
        // Write your code here
        if(n <= 0)
            return -1;
        // prep work:
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i * i <= n; i++){
            set.add(i * i);
        }
        
        // dp: least number of numbers sum to n
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        // initialization:
        
        for(int i = 1; i <= n; i++){
            if(set.contains(i)){
                dp[i] = 1;
                continue;
            }
            else{
                for(int j = 1; j <= i/2; j++){
                    dp[i] = Math.min(dp[i],dp[j] + dp[i - j]);
                }
            }
        }
        return dp[n];
    }
}
