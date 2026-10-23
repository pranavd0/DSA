/*
 * Platform: GeeksforGeeks
 * Problem: Prime Number
 * URL: https://www.geeksforgeeks.org/problems/prime-number2314/1
 * Language: C
 * Difficulty: Easy
 * Topics: VMWare, Amazon, SAP Labs, Mathematics, Prime Number
 * Runtime: 0.02 s
 * Memory: N/A
 * Synced: 2026-10-23T13:05:49.404Z
 */

class Solution {
  public:
    bool isPrime(int n) {
        // code here
        int iCnt=0;

        for(iCnt = 2; iCnt <= n/2; iCnt++)
        {
            if((n % iCnt) == 0)
            {
                break;             
            } 
        }
    
        if(iCnt == n/2 + 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
};
