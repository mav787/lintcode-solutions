package hashHeapAndStack;
import java.util.*;


public class TTT551 {
	public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        int res = 0;
        if(nestedList == null || nestedList.size() == 0){
            return res;
        }
        return depthSum(nestedList, 1);
    }
    
    private int depthSum(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for(NestedInteger item: nestedList){
            if(item.isInteger()){
                sum += item.getInteger() * depth;
            }
            else{
                sum += depthSum(item.getList(), depth + 1);
            }
        }
        return sum;
    }
}



	interface NestedInteger {
	 
	      // @return true if this NestedInteger holds a single integer,
	      // rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds,
	      // if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds,
	      // if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }