class Solution {
    public boolean isHappy(int n) {
        //in this question after analysisng it we can say that there will be always a cycle if the number is unhappy
        //cycle in the sense the specific number will repeat after fixed distance
        //if the number is happy 1 will repeat in ending
        //hence we can use slow fast approach here for cycle detection 
        //even if the cycle is not present 1 will repeat which will stop our loop(make fast and slow equal)
        //to move slow and fast we will need helper function.
        int slow=n;
        int fast=n;
        //initialising slow and fast to fit in looop
        slow=nextint(slow);
        fast=nextint(nextint(fast));
        //Floyds cycle detection loop
        while(slow!=fast){
            slow=nextint(slow);
            fast=nextint(nextint(fast));
        }
        //if loop stops on 1 number is happy
        return slow==1;        
    }  
    int nextint(int a){
        int sum=0;
        while(a>0){
            int k=a%10;
            sum+=k*k;
            a=a/10;
        }
        return sum;
        
    }
}