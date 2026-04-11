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
        ArrayList<ListNode> arrL = new ArrayList<>();
        ListNode t = head;
        while(t != null){
            arrL.add(t);
            t = t.next;
        }
        int i = 0;
        int j = arrL.size()-1;
        ListNode x = new ListNode(0);
        ListNode y = x;
        while(i <= j){
            x.next = arrL.get(i);
            x = x.next;

            if(i != j){
                x.next = arrL.get(j--);
                x = x.next;
            } 
            i++;
        }
        x.next = null;
        head = y.next;
    }
}
