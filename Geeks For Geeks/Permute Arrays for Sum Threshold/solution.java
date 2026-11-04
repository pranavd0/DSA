/*
 * Platform: GeeksforGeeks
 * Problem: Permute Arrays for Sum Threshold
 * URL: https://www.geeksforgeeks.org/problems/permutations-in-array1747/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Arrays, Sorting
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-11-04T05:12:37.563Z
 */

class Solution {
    public boolean isPossible(int k, int[] a, int[] b) {
        // code here
        //this permuatation can be only true in one case:
        //when we take one array in asscending and other array in descending order
        Arrays.sort(a);
        //this array in descending order
        Arrays.sort(b);
        for(int i=0;i<b.length/2;i++){
            int temp=b[i];
            b[i]=b[b.length-1-i];
            b[b.length-1-i]=temp;
        }
        //now check
        for(int i=0;i<a.length;i++){
            if(a[i]+b[i]<k){
                return false;
            }
        }
        return true;
        //Main concept:one array ascending another descending
    }
}
