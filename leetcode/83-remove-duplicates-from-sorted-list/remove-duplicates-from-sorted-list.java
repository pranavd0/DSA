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
    public ListNode deleteDuplicates(ListNode head) {
        //as we have already given the sorted ll
        //all the duplicates value will be continous(if present)
        //hence we will just compare the value of next node with current node if it equals delete the node
        //as we have to delete the node we must present one node behind the deletable node
        //hence we will always check the next node val
        if(head==null){
            return null;
        }
        ListNode curr=head;
        while(curr.next!=null){
            if(curr.next.val==curr.val){
                curr.next=curr.next.next;
            }
            //most imp point
            //move forward only if next node values is not equal to curr
            //as there could be continous set of same value 
            //hence we cannot move forward at every iteration
            else{
                curr=curr.next;
            }

        }
        return head;

    }
}