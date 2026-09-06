class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int max=0;
        //we will hashset as if to check whether the current chrecter already exist or not
        //we will keep the current non repeating substring in the hashset 
        HashSet <Character> m=new HashSet<>();
        for(int r=0;r<s.length();r++){
            //first we will check whether the character already exist in our hashset 
            //if yes we shrink our left until we remove it
            while(m.contains(s.charAt(r))){
                m.remove(s.charAt(l));
                l++;
            }
            //we add that chracter in hashset
            m.add(s.charAt(r));

            max=Math.max(max,r-l+1);
        }
        return max;
    }
}