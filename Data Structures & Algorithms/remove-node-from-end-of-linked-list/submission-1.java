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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        if(len == 1) return null;

        int deleteI = len - n - 1;
        if(deleteI == -1) return head.next;
        temp = head;
        while(deleteI != 0){
            temp = temp.next;
            deleteI--; 
        }
        temp.next = temp.next.next;
        return head;
    }
}
