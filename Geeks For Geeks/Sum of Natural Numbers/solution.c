/*
 * Platform: GeeksforGeeks
 * Problem: Sum of Natural Numbers
 * URL: https://www.geeksforgeeks.org/problems/reverse-coding2452/1
 * Language: C
 * Difficulty: Easy
 * Topics: Mathematics
 * Runtime: 0.01 s
 * Memory: N/A
 * Synced: 2026-10-18T14:23:11.387Z
 */

#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    // code here
    int isum=0;
    for(int i=1; i<=n; i++)
    {
       isum+=i; 
    }
    
    printf("%d\n",isum);

    return 0;
}
