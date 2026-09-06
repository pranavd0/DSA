

public class Floyds_SlowFast {
    /*Follow this order:
    🟢 Level 1 — Understand the movement
    1. 876 — Middle of the Linked List
    2. 141 — Linked List Cycle ← You are here
    🟢 Level 2 — Basic applications
    3. 202 — Happy Number
    4. 19 — Remove Nth Node From End
    🟡 Level 3 — Multiple pointer techniques
    5. 234 — Palindrome Linked List
    6. 2095 — Delete the Middle Node
    🟡 Level 4 — Cycle mastery
    7. 142 — Linked List Cycle II
    8. 287 — Find the Duplicate Number
    🟡 Level 5 — Advanced combinations
    9. 143 — Reorder List
    10. 2130 — Maximum Twin Sum of a Linked List
    */
    boolean l202isHappy(int n) {
        //in this question after analysisng it we can say that there will be always a cycle if the number is unhappy
        //cycle in the sense the specific number will repeat after fixed distance
        //if the number is happy 1 will repeat in ending
        //hence we can use slow fast approach here for cycle detection 
        //even if the cycle is not present 1 will repeat which will stop our loop(make fast and slow equal)
        //to move slow and fast we will need helper function.
        int slow=n;
        int fast=n;
        //initialising slow and fast to fit in looop
        slow=nextint(slow);
        fast=nextint(nextint(fast));
        //Floyds cycle detection loop
        while(slow!=fast){
            slow=nextint(slow);
            fast=nextint(nextint(fast));
        }
        //if loop stops on 1 number is happy
        return slow==1;        
    }         
    int nextint(int a){
        int sum=0;
        while(a>0){
            int k=a%10;
            sum+=k*k;
            a=a/10;
        }
        return sum;
    }
    ListNode l19removeNthFromEnd(ListNode head, int n) {
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


