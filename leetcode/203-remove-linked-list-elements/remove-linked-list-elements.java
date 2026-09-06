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
    public ListNode removeElements(ListNode head, int val) {
        //we will start from head and traverse the whole ll while checking the next node val 
        //we will always check the next node val 
        //firstly we will check head seprately
        if(head==null){
            return null;
        }
        //remove matching nodes from begining
        
        while(head!=null&&head.val==val){
            head=head.next;
        }
        //(this case is when we delete all nodes from front) 
        if(head==null){
            return null;
        }
        ListNode curr=head;
        //here we check the next node 
        //we will only move forward if our next.val!=val
        //as there can be continous nodes with same values
        while(curr.next!=null){
            //check if next node has val
            if(curr.next.val==val){
                //delete next node 
                curr.next=curr.next.next;
            }
            //only move forward if next node val is different
            else{
                curr=curr.next;
            }
        }
        return head;
        
    }
}
