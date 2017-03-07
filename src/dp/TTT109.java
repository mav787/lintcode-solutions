package dp;

public class TTT109 {
	public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0 || triangle[0].length == 0)
            return -1;
        int m = triangle.length;
        int[][] dp = new int[2][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j <= i; j++){
                if(i == 0)
                    dp[i % 2][j] = triangle[i][j];
                else if(j == 0)
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + triangle[i][j];
                else if(j == i)
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + triangle[i][j];
                else
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - 1]) + triangle[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            res = Math.min(res, dp[(m - 1) % 2][j]);
        }
        return res;
    }
}
