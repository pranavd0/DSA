/*
 * Platform: GeeksforGeeks
 * Problem: Power Using Recursion
 * URL: https://www.geeksforgeeks.org/problems/power-using-recursion/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Recursion
 * Runtime: 0.12 s
 * Memory: N/A
 * Synced: 2026-09-17T11:31:57.712Z
 */

class Solution {
    public int recursivePower(int n, int p) {
        //bottom up approach
        
        // step 1
        //f(p)=f(p-1)*n
        
        //step2
        if(p==0){
            return 1;
        }
        
        //step 3 
        int fnm1=recursivePower(n,p-1);
        
        //step 4
        int ans=fnm1*n;
        
        //step5
        return ans;
        
    }
}
