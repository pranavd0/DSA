# Remove Duplicates from Linked List

- Platform: GeeksforGeeks
- Language: class Solution: def removeDuplicates(self, head): current = head while current: runner = current while runner.next: if runner.next.data == current.data: runner.next = runner.next.next else: runner = runner.next current = current.next return head
- Difficulty: Unknown
- Topics: Expected Complexities, Company Tags AmazonIntuit, Company Tags, Amazon, Intuit, Topic Tags, Linked List, Related Interview Experiences
- Runtime: N/A
- Memory: N/A
- Problem URL: https://www.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
- Synced: 2026-09-06T20:53:50.731Z

## Problem Description

Given a head of an unsorted linked list. Remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node which appeared first should be kept, all other duplicates are to be removed. Examples: Input: head = 5 -> 2 -> 2 -> 4 Output: 5 -> 2 -> 4 Explanation: Given linked list elements are 5 -> 2 -> 2 -> 4, in which 2 is repeated only. So, we will delete the extra repeated elements 2 from the linked list and the resultant linked list will contain 5->2->4 Input: head = 2 -> 2 -> 2 -> 2 -> 2 Output: 2 Explanation: Given linked list elements are 2 -> 2 -> 2 -> 2 -> 2, in which 2 is repeated. So, we will delete the extra repeated elements 2 from the linked list and the resultant linked list will contain only 2.

## Explanation

This solution was accepted on GeeksforGeeks using class Solution: def removeDuplicates(self, head): current = head while current: runner = current while runner.next: if runner.next.data == current.data: runner.next = runner.next.next else: runner = runner.next current = current.next return head. The detected topics are Expected Complexities, Company Tags AmazonIntuit, Company Tags, Amazon, Intuit, Topic Tags, Linked List, Related Interview Experiences. Review the synced source file for the implementation details.
