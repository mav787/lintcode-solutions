package T1_100;
import java.util.*;

public class TT15 {
	public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        backtrack(res, perm, nums);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> perm, int[] nums){
        if(perm.size() == nums.length){
            res.add(new ArrayList<Integer>(perm));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(perm.contains(nums[i]))
                continue;
            perm.add(nums[i]);
            backtrack(res, perm, nums);
            perm.remove(perm.size() - 1);
        }
    }
}
