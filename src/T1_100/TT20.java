package T1_100;
import java.util.*;

public class TT20 {
	public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair.
        List<Map.Entry<Integer, Double>> results = new ArrayList<>();
        // x : i 个骰子
        // y : 和为i ~ 6i (j)
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; ++i)
            dp[1][i] = 1.0 / 6;

        for (int i = 2; i <= n; i++)
            for (int j = i; j <= 6 * i; j++) {
            	
                for (int k = 1; k <= 6; k++)
                    if (j > k)
                        dp[i][j] += dp[i - 1][j - k] / 6.0;
            }
        // last row..
        // i is possible results..
        for (int i = n; i <= 6 * n; ++i) 
            results.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i]));

        return results;
    }
}
