/*
 * Platform: GeeksforGeeks
 * Problem: Print GFG n times
 * URL: https://www.geeksforgeeks.org/problems/print-gfg-n-times/1
 * Language: C++
 * Difficulty: Easy
 * Topics: python-loops, CPP, Java, python, JavaScript, C#
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-11-04T05:08:09.443Z
 */

class Solution {
  public:
    void printGfg(int n) {
        // code here
        for(int i =0; i < n; i++)
        {
            if(i > 0)
            {
                cout << " ";
            }
            cout << "GFG";
        }
    }
};
