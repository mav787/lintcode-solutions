package divideConquer;

public class TT95helperclass {
	public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null)
            return true;
        return helper(root).isValid;
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(Long.MAX_VALUE, Long.MIN_VALUE, true);
        }
        
        // if(root.left == null && root.right == null)
        //     return new ResultType(root.val, root.val, true);
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if(left.isValid == false || right.isValid == false){
            return new ResultType(0, 0, false);
        }
        boolean isValid = false;
        isValid = root.val > left.max && root.val < right.min;
        return new ResultType(Math.min(left.min, root.val), Math.max(right.max, root.val), isValid);
        
    }
    
    private class ResultType{
        long min;
        long max;
        boolean isValid;
        ResultType(long min, long max, boolean v){
            this.min = min;
            this.max = max;
            isValid = v;
        }
    }
}
