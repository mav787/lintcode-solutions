package divideConquerWithoutGV;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class TTT597 {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        if(root == null) return null;
        return helper(root).ans;
    }
    
    private SumNum helper(TreeNode root){
        if(root == null){
            return new SumNum(0, 0, Double.MIN_VALUE, null);
        }
        
        SumNum left = helper(root.left);
        SumNum right = helper(root.right);
        
        // calculate itself
        int thissum = left.sum + right.sum + root.val;
        int thisnum = left.num + right.num + 1;
        double thisavg = (double)thissum / thisnum;
        
        if(thisavg > Math.max(left.maxavg, right.maxavg)){
            // updates..
            return new SumNum(thissum, thisnum, thisavg, root);
        }
        else{
            if(left.maxavg > right.maxavg){
                return new SumNum(thissum, thisnum, left.maxavg, left.ans);
            }
            else{
                return new SumNum(thissum, thisnum, right.maxavg, right.ans);
            }
        }
    }
    
    
    private class SumNum{
        int sum;
        int num;
        //double avg;
        double maxavg;
        TreeNode ans;
        
        SumNum(int s, int n, double mavg, TreeNode node){
            sum = s;
            num = n;
            //avg = (double)s / n;
            maxavg = mavg;
            ans = node;
        }
    }
}
