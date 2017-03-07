package dp;

public class TTT513 {
	public int numSquares(int n) {
        // Write your code here
        if(n <= 0)
            return -1;
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i * i <= n; i++){
            dp[i * i] = 1;
        }
        
        for(int i = 1; i <= n; i++){
            if(dp[i] == 1)
                continue;
            for(int j = 1; j * j < i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
