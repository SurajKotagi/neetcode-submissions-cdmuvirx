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
    public int goodNodes(TreeNode root) {
        int[] ans= new int[1];
        helper(root, -101, ans);
        return ans[0];
    }

    public void helper(TreeNode node, int max, int [] ans){
        if(node == null) return;
        if(node.val >= max){
            max = node.val;
            ans[0]++;
        }
        helper(node.left, max, ans);
        helper(node.right, max, ans);
    }
}
