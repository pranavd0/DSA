/*
 * Platform: GeeksforGeeks
 * Problem: Reverse Array
 * URL: https://www.geeksforgeeks.org/problems/reverse-an-array/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Bloomberg, Facebook, TCS, Adobe, Google, Infosys, Arrays
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-09-06T22:12:21.580Z
 */

class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int[] rev= new int[arr.length];
                for(int i=0;i<arr.length/2;i++){
                    int temp=arr[i];
                    arr[i]=arr[arr.length-1-i];
                    arr[arr.length-1-i]=temp;
                }
                
    }
}
