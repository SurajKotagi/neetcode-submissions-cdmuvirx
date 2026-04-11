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
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode ll2 = reverseLL(slow.next);
        slow.next = null;
        ListNode ll1 = head;
// 2   4  6
// 10  8 
        while(ll1 != null && ll2 != null){
            ListNode temp = ll1.next;
            ll1.next = ll2;
            ListNode temp2 = ll2.next;
            if(temp == null) break;
            ll2.next = temp;
            ll1 = temp;
            ll2 = temp2;
        }
    }

    public ListNode reverseLL(ListNode head){
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    } 
}
