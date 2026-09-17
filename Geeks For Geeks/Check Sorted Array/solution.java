/*
 * Platform: GeeksforGeeks
 * Problem: Check Sorted Array
 * URL: https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Arrays, Sorting
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-09-17T09:19:50.750Z
 */

class Solution {
    public boolean isSorted(int[] arr) {
        // recursive approach
        return isArraySorted(arr,0);
                
                
    }
    boolean isArraySorted(int a[],int i){
            //step1
            //f(n)=a[i]<a[i+1]+f(i+1)

            //step2
            if(i==a.length-1){
                return true;
            }

            //step3:work and execute
            if(a[i]>a[i+1]){
                return false;
            }

            //step4 & 5
            return isArraySorted(a, i+1);
    }
}
