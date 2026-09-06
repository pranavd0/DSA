class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        //we will use Stringbuilder to store the prefix repeating part of all string
        //initialised the stringbuilder with first string of array
        StringBuilder ans = new StringBuilder(strs[0]);
        //iterate on array
        for(int i=1;i<strs.length;i++){
            //taking each individual string in k
            String k=strs[i];
            //we will just move our pointer j on the string k until we get the common elemnts.
            int j=0;
            //this while compares the our ans's chrecters with k's charecters
            //moves the pointer until we get the differnt chrecters on the same respective postions on both strings
            while(j<ans.length() && j<k.length() && ans.charAt(j)==k.charAt(j)){
                j++;
            }
            //now we will delete the remaining part of the string which is non repeating
            // we get those part with the help of j as we iterated it on k 
            //String.delete(x,y);  this syantx deletes the charecters of stringbuilder from x till y
            //where x is included and y is excluded
            ans.delete(j, ans.length());
        }
        return ans.toString();

        }
        
    }
