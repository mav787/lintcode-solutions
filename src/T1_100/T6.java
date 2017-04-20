package T1_100;

public class T6 {
	public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        if(A == null && B == null)
            return null;
        if(A == null) 
        	return B;
        if(B == null) 
        	return A;
        
        int[] res = new int[A.length + B.length];
        
        int m = 0, n = 0, curr = 0;
        while(m < A.length && n < B.length){
            if(A[m] < B[n])
                res[curr++] = A[m++];
            else
                res[curr++] = B[n++];
        }
        while (m < A.length)
            res[curr++] = A[m++];
        while (n < B.length)
            res[curr++] = B[n++];
        return res;
    }
}
