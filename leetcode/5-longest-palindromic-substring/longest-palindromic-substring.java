class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()<0){
            return "";
        }
        int start=0;//startoflongeststr
        int end=0;//endoflongeststr

        for(int i=0;i<s.length();i++){
            //assuming each point in string as centre and find palindrome for it;
            int len1=expand(s,i,i);//len1 will give value if palindrome is odd
            int len2=expand(s,i,i+1);//for even 
            int len=Math.max(len1,len2);

            //updating start and end to store the indices of longest palindfrome
            if(len>(end-start+1)){
                start=i-(len-1)/2; //len-1 done bcoz for even case it gives extra 1
                end=i+len/2;
            }

        }
        return s.substring(start,end+1);

        
    }
    private int expand(String s,int left, int right){
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            int length=(right-1)-(left+1)+1;
            return length;//due to right ++ and left-- are after while(inside while) the right increased by extra 1 same for left and hence that extra 1 is first removed and than length is calculated
        }
}