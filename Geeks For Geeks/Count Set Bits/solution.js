/*
 * Platform: GeeksforGeeks
 * Problem: Count Set Bits
 * URL: https://www.geeksforgeeks.org/problems/set-bits0143/1
 * Language: JavaScript
 * Difficulty: Easy
 * Topics: Microsoft, Samsung, Adobe, Wipro, Brocade, Juniper Networks, Cisco, Qualcomm
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-11-04T05:04:28.812Z
 */

class Solution {
    setBits(N) {
        // code here
        let setBits=0;

                while(N>0)
                {
                    setBits+=1;

                    N=N&(N-1)
                }

                    return setBits;
    }
}
