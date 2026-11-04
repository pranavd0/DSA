# Permute Arrays for Sum Threshold

- Platform: GeeksforGeeks
- Language: Java
- Difficulty: Easy
- Topics: Arrays, Sorting
- Runtime: N/A
- Memory: N/A
- Problem URL: https://www.geeksforgeeks.org/problems/permutations-in-array1747/1
- Synced: 2026-11-04T05:12:37.563Z

## Problem Description

<p><span style="font-size: 18px;">Given two arrays <strong>a[]</strong>, <strong>b[]</strong>, and an integer <strong>k</strong>, find if it is possible to permute both arrays such that for every index i, arr1[i] + arr2[i] &ge; k.&nbsp;</span></p><p><span style="font-size: 18px;"><strong>Examples:</strong></span></p><pre><span style="font-size: 18px;"><strong>Input: </strong>k = 10, a[] = [2, 1, 3], b[] = [7, 8, 9]. <strong>Output: </strong>true <strong>Explanation: </strong>Permutation arr1[] = [1, 2, 3] and arr2[] = [9, 8, 7] satisfy the condition arr1[i] + arr2[i] &gt;= k</span></pre><pre><span style="font-size: 18px;"><strong>Input: </strong>k = 5, a[] = [1, 2, 2, 1], b[] = [3, 3, 3, 4]. <strong>Output: </strong>false</span> <span style="font-size: 18px;"><strong><span style="font-size: 18px;">Explanation:</span> </strong></span><span style="font-size: 18px;">Since any permutation won't give the answer.</span></pre><p><span style="font-size: 18px;"><strong>Constraints:</strong><br />1 &le; arr.size() &le; 10<sup>5<br /></sup></span><span style="font-size: 18px;">0 &le; k &le; 10<sup>5</sup><br />0 &le; arr1[i], arr2[i]&le; 2*10<sup>5</sup></span></p>

## Explanation

This solution was accepted on GeeksforGeeks using Java. The detected topics are Arrays, Sorting. Review the synced source file for the implementation details.
