/*
 * Platform: GeeksforGeeks
 * Problem: k Largest Elements
 * URL: https://www.geeksforgeeks.org/problems/k-largest-elements4206/1
 * Language: Java
 * Difficulty: Medium
 * Topics: Amazon, Microsoft, Samsung, Walmart, Google, Arrays, Sorting, Heap
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-11-04T05:09:59.526Z
 */

class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // code here
        //k largest element-->min heap
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int n:arr){
            pq.add(n);
            
            if(pq.size()>k){
                pq.poll();
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }

        Collections.reverse(ans);

        return ans;
    }
}
