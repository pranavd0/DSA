/*
 * Platform: GeeksforGeeks
 * Problem: Sum Of Digits
 * URL: https://www.geeksforgeeks.org/problems/sum-of-digits1742/1
 * Language: JavaScript
 * Difficulty: Easy
 * Topics: Drishti-Soft, Number Theory
 * Runtime: 0.07 s
 * Memory: N/A
 * Synced: 2026-10-25T05:26:11.188Z
 */

/**
 * @param {number} n
 * @return {number}
 */

class Solution {
    sumOfDigits(n) {
        // code here
        let iSum = 0
        
        while(n != 0)
        {
            iSum += n%10
            n = Math.floor(n/10) 
        }
        
        return iSum
    }
}
