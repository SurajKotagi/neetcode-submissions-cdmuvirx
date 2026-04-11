/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        int [] val = new int[2];
        val[0] = Integer.MIN_VALUE;
        val[1] = Integer.MAX_VALUE;
        return helper(root, val);
    }
    public boolean helper(TreeNode node, int[] val) {
        if(node == null) return true;
        
        boolean b1 = helper(node.left, val);
        boolean l = (node.val > val[0]);
        val[0] = Math.max(val[0], node.val);
        
        boolean b2 = helper(node.right, val);
        // boolean r = (node.val < val[1]);
        // val[1] = Math.min(node.val, val[1]);
        
        return b1 && b2 && l;
    }


}
