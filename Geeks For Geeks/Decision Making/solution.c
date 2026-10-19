/*
 * Platform: GeeksforGeeks
 * Problem: Decision Making
 * URL: https://www.geeksforgeeks.org/problems/decision-making/1
 * Language: C
 * Difficulty: Easy
 * Topics: Java, CPP, python-conditionals, python, JavaScript, C#
 * Runtime: 0.01 s
 * Memory: N/A
 * Synced: 2026-10-19T18:59:59.522Z
 */

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    // code here
    if(n > m)
    {
        printf("greater\n");
    }
    else if(m > n)
    {
        printf("less\n");
    }
    else
    {
        printf("equal\n");
    }

    return 0;
}
