package divideConquer;

public class TT95 {
	public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }
        
        boolean isValidLeft = isValidBST(root.left);
        boolean isValidRight = isValidBST(root.right);
        boolean isGreater = true, isLessThan = true;
        if(root.left != null){
            isGreater = root.val > maxValue(root.left);
        }
        if(root.right != null){
            isLessThan = root.val < minValue(root.right);
        }
        
        boolean res = isValidLeft && isValidRight && isGreater && isLessThan;
        return res;
    
    }
    
    
    private int maxValue(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node.val;
    }
    
    private int minValue(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node.val;
    }
}
