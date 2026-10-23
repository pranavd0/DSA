/*
 * Platform: GeeksforGeeks
 * Problem: Palindrome Number
 * URL: https://www.geeksforgeeks.org/problems/palindrome0746/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Zoho, Samsung, Oracle, Adobe, palindrome
 * Runtime: 0.16 s
 * Memory: N/A
 * Synced: 2026-10-23T18:54:24.296Z
 */

class Solution {
    public boolean isPalindrome(int n) {
        // code here
        int a =n;
        int num = 0;
        
        
        while(a!=0)
        {
            num = num * 10 + a % 10;
            a /= 10;
        }
        
        return (num == n);
    }
}
