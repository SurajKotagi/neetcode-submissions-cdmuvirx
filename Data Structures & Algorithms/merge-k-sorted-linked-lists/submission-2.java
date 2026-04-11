/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode n1 = lists[0];
        ListNode n2 = lists[1];
        if(n1 == null && n2 == null) return null;
        if(n1 == null) return n2;
        if(n2 == null) return n1;
        ListNode ans = lists[0];
       
        ArrayList<ListNode> arr = new ArrayList<>(Arrays.asList(lists));
        HashSet<ListNode> hs = new HashSet<>(arr);
        while(hs.size() > 1){
            hs = new HashSet<>();
            for (int i = 0; i < arr.size();) {
                ListNode p1 = arr.get(i);
                ListNode p2 = i+1>=arr.size()? null : arr.get(i+1);
                ans = merge(p1, p2);
                hs.add(ans);
                i = i + 2;
            }
            arr = new ArrayList(hs);
        }
        return arr.get(0);
    }

    public ListNode merge(ListNode n1, ListNode n2){
        if(n1 == null && n2 == null) return null;
        if(n1 == null) return n2;
        if(n2 == null) return n1;

        ListNode fixHead = n1;
        boolean swap = false;
        if(n2.val < fixHead.val){
            fixHead = n2;
            swap = true;
        }

        if (swap) { 
            while(n1 != null){
                while(n2.next != null && n2.next.val < n1.val){
                    n2 = n2.next;
                }
                if(n2.next == null){
                    n2.next = n1;
                    return fixHead;
                } else {
                    ListNode temp = n2.next;
                    ListNode node = n1;
                    n1 = n1.next;
                    n2 .next = node;
                    node.next = temp;
                }
            }
        } else {
            while(n2 != null){
                while(n1.next != null && n1.next.val < n2.val){
                    n1 = n1.next;
                }
                if(n1.next == null){
                    n1.next = n2;
                    return fixHead;
                } else {
                    ListNode temp = n1.next;
                    ListNode node = n2;
                    n2 = n2.next;
                    n1 .next = node;
                    node.next = temp;
                }
            }
        }
        return fixHead;
    }
}
