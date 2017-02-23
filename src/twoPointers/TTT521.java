package twoPointers;
import java.util.*;
public class TTT521 {
	public int deduplication(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                nums[count] = nums[i];
                set.add(nums[i]);
                count++;
            }
            else{
                while(i < nums.length && set.contains(nums[i])){
                    i++;
                }
                if(i < nums.length){
                    set.add(nums[i]);
                    nums[count] = nums[i];
                    count++;
                }
            }
        }
        return count;
    }
}
