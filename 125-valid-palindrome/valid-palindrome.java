class Solution {
    public boolean isPalindrome(String s) {
        // 2 pointer
        int l=0;
        int r=s.length()-1;
        //first condition until pointer comes till mid
        while(l<r){
            //now this while loop only to skip the non alphanumeric values
            // we check whether there is a non alpha numeric value in left or right
            //also we check for l<r this important
            while(l<r&&(!Character.isLetterOrDigit(s.charAt(l))||!Character.isLetterOrDigit(s.charAt(r)))){
                //check if a non alpha numeric is on left pointer
                if(!Character.isLetterOrDigit(s.charAt(l))){
                    //l++ skips it
                    l++;
                }
                //else it is on right side 
                else{
                    r--;
                }
            }
            //now after skipping th current non alpha numeric values we come on equal indexed alphanumeric values 
            //here we use character.toLowercase to convert captical into lower
            if (Character.toLowerCase(s.charAt(l))==Character.toLowerCase(s.charAt(r))) {
                //after checking we again push the pointers
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
        
    }
}