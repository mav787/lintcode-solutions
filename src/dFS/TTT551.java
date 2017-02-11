package dFS;
import java.util.*;

public class TTT551 {
	public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for(NestedInteger elem : nestedList){
            if(elem.isInteger()){
                sum += elem.getInteger() * depth;
            }
            else{
                sum += helper(elem.getList(), depth + 1);
            }
        }
        return sum;
    }
}

//interface NestedInteger {
//	 
//	      // @return true if this NestedInteger holds a single integer,
//	      // rather than a nested list.
//	      public boolean isInteger();
//	 
//	      // @return the single integer that this NestedInteger holds,
//	      // if it holds a single integer
//	      // Return null if this NestedInteger holds a nested list
//	      public Integer getInteger();
//	 
//	      // @return the nested list that this NestedInteger holds,
//	      // if it holds a nested list
//	      // Return null if this NestedInteger holds a single integer
//	      public List<NestedInteger> getList();
//	  }