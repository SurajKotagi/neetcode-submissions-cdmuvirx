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
    public boolean isBalanced(TreeNode root) {
        int ans = helper(root);
        return ans != -1;
    }

    public int helper(TreeNode node){
        if(node == null) return 1;

        int l = helper(node.left);
        if(l == -1) return -1;
        int r = helper(node.right);
        if(r == -1) return -1;
        if(Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }
}
