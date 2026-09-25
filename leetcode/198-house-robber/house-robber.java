import java.util.Arrays;
class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+2];
        Arrays.fill(dp, -1);
        return solve(nums,0,dp);
    }

    int solve(int nums[],int n,int dp[]){
        //step 1
        // f(n) = max((nums[n]+f(n+2))   + f(n+1))

        //step 2
        if(n>=nums.length){
            return 0;
        }

        //step 3

        //rob current house
        if(dp[n+2]==-1){
            dp[n+2]=solve(nums,n+2,dp);
        }
        int robcurrent=nums[n]+dp[n+2];

        //do not rob current house
        if(dp[n+1]==-1){
            dp[n+1]=solve(nums,n+1,dp);
        }
        int skipcurrent=dp[n+1];

        //step 4 and 5
        return Math.max(robcurrent,skipcurrent);
    }
}
