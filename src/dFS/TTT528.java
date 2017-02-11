package dFS;


import java.util.*;

	public class TTT528 implements Iterator<Integer> {
	    
	    LinkedList<Integer> list;
	    ListIterator<Integer> iter;

	    public TTT528(List<NestedInteger> nestedList) {
	        // Initialize your data structure here.
	        list = helper(nestedList);
	        iter = list.listIterator(0);
	    }

	    // @return {int} the next element in the iteration
	    @Override
	    public Integer next() {
	        // Write your code here
	        return iter.next();
	    }

	    // @return {boolean} true if the iteration has more element or false
	    @Override
	    public boolean hasNext() {
	        // Write your code here
	        return iter.hasNext();
	    }

	    @Override
	    public void remove() {}
	    
	    private LinkedList<Integer> helper(List<NestedInteger> nestedList){
	        LinkedList<Integer> res = new LinkedList<Integer>();
	        for(NestedInteger item : nestedList){
	            if(item.isInteger()){
	                res.add(item.getInteger());
	            }
	            else{
	                res.addAll(helper(item.getList()));
	            }
	        }
	        return res;
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
