package divideConquer;

import java.util.ArrayList;

public class TT66 {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        res.add(root.val);
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
        res.addAll(left);
        res.addAll(right);
        return res;
    }
}
