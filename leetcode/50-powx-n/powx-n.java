class Solution {
    public double myPow(double x, int n) {
        //recursive logic
        //bottom up approach
        
        //step 1 define relation/function
        //f(n)=f((n/2)*f(n/2)
        //i.e x^n=x^n/2*x^n/2       
        //if n==odd
        //x^n=x^n/2*x^n/2*x

        //step2 base case
        long exp = n; // long handles Integer.MIN_VALUE safely

        //base case for positive values
        if(exp==0){
            return 1;
        }
        //base case for negative values
        if(exp<0){
            x=1/x;
            exp=-exp;
        }
            
        //step3 inner call
        double fnby2 = myPow(x, (int) (exp / 2));

        //step4 work
        double fn=fnby2*fnby2;
        //if n is odd multiply fn by x
        if(exp%2!=0){
            fn=fn*x;
        }
            
        //step5 return
        return fn;
        
    }
}