package divideConquer;

public class TTT596 {
	 private TreeNode res = null;
     private int minSum = Integer.MAX_VALUE;
     
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if(root == null){
            return null;
        }
        helper(root);
        return res;
    }
    
    
    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        int thisSum = leftSum + rightSum + node.val;
        
        if(thisSum < minSum){
            res = node;
            minSum = thisSum;
        }
        return thisSum;
    }
}
