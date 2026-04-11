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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || k == 0) return head;
        ListNode fixHead = new ListNode(-1);
        ListNode prev = fixHead;
        
        int i = 1;
        ListNode headCopy = head;
        while(head != null){
            if(i % k == 0){
                ListNode a = head.next;
                ListNode temp = headCopy;
                while(headCopy != head){
                    ListNode b = headCopy.next;
                    headCopy.next = a;
                    a = headCopy;
                    headCopy = b;
                    if(headCopy == head){
                        prev.next = headCopy;
                        prev = temp;
                        b.next = a;
                        head = temp.next;
                        headCopy = head;
                    }
                }

            } else {
                head = head.next;
            }
            i++;
        }
        return fixHead.next;
    }
}
