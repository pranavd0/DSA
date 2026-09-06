/*
 * Platform: GeeksforGeeks
 * Problem: Chocolate Distribution Problem
 * URL: https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Flipkart, Sorting
 * Runtime: 0.12s
 * Memory: N/A
 * Synced: 2026-09-06T21:55:46.408Z
 */

class Solution {
    public int findMinDiff(int arr[], int m) {
        // code here
        Arrays.sort(arr);
               int l=0;
               int currMin=0;
               int minDiff=Integer.MAX_VALUE;
               for(int r=0;r<arr.length;r++){
                   if(r-l+1==m){
                       currMin=arr[r]-arr[l];
                       minDiff=Math.min(minDiff, currMin);
                       l++;    
                   }
               }
               return minDiff;
    }
}
