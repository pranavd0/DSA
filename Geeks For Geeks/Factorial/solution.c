/*
 * Platform: GeeksforGeeks
 * Problem: Factorial
 * URL: https://www.geeksforgeeks.org/problems/factorial5739/1
 * Language: C
 * Difficulty: Easy
 * Topics: Morgan Stanley, Samsung, FactSet, MAQ Software, Wipro, Mathematics
 * Runtime: 0.01 s
 * Memory: N/A
 * Synced: 2026-10-17T13:45:57.502Z
 */

class Solution {
  public:
    int factorial(int n) {
        // code here
        int iPro=1;
        for(int i=1;i<=n;i++)
        {
            iPro*=i;
        }
        return iPro;
    }
};
