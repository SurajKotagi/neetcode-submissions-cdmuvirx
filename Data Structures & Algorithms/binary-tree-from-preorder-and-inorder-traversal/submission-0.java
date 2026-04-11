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
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        int n = preOrder.length;
        for(int i = 0; i < n; i++){
            inMap.put(inOrder[i], i);
        }
        return helper(0, n-1, 0, n-1, preOrder, inMap);
    }

    public TreeNode helper(int pst, int pen,
                           int ist, int ien,
                           int[] preOrder,
                           HashMap<Integer, Integer> hm){
        int n = preOrder.length;
        if(pst > pen || pst >= n || pen < 0) return null;
        if(pst == pen) return new TreeNode(preOrder[pst]);

        TreeNode root = new TreeNode(preOrder[pst]);
        int idx = hm.get(root.val);
        int lelm = idx - ist;
        root.left = helper(pst+1, pst+lelm, ist, idx-1, preOrder, hm);
        root.right = helper(pst+lelm+1, pen, idx+1, ien, preOrder, hm);
        return root; 
    }
}
