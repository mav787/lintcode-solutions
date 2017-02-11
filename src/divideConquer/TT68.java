package divideConquer;

import java.util.ArrayList;

public class TT68 {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);
        
        
        res.addAll(left);
        
        res.addAll(right);
        res.add(root.val);
        return res;
    }
}
