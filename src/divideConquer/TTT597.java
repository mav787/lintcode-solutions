package divideConquer;

public class TTT597 {
	public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        if(root == null){
            return null;
        }
        helper(root);
        return res;
        
    }
    
    private TreeNode res = null;
    private sumNum global = null;
    
    private sumNum helper(TreeNode node){
        if(node == null){
            return new sumNum(0,0);
        }
        sumNum left = helper(node.left);
        sumNum right = helper(node.right);
        sumNum thisNode = new sumNum(left.sum + right.sum + node.val, left.num + right.num + 1);
            
        if(global == null || (thisNode.sum / (double)thisNode.num) >= (global.sum / (double)global.num)){
            global = thisNode;
            res = node;
        }
        return thisNode;
    }
   
    
    private class sumNum{
        int sum;
        int num;
        sumNum(int s, int n){
            sum = s;
            num = n;
        }
    }
}
