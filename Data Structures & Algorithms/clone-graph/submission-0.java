/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node root) {
        if(root == null) return null;
        HashMap<Integer, Node> hm = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> c = new ArrayDeque<>();
        q.add(root);

        Node rootC = null;
        boolean rootFlag = true;
        while (q.size() > 0) {
            Node node = q.remove();
            Node nodeC = hm.getOrDefault(node.val, new Node(node.val));
            hm.put(nodeC.val, nodeC);

            nodeC.neighbors = new ArrayList<>();
            for(Node nei : node.neighbors){
                if (!hm.containsKey(nei.val)) {
                    Node x = new Node(nei.val);
                    hm.put(x.val, x);

                    q.add(nei);
                    c.add(x);
                }
                nodeC.neighbors.add(hm.get(nei.val));
            }

            if(rootFlag){
                rootC = nodeC;
                rootFlag = false;
            }
        }
        return rootC;
    }
}