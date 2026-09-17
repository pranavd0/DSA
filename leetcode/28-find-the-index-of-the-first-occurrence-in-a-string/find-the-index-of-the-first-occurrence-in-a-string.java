class Solution {
    //we will solve this by recursive logic
    //top down approachi.e check and go
    public int strStr(String haystack, String needle) {
        return index(needle,haystack,0);
        
    }
    //first we will make recursive function which wll compare for each charecter of haystack with one by one charecter of needle with the help of helper matches
    //if match not found call ineer function
    //i.e move towards next step


    int index(String a,String b,int i){
        //step1
        //f(n)=matches(i)+f(i+1)

        //step2
        if(i>b.length()-a.length()){
            return -1;
        }

        //step3
        if(!matches(a,b,i,0)){//work
            return index(a,b,i+1);//step 4
        }
        
        //step5
        return i;
    }
    //this helper function will check from first charecter of needle with the current substring of haystack
    //if match any charecter mismatches returns false and then index function moves towards next index of haystack

    boolean matches(String a,String b,int i,int j){
        //i is current index in haystack 
        //j is starting index of needle

        //step1
        //f(n)=a[j]==a[i]+f(i+1,j+1)

        //step 2
        if(j==a.length()-1){
            if(a.charAt(j)==b.charAt(i)){
                return true;
            }
        }
        //step3 work
        if(a.charAt(j)!=b.charAt(i)){
            return false;
        }
        //step4&5 inner call and return
        return matches(a,b,i+1,j+1);
    }
}