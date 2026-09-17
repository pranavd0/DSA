class Demo {
    /*
    Steps:
        1>define function

        : for execution first 
        2> Define Base Case 
        3> Works on each step 
        4> f(n-1) (inner call)

        : for inner call first  
        2> Define Base Case 
        3> f(n-1) (inner call)
        4> Works on each step 

        5>return(return some value for prev step)
    */
    void nto1Numbers(int n){
        //step 1:
        //f(n)=n(print)+f(n-1)

        //step 2:Base Case 
        if(n==0){
            return;
        }

        //step 3:Execution(work)
        System.out.println(n);

        //srep 4:inner call
        nto1Numbers(n-1);

        //no step 5 as we have void function
    }

    void oneto_nNumbers(int n){
        //step 1:
        //f(n)=f(n-1)+n(print)

        //step 2:base case
        if(n==0){
            return;
        }

        //step 3: inner call
        //here before printing we will call ineer function as it will go till last(down) 
        //and then it will start executing for each step 
        oneto_nNumbers(n-1);

        //step 4:execution
        System.out.println(n);

        //no step 5 as we have void function
    }

    int factorial(int n){
        //step 1
        //f(n)=n * f(n-1)

        //step 2:Base case
        if(n==0){
            return 1;
        }

        //step 3:inner call
        int fn_Minus_1=factorial(n-1);

        //step 4: execute/return
        int fn= n*fn_Minus_1;

        //step 5:
        return fn;
    }

    int sumofFirstN(int n){
        //step 1
        //sum(n)=n+sum(n-1)

        //step 2:Base case
        if(n==1){
            return 1;
        }

        //step 3:inner call
        int sum_n_minis_1=sumofFirstN(n-1);

        //step 4:execute 
        int sum_n= n+sum_n_minis_1;

        //step 5:
        return sum_n;
    }
    
    int fibonacci(int n){
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
        int fn_minus1=fibonacci(n-1);
        int fn_minus2=fibonacci(n-2);

        //step 4:
        int fn=fn_minus1+fn_minus2;

        //step 5:
        return fn;

    }


    
}
public class Recursion{
    public static void main(String[] args) {
        Demo dobj= new Demo();

        //dobj.nto1Numbers(10);
        /*System.out.println(dobj.factorial(5));
        System.out.println(dobj.sumofFirstN(4));*/
        System.out.println(dobj.fibonacci(4));
    }
}
