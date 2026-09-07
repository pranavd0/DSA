/*
 * Platform: GeeksforGeeks
 * Problem: Rotate Array by One
 * URL: https://www.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Arrays, implementation
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-09-07T17:54:22.282Z
 */

class Solution {
    public void rotate(int[] arr) {
        // code here
        int last=arr[arr.length-1];
        int curr=0;
        int temp=arr[0];
        for(int i=0;i<arr.length-1;i++){
            curr=arr[i+1];
            arr[i+1]=temp;
            temp=curr;
        }
        arr[0]=last;
            
            
    }
}
