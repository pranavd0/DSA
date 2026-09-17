/*
 * Platform: GeeksforGeeks
 * Problem: 1 to n Without Loop
 * URL: https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Recursion
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-09-17T06:16:11.000Z
 */

class Solution {
    public void printNos(int n) {
        // Base case: if n is 0, stop recursion
        if (n == 0) {
            return;
        }
        
        // Recursive call with n - 1 to print smaller numbers first
        printNos(n - 1);
        
        // Print the current number followed by space
        System.out.print(n + " ");
    }
}
