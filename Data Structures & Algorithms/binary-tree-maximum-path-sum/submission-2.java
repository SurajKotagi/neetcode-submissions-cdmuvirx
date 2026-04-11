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
    int ans;
    public int maxPathSum(TreeNode root) {
        ans = -1001;
        helper(root); 
        return ans;
    }
    public int helper(TreeNode root){
        if(root == null) return -1001;
        int opt1 = root.val;
        int opt2 = helper(root.left)  + opt1;
        int opt3 = helper(root.right) + opt1;

        ans = Math.max(ans, opt1);
        ans = Math.max(ans, opt2);
        ans = Math.max(ans, opt3);
        ans = Math.max(ans, opt2 + opt3 - opt1);
        
        return Math.max(Math.max(opt1, opt2),opt3);
    }
}
