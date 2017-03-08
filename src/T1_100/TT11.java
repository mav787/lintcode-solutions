package T1_100;
import java.util.*;

public class TT11 {
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null || k1 > k2)
            return res;
        inOrderTraversal(root, res, k1, k2);
        return res; 
    }
    
    private void inOrderTraversal(TreeNode root, ArrayList<Integer> res, int k1, int k2){
        if(root == null)
            return;
        if(root.val > k1)
            inOrderTraversal(root.left, res, k1, k2);
        if(root.val >= k1 && root.val <= k2)
            res.add(root.val);
        if(root.val < k2)
            inOrderTraversal(root.right, res, k1, k2);
    }
}
