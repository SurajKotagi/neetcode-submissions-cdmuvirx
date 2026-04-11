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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean [] isSubtree = new boolean[1];
        find(root, subRoot.val, isSubtree, subRoot);
        return isSubtree[0];
    }
    public void find(TreeNode node, int val, boolean [] isSubtree, TreeNode subRoot){
        if(isSubtree[0] == true) return;
        if(node.val == val) {
            if(helper(node, subRoot)){
                isSubtree[0] = true;
                return;
            }
        }

        if(node.left != null)
            find(node.left, val, isSubtree, subRoot);
        
        if(node.right != null)
            find(node.right, val, isSubtree, subRoot);

    }
    public boolean helper(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null && node2 != null) return false;
        if(node2 == null && node1 != null) return false;
        if(node1.val != node2.val) return false;

        boolean l = helper(node1.left, node2.left);
        boolean r = helper(node1.right, node2.right);
        if(l && r) return true;
        return false;
    }
}
