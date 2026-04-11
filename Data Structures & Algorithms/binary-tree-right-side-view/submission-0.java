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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(ans, root);
        return ans;
    }

    public void helper(List<Integer> ans, TreeNode node){
        Queue<TreeNode> q = new ArrayDeque<>();
        if(node != null) q.add(node);

        while(q.size() > 0){
            int sz = q.size();
            for(int i = 0 ; i < sz; i++){
                TreeNode x = q.remove();
                if(x.left != null) q.add(x.left);
                if(x.right != null) q.add(x.right);
                if(i == sz-1) ans.add(x.val);
            }
        }
    }
}
