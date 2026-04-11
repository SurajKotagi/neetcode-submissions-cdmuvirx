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
    class Pair {
        ListNode node;
        int size;
        Pair(ListNode node, int size){
            this.node = node;
            this.size = size;
        }
    }

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode ans = new ListNode(0);
        ListNode ansHead = ans;
        int carry = 0;
        while(node1 != null && node2 != null) {
            int sum = node1.val + node2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.next = new ListNode(sum);
            ans = ans.next;

            node1 = node1.next;
            node2 = node2.next;
        }
        while(node2 != null) {
            int sum = node2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.next = new ListNode(sum);
            ans = ans.next;

            node2 = node2.next;
        }
        while(node1 != null) {
            int sum = node1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.next = new ListNode(sum);
            ans = ans.next;

            node1 = node1.next;
        }
        if(carry == 1){
            ans.next = new ListNode(1);
            ans = ans.next;
        }
        return ansHead.next;
    }

    public Pair reverseLL(ListNode node){
        ListNode prev = null;
        int size = 0;
        while(node != null){
            size++;
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return new Pair(prev, size);
    }
}
