package divideConquer;

public class TT93 {
	public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null || maxDepth(root) <= 1) return true;
        
        //divide
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        boolean bal = Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        
        //mix
        return left && right && bal;
    }
    
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
        
    }
}
