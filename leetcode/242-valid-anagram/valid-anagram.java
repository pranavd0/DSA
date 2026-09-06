class Solution {
    public boolean isAnagram(String s, String t) {
        //frequency array
        if(s.length()!=t.length()){
            return false;
        }
        //frequency array is a type of array which stores freuency of each elemnt in the array
        //let suppose in the integer array of 12345 it will individually calculate how many times one comes and the frequency will be stored 1th index
        //means it stores the frequency of element x into index x
        //it has O(1) space complexity
        //if our array has greatest element k than we have to make our frequency array of k size to store frequency of k
        //frquency array works on integer but here we have string of charecters hence we will convert each alphabet into integer
        //acs11 value of a is 98 bis 97 and so on...
        //if we subtract a from any alphabet it will give us its index in the range of 1 to 25 where 'a'-'a'=0 
        //hence to store any of the alphabet(freq) we create a rray of size 26
        int count[]= new int[26];
        for(int i=0;i<s.length();i++){
            //here count[i]++ states that it increses the frequency of element i by 1
            //by subtracting each charecter by a we get its index in our array and than increse its frequency 
            count[s.charAt(i)-'a']++;
            //again if the elemnt found in our anagram string we decrease its frequency so if the freq of chrecter in both the strings are equal our count array index will remain zero
            count[t.charAt(i)-'a']--;
        }
        for(Integer x:count){
            //now we check whether its actually zero
            if(x!=0){
                return false;
            }
        }
        return true;
    }
}