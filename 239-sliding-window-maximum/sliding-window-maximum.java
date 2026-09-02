class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //we will need the deque to solve this problem as we need to add and remove the element from both sides
        //we can also solve the problem with the help of priority queue but the time complexity of remove function is high
        //we will keep largest element of the current window in front side of deque
        //we just store the indices of element not the actual element to avoid confusion
        //while adding element we will add it from last
        //if current element is greater than last element of dq we will remove it  
        Deque<Integer> pq=new ArrayDeque<>();
        int fw[]=new int[nums.length-k+1];
        int l=0;
        for(int r=0;r<nums.length;r++){
            //removing the elements smaller than r from back side
            while(!pq.isEmpty()&&(nums[r]>nums[pq.peekLast()])){
                pq.pollLast();
            }
            //now add that element from last(back side)
            pq.offerLast(r);

            if(r-l+1==k){
                //add first element in array as its the largest element of window
                fw[l]=nums[pq.peekFirst()];
                //as our oldest element will be on the first(front) side we will check it 
                //it will be on first position as we remove elments from last
                //if its equal to l we will remove it
                //as we remove lot of elements at the time of appending the elements in dq
                //hence we need to check whether l exist or not in our dq
                if (pq.peekFirst() == l) {
                    pq.pollFirst();
                }
                l++;
            }
        }
        return fw;
        
    }
}