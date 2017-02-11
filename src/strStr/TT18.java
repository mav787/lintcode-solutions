package strStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TT18 {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        if(nums == null) return null;
        Arrays.sort(nums);
        Set<ArrayList<Integer>> allsubsets = subsets(nums, nums.length);
        
        return new ArrayList<ArrayList<Integer>>(allsubsets);
    }
    
    private HashSet<ArrayList<Integer>> subsets(int[] nums, int index){
        HashSet<ArrayList<Integer>> allsubsets;
        if(index == 0){
            allsubsets = new HashSet<>();
            allsubsets.add(new ArrayList<Integer>());
        }
        
        else{
            allsubsets = subsets(nums, index - 1);
            int item = nums[index - 1];
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
            for(ArrayList<Integer> subset: allsubsets){
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
            
        }
        return allsubsets;
    }
}
