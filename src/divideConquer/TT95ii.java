package divideConquer;

public class TT95ii {
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        return root.val > min && root.val < max && isValidBST(root.left, min, (long)root.val) && isValidBST(root.right, (long)root.val, max);
    }
}
