class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode curr = prev.next;
            ListNode next = curr.next;

            // Swap the pair
            curr.next = next.next;
            next.next = curr;
            prev.next = next;

            // Move to the next pair
            prev = curr;
        }

        return dummy.next;
    }
}
