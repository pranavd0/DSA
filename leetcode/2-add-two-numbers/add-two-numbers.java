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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //here in this question we will perform node node by addition 
        //it is possible as the digits are given in reverse order 
        //while performing addition at each node we add result in new linked list
        //also we have to handle the carry(heance we add result%10 in answer linked list and result/10 in carry)
        //to make new node at each iteration for answer linked list 
        //we will add the value in first node Manually so we can made new node for each iteration while adding value in it
        //as we have syntax current_node.next=new ListNode(val);
        //we have to create new node from the previous node only 
        //thats why we have to intialise the first node.
        //we have to also handle the condition of different length linked lists
        //At that situattion we will add only carry +that node value in answer linked list
        //there is one more condition:
        //even after all addition if we have carry 
        //than we have add it in new node
        ListNode curr1=l1.next;
        ListNode curr2=l2.next;
        ListNode head=new ListNode((l1.val+l2.val)%10);
        ListNode ans=head;
        int carry=(l1.val+l2.val)/10;
        while(curr1!=null&&curr2!=null){
            int result = curr1.val + curr2.val + carry;
            ans.next=new ListNode(result % 10);
            carry = result / 10;
            ans=ans.next;
            curr2=curr2.next;
            curr1=curr1.next;
        }
        if(curr1==null&&curr2!=null){
            while(curr2!=null){
                int result=curr2.val+carry;
                ans.next=new ListNode(result%10);
                carry=result/10;
                curr2=curr2.next;
                ans=ans.next;
            }
        }
        if(curr2==null&&curr1!=null){
            while(curr1!=null){
                int result=curr1.val+carry;
                ans.next=new ListNode(result%10);
                carry=result/10;
                curr1=curr1.next;
                ans=ans.next;
            }
        }
        if(carry>0){
            ans.next=new ListNode(carry);
        }
        return head;
        
    }
}