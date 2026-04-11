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
        // if(lists[1].val < ans.val){
        //     ans = lists[1];
        // }
        for (int i = 0; i < lists.length - 1; i++) {
        // for (int i = 0; i < 1; i++) {
            ans = merge(ans, lists[i+1]);
            // ListNode temp = ans;
            // while(temp!= null) {
            //     System.out.print(temp.val + "->");
            //     temp = temp.next;
            // }
        }
        return ans;
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
