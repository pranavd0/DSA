class Solution {
    public int countSubstrings(String s) {
        //we will count palindormes in count 
        int count =0;
        for(int i=0;i<s.length();i++){
            //we will run 2 loops for palindrome counting 
            //first while loop run if the palindrome is odd palindrome and the single charecter palindrome
            //second loop will run for even palindrome i.e '1221'
            //every time when we get a palindrome our count increses
            //in while loop we use centre expansion algorithm i.e. we assume each point as a center of palindrome
            //and than expands it in both direction i.e. forward and backward
            //until we are getting same charecters
            int r=i;
            int l=i;
            //this is the centre expansion for odd palindrome
            while(l>=0&&r<s.length()&&(s.charAt(l)==s.charAt(r))){
                count++;
                l--;
                r++;
            }
            int er=i+1;
            int el=i;
            while(el>=0&&er<s.length()&&(s.charAt(el)==s.charAt(er))){
                count++;
                el--;
                er++;
            }
        }
        return count;
        
    }
}