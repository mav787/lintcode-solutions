package dp;

public class TTT116 {
	// Jump Game is a Greedy approach...
	public boolean canJump(int[] A) {
        // wirte your code here
        if(A == null || A.length == 0)
            return false;
        int farthest = A[0];
        for(int i = 1; i < A.length; i++){
            if(farthest >= i && i + A[i] >= farthest)
                farthest = i + A[i];
        }
        return farthest >= A.length - 1;
    }
}
