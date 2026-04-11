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
public class Codec {

    public String serialize(TreeNode root) {
        if(root == null) return "-1";

        String str = root.val + " ";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                TreeNode x = q.remove();
                if (x.left == null) {
                    str += "-1 ";
                } else {
                    str += (x.left.val + " ");
                }

                if (x.right == null) {
                    str += "-1 ";
                } else {
                    str += (x.right.val + " ");
                }

                if(x.left != null) q.add(x.left);
                if(x.right != null) q.add(x.right);
            }
        }
        System.out.print(str);
        return str.substring(0, str.length()-1);
    }

    public void helper(TreeNode root, String[] str){
        if (root.left == null) {
            str[0] += "-1 ";
        } else {
            str[0] += (root.left.val + " ");
        }

        if (root.right == null) {
            str[0] += "-1 ";
        } else {
            str[0] += (root.right.val + " ");
        }

        if(root.left != null) helper(root.left, str);
        if(root.right != null) helper(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(data.split(" ")));
        Queue<TreeNode> parent = new LinkedList<>();
        Queue<TreeNode> child = new LinkedList<>();

        if(arr.get(0).equals("-1")) return null;
        parent.add(new TreeNode(Integer.parseInt(arr.get(0))));
        TreeNode root = parent.peek();
        int i = 0;
        int n = arr.size();
        while(parent.size() > 0){
            TreeNode node = parent.remove();
            if(i*2 + 1 < n && !arr.get(i*2+1).equals("-1")){
                node.left = new TreeNode(Integer.parseInt(arr.get(i*2+1)));
                child.add(node.left);
            }
            if(i*2 + 2 < n && !arr.get(i*2+2).equals("-1")){
                node.right = new TreeNode(Integer.parseInt(arr.get(i*2+2)));
                child.add(node.right);
            }
            if(parent.size() == 0) {
                parent = child;
                child = new LinkedList<>();
            }
            i++;
        }
        return root;
    }
}
