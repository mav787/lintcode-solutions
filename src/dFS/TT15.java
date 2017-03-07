package dFS;
import java.util.*;

public class TT15 {
	public List<List<Integer>> permute(int[] nums) {
        // write your code here
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> permu = new ArrayList<>();
        if(nums == null){
            return res;
        }
        if(nums.length == 0){
            res.add(permu);
            return res;
        }
        
        permute(nums, res, permu);
        return res;
    }
    
    private void permute(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> permu){
        if(permu.size() == nums.length){
            res.add(new ArrayList<Integer>(permu));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(permu.contains(nums[i])){
                continue;
            }
            permu.add(nums[i]);
            permute(nums, res, permu);
            permu.remove(permu.size() - 1);
        }
    }
}
