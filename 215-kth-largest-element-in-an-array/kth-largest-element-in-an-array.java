class Solution {
    public int findKthLargest(int[] nums, int k) {
        //we will create a heap
        //heap is a data structure which makes a tree in which min or max among all the elemnts is always at the top of the tree
        //if we consider min heap than smallest element will be at topmost root and the next greater element will be on its left child node and than right child node
        //here we will create a min heap of size k and add elements one by one in it
        //whenever the size exceeds we will remove the topmost element(smallest) element from heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer i:nums){
            pq.add(i);
            //first we add the elemnt in heap and then check its size if its greater than k than remive the top
            //most elemnt  
            if(pq.size()>k){
                pq.poll();
            }
            //at the end this will give us min heap of k largest elemnt among all of them and the topmost elemnt 
            //will be our kth largest elemnt 
        }
        return pq.poll();

    }
}