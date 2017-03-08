package T1_100;
import java.util.*;

public class TT16 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        if(nums == null)
            return res;
        if(nums.length == 0){
            res.add(perm);
            return res;
        }
        
        Arrays.sort(nums);
        backtrack(res, perm, nums, new boolean[nums.length]);
        return res;
    } 
    
    private void backtrack(List<List<Integer>> res, List<Integer> perm, int[] nums, boolean[] used){
        if(perm.size() == nums.length){
            res.add(new ArrayList<Integer>(perm));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1])
                continue;
            if(used[i])
                continue;
            
            perm.add(nums[i]);
            used[i] = true;
            backtrack(res, perm, nums, used);
            perm.remove(perm.size() - 1);
            used[i] = false;
        }
    }
}
