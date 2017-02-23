package twoPointers;
import java.util.*;

public class TTT587 {
	public int twoSum6(int[] nums, int target) {
        // Write your code here
		// hashmap version
        if(nums == null || nums.length < 2){
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                if(map.get(target - nums[i]) == 1){
                    res++;
                    map.put(target - nums[i], 2);
                }
                else{
                    continue;
                }
            }
            
            else if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
        }
        return res;
    }
}
