package binarySearch;

public class TT74 {
	public int findFirstBadVersion(int n) {
        // write your code here
        if(n <= 0){
            return -1;
        }
        int start = 1, end = n;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(SVNRepo.isBadVersion(mid)){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(SVNRepo.isBadVersion(start)){
            return start;
        }
        else{
            return end;
        }
    }
	
}


 class SVNRepo {
	      public static boolean isBadVersion(int k) {
			// TODO Auto-generated method stub
			return false;
		}
	  }