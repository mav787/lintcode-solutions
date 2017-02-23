package divideConquer;

import java.util.*;

public class TTT376 {
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        ArrayList<Integer> path = new ArrayList<>();
        int sum = 0;
        path.add(root.val);
        sum += root.val;
        helper(root, res, path, sum, target);
        return res;
    }
    
    
    private void helper(TreeNode root, ArrayList<List<Integer>> res, ArrayList<Integer> path, int sum, int target){
        if(root.left == null && root.right == null){
            if(sum == target){
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        if(root.left != null){
            path.add(root.left.val);
            // recursive call
            helper(root.left, res, path, sum + root.left.val, target);
            path.remove(path.size() - 1);
        }
        
        if(root.right != null){
            path.add(root.right.val);
            // recursive call
            helper(root.right, res, path, sum + root.right.val, target);
            path.remove(path.size() - 1);
        }
    }
}

 
