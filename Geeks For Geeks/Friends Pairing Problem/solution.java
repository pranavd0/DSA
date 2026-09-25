/*
 * Platform: GeeksforGeeks
 * Problem: Friends Pairing Problem
 * URL: https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1
 * Language: Java
 * Difficulty: Medium
 * Topics: Modular Arithmetic, Recursion
 * Runtime: 0.11 s
 * Memory: N/A
 * Synced: 2026-09-25T18:24:39.935Z
 */

class Solution {
    public int countFriendsPairings(int n) {
        // code here
        //step1
                //f(n)=f(n-1)+f(n-2)

                //step2
                if(n==1||n==2){
                    return n;
                }

                //step 3
                // Person stays single
                int fnm1=countFriendsPairings(n-1);
                // Person pairs with any of the remaining n-1 people
                int fnm2=(n-1)*countFriendsPairings(n-2);

                //step4&5
                return fnm1+fnm2;
    }
}
