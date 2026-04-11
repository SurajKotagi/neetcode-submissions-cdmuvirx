/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node copyHead = new Node(head.val);
        Node fixHead = copyHead;
        HashMap<Node, Node> hm = new HashMap<>();
        hm.put(head, copyHead);
        while (head != null){
            Node hNext = head.next;
            Node hRandom = head.random;
    
            if (hNext == null) {
                copyHead.next = null;
            } else {
                if(hm.containsKey(hNext)){
                    copyHead.next = hm.get(hNext);
                } else {
                    Node temp = new Node(hNext.val);
                    hm.put(hNext, temp);
                    copyHead.next = temp;
                }
            }

            if (hRandom == null) {
                copyHead.random = null;
            } else {
                if(hm.containsKey(hRandom)){
                    copyHead.random = hm.get(hRandom);
                } else {
                    Node temp = new Node(hRandom.val);
                    hm.put(hRandom, temp);
                    copyHead.random = temp;
                }
            }

            copyHead = copyHead.next;
            head = head.next;
        }
        return fixHead;
    }
}
