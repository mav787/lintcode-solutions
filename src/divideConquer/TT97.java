package divideConquer;

public class TT97 {
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
