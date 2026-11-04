/*
 * Platform: GeeksforGeeks
 * Problem: Kth Smallest
 * URL: https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
 * Language: Java
 * Difficulty: Medium
 * Topics: Expected Complexities, Company Tags, VMWare, Accolite, Amazon, Microsoft, Snapdeal, Hike
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-11-04T18:41:06.660Z
 */

class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());   
        
        for(int i = 0; i < arr.length; i++)
        {
            maxHeap.add(arr[i]);
            
            if(maxHeap.size()>k)
            {
                maxHeap.poll();
            }
        }
        
        return maxHeap.poll();
        
    }
}
