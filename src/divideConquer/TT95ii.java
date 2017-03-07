package divideConquer;

public class TT95ii {
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        // 1. recursion
        return isValidBST(root.left, min, (long)root.val) && isValidBST(root.right, (long)root.val, max) &&
        // 2. rule for this node
        (long)root.val > min && (long)root.val < max;
    }
}
