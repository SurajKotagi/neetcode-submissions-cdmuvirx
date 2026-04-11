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
    public int diameterOfBinaryTree(TreeNode root) {
        int [] ans = new int[1];
        helper(root, ans);
        return ans[0] - 1;
    }

    void helper(TreeNode node, int[] ans){
        if(node == null) return;
        int ls = dfs(node.left);
        int rs = dfs(node.right);
        ans[0] = Math.max(ls+rs+1, ans[0]);
        helper(node.left, ans);
        helper(node.right, ans);
    }

    public int dfs(TreeNode node){
        if(node == null) return 0;
        int ls = dfs(node.left);
        int rs = dfs(node.right);
        return Math.max(ls, rs) + 1;
    } 
}
