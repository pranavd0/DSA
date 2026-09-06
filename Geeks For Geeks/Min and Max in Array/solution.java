/*
 * Platform: GeeksforGeeks
 * Problem: Min and Max in Array
 * URL: https://www.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1
 * Language: Java
 * Difficulty: Easy
 * Topics: NPCI, Arrays
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-09-06T23:59:21.969Z
 */

class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        //helloooo
        ////////
        //////
        //////////
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(min);
        ans.add(max);

        return ans;
    }
}
