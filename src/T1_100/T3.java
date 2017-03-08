package T1_100;

public class T3 {
	public int digitCounts(int k, int n) {
        // write your code here
        int cnt = 0;
        for (int i = k; i <= n; i++) {
            cnt += singleCount(i, k);
        }
        return cnt;
    }
    
    public int singleCount(int i, int k) {
        if (i == 0 && k == 0)
            return 1;
        int cnt = 0;
        while (i > 0) {
            // digit...
            if (i % 10 == k) {
                cnt++;
            }
            i = i / 10;
        }
        return cnt;
    }
}



