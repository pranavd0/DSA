/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //add each node in hashset
        // traverse and check it in hashset 
        if(head==null||head.next==null){
            return false;
        }
        HashSet<ListNode> hs=new HashSet<>();
        ListNode current=head;
        while(current.next!=null){
            if(hs.contains(current)){
                return true;
            }
            hs.add(current);
            current=current.next;
        }
        return false;
    }
}