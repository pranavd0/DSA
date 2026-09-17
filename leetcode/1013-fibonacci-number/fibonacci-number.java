class Solution {
    //recursive approach
    public int fib(int n) {
        //step 1:Define function
        //f(n)=f(n-1)+f(n-2)

        //step 2:Base Case
        if(n<=1){
            return n;
        }

        //step 3:inner calls
        int fibnm1=fib(n-1);
        int fibnm2=fib(n-2);

        //step 4:execute work
        int fn=fibnm1+fibnm2;

        //step 5:retrun
        return fn;
        
    }
}