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
    public int kthSmallest(TreeNode root, int k) {
        int[] val = new int[1];
        return helper(root, k, val);
    }
    public int helper(TreeNode node, int k, int[] val){

        if(node == null) return -1;
        int l = helper(node.left,k, val);
        if(l != -1) return l;
        val[0]++;
        if(val[0] == k) return (node.val);
        int r = helper(node.right, k, val);
        if(r != -1) return r;
        return -1;
    }


}
