package divideConquer;

public class TTT448 {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here

        TreeNode successor = null;
        while (root != null && root.val != p.val){
            if (root.val < p.val){
                root = root.right;
            }
            else {
                successor = root;
                root = root.left;
            }
        }
        
        if (root == null) return null;
        
        if (root.right == null) return successor;
        root = root.right;
        while (root.left != null){
            root = root.left;
        }
        return root;
        
    }
}
