package divideConquer;

public class TTT475 {
	public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) return 0;
 

        return Math.max(maxPathSum2(root.left), Math.max(maxPathSum2(root.right),0)) + root.val;
    }
}
