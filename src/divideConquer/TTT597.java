package divideConquer;

public class TTT597 {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
     
    private TreeNode ans = null;
    private double maxavg = Double.MIN_VALUE;
    
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        if(root == null) return null;
        helper(root);
        return ans;
    }
    
    private SumNum helper(TreeNode node){
        if(node == null){
            return new SumNum(0, 0);
        }
        // calculate the return value;
        SumNum left = helper(node.left);
        SumNum right = helper(node.right);
        int thissum = left.sum + right.sum + node.val;
        int thisnum = left.num + right.num + 1;
        double avg = (double)thissum / thisnum;
        if(ans == null || avg > maxavg){
            maxavg = avg;
            ans = node;
        }
        return new SumNum(thissum, thisnum);
    }
}

class SumNum{
    int sum;
    int num;
    SumNum(int s, int n){
        sum = s;
        num = n;
    }
}