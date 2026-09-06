/*
 * Platform: GeeksforGeeks
 * Problem: Delete Node Without Linked List Head
 * URL: https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Amazon, Microsoft, Samsung, Visa, Goldman Sachs, Linked List
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-09-06T21:08:34.688Z
 */

/* Structure of Linked List Node
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/
class Solution {
    public void deleteNode(Node x) {
        // code here
        x.data=x.next.data;
                x.next=x.next.next;
                
    }
}
