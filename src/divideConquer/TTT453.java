package divideConquer;

public class TTT453 {
	public void flatten(TreeNode root) {
        // write your code here
        if(root == null){
            return;
        }
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        TreeNode node = left;
        
        if(node != null){
            while(node.right != null){
                node = node.right;
            }
            // link
            node.right = right;
        }
        // if left is null : broken....
        if(left != null){
            root.right = left;
        }
        root.left = null;
        
        return root;
    }
}
