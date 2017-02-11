package strStr;
import java.util.*;

public class TT17 {
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        if(nums == null){
            return null;
        }
        
        Arrays.sort(nums);
        return subsets(nums, nums.length);
    }
    
    
    private ArrayList<ArrayList<Integer>> subsets(int[] nums, int index){
        ArrayList<ArrayList<Integer>> allsubsets;
        if(index == 0){
            allsubsets = new ArrayList<>();
            allsubsets.add(new ArrayList<Integer>());
            return allsubsets;
        }
        
        allsubsets = subsets(nums, index - 1);
        int item = nums[index - 1];
        
        ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
        for(ArrayList<Integer> list : allsubsets){
            ArrayList<Integer> newsubset = new ArrayList<>();
            newsubset.addAll(list);
            newsubset.add(item);
            moresubsets.add(newsubset);
        }
        
        allsubsets.addAll(moresubsets);
        return allsubsets;
    }
}
