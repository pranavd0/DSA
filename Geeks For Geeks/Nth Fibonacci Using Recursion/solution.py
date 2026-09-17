# Platform: GeeksforGeeks
# Problem: Nth Fibonacci Using Recursion
# URL: https://www.geeksforgeeks.org/problems/fibonacci-using-recursion/1
# Language: Python 3
# Difficulty: Easy
# Topics: Recursion
# Runtime: N/A
# Memory: N/A
# Synced: 2026-09-17T06:43:41.351Z

class Solution {
    static int nthFibonacci(int n) {
        // code here
        //step 1
                //f(n)=f(n-1)+f(n-2);

                //step 2:
                if(n==1){
                    return 1;
                }
                if(n==0){
                    return 0;
                }

                //step 3:
                int fnMinus1=nthFibonacci(n-1);
                int fnMinus2=nthFibonacci(n-2);

                //step 4:
                int fn=fnMinus1+fnMinus2;

                //step 5:
                return fn;
        
    }
}
