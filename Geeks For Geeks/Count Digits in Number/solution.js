/*
 * Platform: GeeksforGeeks
 * Problem: Count Digits in Number
 * URL: https://www.geeksforgeeks.org/problems/count-total-digits-in-a-number/1
 * Language: JavaScript
 * Difficulty: Easy
 * Topics: Recursion
 * Runtime: 0.11 s
 * Memory: N/A
 * Synced: 2026-10-25T05:30:53.588Z
 */

/**
 * @param {number} n
 * @returns {number}
 */
class Solution {
    countDigits(n) {
        // Code here
        if(n == 0)
        {
            return 1
        }
        
        let iCount = 0
        
        while(n != 0)
        {
            iCount++
            n = Math.floor(n/10)
        }
        
        return iCount
    }
}
