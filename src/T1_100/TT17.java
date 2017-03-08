package T1_100;
import java.util.*;

public class TT17 {
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        if(nums == null)
            return res;
        if(nums.length == 0){
            res.add(subset);
            return res;
        }
        Arrays.sort(nums);
        backtrack(res, subset, nums, 0);
        return res;
    }
    
    private void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset, int[] nums, int start){
        res.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            backtrack(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
