package binarySearch;

public class TTT159 {
	public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        if(nums[0] < nums[nums.length - 1]){
            return nums[0];
        }
        
        int start = 0, end = nums.length - 1;
        int ref = nums[0];
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            
            if(nums[mid] > ref){
                start = mid;
            }
            else{
            //else if(nums[mid] < ref){
                end = mid;
            }
        }
        if(nums[start] < ref){
            return nums[start];
        }
        else{
            return nums[end];
        }
        
    }
}
