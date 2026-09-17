/*
 * Platform: GeeksforGeeks
 * Problem: First Occurrence in Sorted
 * URL: https://www.geeksforgeeks.org/problems/binary-search-1587115620/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Infosys, Oracle, Wipro, Linkedin, Qualcomm, TCS, Cognizant, Accenture
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-09-17T09:30:49.941Z
 */

class Solution {
    public int firstSearch(int[] arr, int k) {
        // recursion
        return firstOccurance(arr,k,0);
        
    }
    int firstOccurance(int a[],int n, int i){
            //step 1
            //f(n)= (a[i]==n) + f(i+1)

            //step 2
            if(i==a.length){
                return -1;
            }

            //step 3(work)
            if(a[i]==n){
                return i;
            }

            //step 4&5(inner call and return)
            return firstOccurance(a, n, i+1);
        }
}
