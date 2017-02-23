package divideConquer;

public class TTT453my {
	public void flatten(TreeNode root) {
        // write your code here
        if(root == null) return;
        
        TreeNode left = root.left;
        flatten(root.left);
        root.left = null;
        
        flatten(root.right);
        TreeNode right = root.right;
        
        TreeNode curr = left;
        while(curr != null && curr.right != null){
            curr = curr.right;
        }
        
        if(curr == null){
            return;
        }
        else{
            root.right = left;
            curr.right = right;
            return;
        }
    }
}
