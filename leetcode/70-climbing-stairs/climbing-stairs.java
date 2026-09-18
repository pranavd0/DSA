class Solution {
    
    public int climbStairs(int n) {
        //recursive approach
        //we can choose either one or 2 steps at each stage 
        //so at each stage of recurrrance we will choose either one or 2 steps and caclculate for both conditions seprately 
        //we will use memoization(dp) to avoid unneccassary recurrance(avoid recalculating f(n) values which have been already used)
        //we will store the values of dp in array(dp[n]=f(n))
        //to avoid recreatting our dp array at each recurrance we will solve problem in another method
        int dp[]=new int[n+1];
        return solve(n,dp); 
    }
    int solve(int n,int dp[]){
        //step1 define function
        //f(n)=f(n-1)+f(n-2)
        //if we choose one step n-1 steps will be still remaining
        //if we choose 2 steps n-2 steps will be remiaining

        //step2 base case
        //if we have 0 steps remaing than not climbing a single step is also a distinct way to climb
        if(n==0||n==1){
            return 1;
        }

        //step3 inner call
        //1 step
        int fnm1=0;
        //before calling we will check whether its present in dp to avoid unnecassary calls
        if(dp[n-1]!=0){
            fnm1=dp[n-1];
        }
        else{
            //if not present call f(n-1) and also store it in dp for further use
            fnm1=solve(n-1,dp);
            dp[n-1]=fnm1;
        }
        //2 step
        int fnm2=0;
        if(dp[n-2]!=0){
            fnm2=dp[n-2];
        }
        else{
            fnm2=solve(n-2,dp);
            dp[n-2]=fnm2;
        }

        //step4 work
        int fn=fnm1+fnm2;

        //step 5 return
        return fn;
    }
}