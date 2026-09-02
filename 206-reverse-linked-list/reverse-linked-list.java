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
    public ListNode reverseList(ListNode head) {

        // Previous node starts as null
        ListNode previous = null;

        // Current node starts from head
        ListNode current = head;

        while (current != null) {

            // 1. Save the next node
            ListNode next = current.next;

            // 2. Reverse the link
            current.next = previous;

            // 3. Move previous forward
            previous = current;

            // 4. Move current forward
            current = next;
        }

        // Previous becomes the new head
        return previous;
    }
}