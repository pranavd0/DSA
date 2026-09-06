/*
 * Platform: GeeksforGeeks
 * Problem: Remove Duplicates from Linked List
 * URL: https://www.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Amazon, Intuit, Linked List
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-09-06T20:53:50.731Z
 */

Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/
class Solution {
    public Node removeDuplicates(Node head) {
        // code here
        if(head==null){
                    return null;
                }
                HashSet<Integer> hs= new HashSet<>();
                Node curr=head;
                hs.add(head.data);
                while(curr.next!=null){
                    //if hashset contains the number delete the node
                    if(hs.contains(curr.next.data)){
                        curr.next=curr.next.next;
                    }
                    //most imp point
                    //move forward only if next node values is not contained in our hashset
                    //as there could be continous set of same value 
                    //hence we cannot move forward at every iteration
                    else{
                        hs.add(curr.next.data);
                        curr=curr.next;
                    }

                }
                return head;
    }
}
