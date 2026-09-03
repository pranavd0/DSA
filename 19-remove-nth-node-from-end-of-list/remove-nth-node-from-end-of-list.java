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
        //as we have given node to be deleted from last 
        //we can use 2 pointers which maintains the same distance between 
        //hence whenever one pointer is at end other pointer is at n distance from it
        //so we can easily delete that node 
        //we will maintain distance between the pointers

        if(head.next==null){
            return null;
        }
        //fast will move fast and go to the end 
        //while slow will maintain distance 
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
        //even after reaching the end our n is greater than the distance it means 
        //they are telling us to delete first node 
        if(d<n){
            head=head.next;
            return head;
        }
        slow.next=slow.next.next;
        return head;   
    }
}