package twoPointers;
import java.util.*;
public class TTT521ii {
	public int deduplication(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[count] = nums[i];
                count++;
            }
            else{
                continue;
            }
        }
        return count;
    }
}
