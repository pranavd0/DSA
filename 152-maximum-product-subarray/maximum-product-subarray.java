class Solution {
    public int maxProduct(int[] nums) {
        //dynamic programming 
        //to calculate max product among all subarrays
        //we will keep track on max and min product at each position
        //as greatest negative number mulyiplying with negative number can give us the maxproduct
        //we will calucate max and min product among all subaarays ENDING on ith position for every iteration

        //this are the maxproduct and min product of current subbarays which Ends on ith poistion of loop
        int maxproduct = nums[0];
        int minproduct = nums[0];
        int ans=nums[0];

        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            //we use this 2 extra variables as our values of maxproduct and minproduct may change during comparison
            int oldMax = maxproduct;
            int oldMin = minproduct;
            //we compare among 3 (curr,max*curr,min*curr)
            maxproduct = Math.max(curr, Math.max(oldMax * curr, oldMin * curr));
            minproduct = Math.min(curr, Math.min(oldMax * curr, oldMin * curr));
            //our ans stores the final maximum product
            ans=Math.max(ans,maxproduct);
        }
        return ans;
        
    }
}