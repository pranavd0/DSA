/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //store the value of next node in given node and than delete next node
        node.val=node.next.val;
        node.next=node.next.next;
    }
}