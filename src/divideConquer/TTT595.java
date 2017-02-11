package divideConquer;

public class TTT595 {
	 private int global;
	    public int longestConsecutive(TreeNode root) {
	        // Write your code here
	        if(root == null){
	            return 0;
	        }
	        global = 1;
	        helper(root);
	        return global;
	    }
	    
	    private int helper(TreeNode node){
	        if(node == null){
	            return 0;
	        }
	        
	        int thislength = 1;
	        int left = helper(node.left);
	        int right = helper(node.right);
	        
	        if(node.left != null && node.val + 1 == node.left.val){
	            thislength = Math.max(thislength,left + 1);
	        }
	        if(node.right != null && node.val + 1 == node.right.val){
	            thislength = Math.max(thislength, right + 1);
	        }
	        
	        if(thislength > global){
	            global = thislength;
	        }
	        return thislength;
	    }
}
