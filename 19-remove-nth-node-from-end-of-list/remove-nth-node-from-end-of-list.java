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
        if(head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        int d=0;
        while(fast.next!=null){
            fast=fast.next;
            d++;
            while(d>n){
                slow=slow.next;
                d--;
            }
        }
        if(d<n){
            head=head.next;
            return head;
        }
        slow.next=slow.next.next;
        return head;   
    }
}