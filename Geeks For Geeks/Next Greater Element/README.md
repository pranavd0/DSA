# Next Greater Element

- Platform: GeeksforGeeks
- Language: Java
- Difficulty: Medium
- Topics: Flipkart, Amazon, Microsoft, MakeMyTrip, Adobe, Stack
- Runtime: N/A
- Memory: N/A
- Problem URL: https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
- Synced: 2026-11-04T05:09:18.743Z

## Problem Description

<p><span style="font-size: 18px;">You are given an array <strong>arr[]</strong> of integers, the task is to find the next greater for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right<strong> </strong>which is greater than the current element.<br />If there does not exist next greater of current element, then next greater element for current element is <strong>-1</strong>.</span></p><p><span style="font-size: 18px;"><strong>Examples<br /></strong></span></p><pre><span style="font-size: 18px;"><strong>Input:</strong> arr[] = [1, 3, 2, 4] <strong>Output:</strong> [3, 4, 4, -1] <strong>Explanation:</strong> The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1. </span></pre><pre><span style="font-size: 18px;"><strong>Input</strong>: arr[] = [6, 8, 0, 1, 3] <strong>Output</strong>: [8, -1, 1, 3, -1] <strong>Explanation</strong>: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1, for 1 it is 3 and then for 3 there is no larger element on right and hence -1.</span></pre><pre><span style="font-size: 18px;"><strong>Input</strong>: arr[] = [1, 2, 3, 5] <strong>Output</strong>: [2, 3, 5, -1] <strong>Explanation</strong>: For a sorted array, the next element is next greater element also except for the last element.</span></pre><pre><span style="font-size: 18px;"><strong style="font-size: 18px;">Input</strong><span style="font-size: 18px;">: arr[] = [5, 4, 3, 1] </span><strong style="font-size: 18px;">Output</strong><span style="font-size: 18px;">: [-1, -1, -1, -1] </span><strong style="font-size: 18px;">Explanation</strong><span style="font-size: 18px;">: There is no next greater element for any of the elements in the array, so all are -1.</span></span></pre>

## Explanation

This solution was accepted on GeeksforGeeks using Java. The detected topics are Flipkart, Amazon, Microsoft, MakeMyTrip, Adobe, Stack. Review the synced source file for the implementation details.
