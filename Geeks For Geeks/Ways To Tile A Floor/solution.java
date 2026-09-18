/*
 * Platform: GeeksforGeeks
 * Problem: Ways To Tile A Floor
 * URL: https://www.geeksforgeeks.org/problems/ways-to-tile-a-floor5836/1
 * Language: Java
 * Difficulty: Medium
 * Topics: Fibonacci, Dynamic Programming, Recursion
 * Runtime: 0.15 s
 * Memory: N/A
 * Synced: 2026-09-18T20:41:08.000Z
 */

class Solution {
    public int numberOfWays(int n) {
        //here we will start filling tiles one by one 
        //at each stage we have two choices:
        //1.horizontal (than remaining space will be n-2 as the length of tile is 2)
        //2.vertical (than remaining space will be n-1 as the breadth of the tile is 1)

        //bottom up approach
        int dp[] = new int[n + 1];
        return solve(n, dp);
    }

    int solve(int n, int dp[]) {
        //step 1 define relation: f(n) = f(n-1) + f(n-2)
        //step 2 base case
        if (n == 0 || n == 1) {
            return 1;
        }

        //step 3 inner call with memoization
        int fnm1 = 0;
        if (dp[n - 1] != 0) {
            fnm1 = dp[n - 1];
        } else {
            fnm1 = solve(n - 1, dp);
            dp[n - 1] = fnm1;
        }

        int fnm2 = 0;
        if (dp[n - 2] != 0) {
            fnm2 = dp[n - 2];
        } else {
            fnm2 = solve(n - 2, dp);
            dp[n - 2] = fnm2;
        }

        //step 4 work
        int fn = fnm1 + fnm2;

        //step 5 return
        return fn;
    }
}
