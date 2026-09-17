class Solution {
    public int strStr(String haystack, String needle) {
        return index(needle,haystack,0);
        
    }
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
    boolean matches(String a,String b,int i,int j){
        //step1
        //f(n)=a[j]==a[i]+f(i+1,j+1)
        if(j==a.length()-1){
            if(a.charAt(j)==b.charAt(i)){
                return true;
            }
        }
        if(a.charAt(j)!=b.charAt(i)){
            return false;
        }

        return matches(a,b,i+1,j+1);
    }
}