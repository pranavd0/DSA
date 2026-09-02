class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxavg=Integer.MIN_VALUE;
        int l=0;
        int sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            if(r-l+1==k){
                double avg = (double) sum / k;
                maxavg=Math.max(avg,maxavg);
                sum-=nums[l];
                l++;
            }
        }
        return maxavg;
    }
}