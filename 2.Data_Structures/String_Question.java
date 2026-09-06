import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class String_Question{
    boolean l125isPalindrome(String s) {
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
    boolean l242isAnagram(String s, String t) {
        //frequency array
        if(s.length()!=t.length()){
            return false;
        }
        //frequency array is a type of array which stores freuency of each elemnt in the array
        //let suppose in the integer array of 12345 it will individually store how many times one comes and the frequency will be stored 1th index
        //means it stores the frequency of element x into index x
        //it has O(1) space complexity
        //if our array has greatest element k than we have to make our frequency array of k size to store frequency of k
        //frquency array works on integer but here we have string of charecters hence we will convert each alphabet into integer
        //acs11 value of a is 98, b is 97 and so on...
        //if we subtract a from any alphabet it will give us its index in the range of 0 to 25 where 'a'-'a'=0 
        //hence to store any of the alphabet(freq) we create an array of size 26
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
        // frequency array-https://chatgpt.com/share/6a92c823-eee4-83e8-9c8e-7c91752bb07b
        
    }
    boolean l20isValid(String s){
        //we will use stack
        Stack<Character> x = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //if we get opening brackets we will push it
            if (ch == '{' || ch == '(' || ch == '[') {
                x.push(ch);
            }
            //now if we get closing bracket 
            // we will check it for every type of bracket
            // first we will check whether stack is empty it means there is no opening bracket
            // than we will check top element of stack if its the correct closing bracket of our corresponding opening bracket we will pop it
            //we will try to empty the stack for valid parenthesis
            else if (ch == '}') {
                if (x.isEmpty()) {
                    return false;
                }

                if (x.peek() == '{') {
                    x.pop();
                    //if we get any other bracket other than our corresponding opening bracket the parenthesis is invalid
                } else {
                    return false;
                }
            }

            else if (ch == ')') {
                if (x.isEmpty()) {
                    return false;
                }

                if (x.peek() == '(') {
                    x.pop();
                } else {
                    return false;
                }
            }

            else {
                if (x.isEmpty()) {
                    return false;
                }

                if (x.peek() == '[') {
                    x.pop();
                } else {
                    return false;
                }
            }
        }

        return x.isEmpty();
    }
    boolean l20isValidOPT(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    String l14longestCommonPrefix(String[] strs) {
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
    int l03longestDistinctsubstr(String s){
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
    int l1456maxVowels(String s, int k){
        int l=0;
        int maxvovel=0;
        int vovel=0;
        //intialised left and right from zero 
        for(int r=0;r<s.length();r++){
            //while increasing the window we will keep track on vovels
            //if we get vovels we increase vovel count
            if(s.charAt(r) == 'a' || s.charAt(r) == 'e' || s.charAt(r) == 'i' || s.charAt(r) == 'o' || s.charAt(r) == 'u'){
                vovel++;
            }
            
            if(r-l+1==k){
                //now when we shrink our window we also have to remove the previously counted vovels 
                //so we check whether it comes on our left pointer and then decrease our left pointer
                //before reducing our vovvels we calculate max vovels
                maxvovel=Math.max(vovel,maxvovel);
                if(s.charAt(l) == 'a' || s.charAt(l) == 'e' || s.charAt(l) == 'i' || s.charAt(l) == 'o' || s.charAt(l) == 'u'){
                    vovel--;
                }
                l++;
            } 
        }
        return maxvovel;
    }
    int l320maxSubstringWithAtMostkDistinctElements(String s,int k){
        //we will use the hashmap to keep track on the chrecters as well as there frequencies
        int l=0;
        int maxsize=0;
        //we will add each chracter into the hashmap
        HashMap <Character,Integer> m=new HashMap<>();
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            m.put(ch, m.getOrDefault(ch, 0)+1);
            // after adding we will check how much distinct elemnts we currently hold 
            //we shrink our window until our distinct elements comes under k
            while(m.size()>k){
                m.put(s.charAt(l), m.get(s.charAt(l))-1);
                if(m.get(s.charAt(l))==0){
                    m.remove(s.charAt(l));
                }
                l++;
            }
            maxsize=Math.max(maxsize, r-l+1);
        }
        return maxsize;
         /*Overall logic:
            right expands
             ↓
            Add character to map
             ↓
            map.size() > k ?
                ↙           ↘
              YES            NO
               ↓             ↓
            shrink window   calculate
                    ↓
            remove left char
                    ↓
                left++ */
        }
    int l424characterReplacement(String s, int k) {

        // Left boundary of our sliding window
        int l = 0;

        // Stores the maximum length of a valid window
        int maxlen = 0;

        /*
         * maxfreq = highest frequency of any character
         * that we have seen while expanding the window.
         *
         * IMPORTANT:
         * We DO NOT decrease maxfreq when 'l' moves.
         *
         * maxfreq means:
         * "The highest frequency I have seen so far"
         *
         * NOT:
         * "The exact highest frequency in the current window"
         *
         * Keeping this value makes the solution O(n)
         * without repeatedly finding the maximum frequency.
         */
        int maxfreq = 0;

        // Stores frequency of characters in the current window
        HashMap<Character, Integer> m = new HashMap<>();

        // Expand the window using the right pointer
        for (int r = 0; r < s.length(); r++) {

            // Character entering the window
            char ch = s.charAt(r);

            // Increase its frequency
            m.put(ch, m.getOrDefault(ch, 0) + 1);

            /*
             * Update maxfreq.
             *
             * We only increase maxfreq.
             * We NEVER decrease it when the left pointer moves.
             */
            maxfreq = Math.max(maxfreq, m.get(ch));

            /*
             * Window size:
             *     r - l + 1
             *
             * Suppose:
             *     A A A B A
             *
             * Window size = 5
             * maxfreq = 4 (A appears 4 times)
             *
             * We keep the 4 A's and replace the remaining
             * 1 character.
             *
             * Therefore:
             *
             * changesneeded = window size - maxfreq
             *                = 5 - 4
             *                = 1
             */
            int changesneeded = (r - l + 1) - maxfreq;

            /*
             * If changesneeded > k,
             * we cannot make the entire window the same
             * using at most k replacements.
             *
             * So we shrink the window from the left.
             */
            while (changesneeded > k) {

                // Character leaving the window
                char leftChar = s.charAt(l);

                // Decrease its frequency
                m.put(leftChar, m.get(leftChar) - 1);

                // Remove it from the map if frequency becomes 0
                if (m.get(leftChar) == 0) {
                    m.remove(leftChar);
                }

                // Move left pointer forward
                l++;

                /*
                 * Recalculate changes needed for the
                 * new smaller window.
                 *
                 * IMPORTANT:
                 * maxfreq is NOT recalculated/decreased here.
                 *
                 * It may be larger than the actual maximum
                 * frequency of the current window.
                 *
                 * That's okay and is an intentional optimization
                 * used by the standard O(n) solution.
                 */
                changesneeded = (r - l + 1) - maxfreq;
            }

            /*
             * Now changesneeded <= k.
             *
             * So our current window is considered valid.
             *
             * Update the answer.
             */
            maxlen = Math.max(maxlen, r - l + 1);
        }

        return maxlen;
    }
    List<List<String>> l49groupAnagrams(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            // Sort the current string
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);

            String sorted = new String(chars);

            // Create list if key doesn't exist
            map.putIfAbsent(sorted, new ArrayList<>());

            // Add original string to its anagram group
            map.get(sorted).add(strs[i]);
        }

        // Convert HashMap values into List<List<String>>
        return new ArrayList<>(map.values());   
    }
    List<List<String>> l49OPTgroupAnagrams(String[] strs){
         HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Frequency array for 26 lowercase English letters
            int[] freq = new int[26];

            // Count frequency of every character
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }

            // Convert frequency array into a unique String key
            StringBuilder key = new StringBuilder();

            for (int count : freq) {
                key.append(count).append('#');
            }

            // Create an empty group if this key doesn't exist
            map.putIfAbsent(key.toString(), new ArrayList<>());

            // Add original string to its anagram group
            map.get(key.toString()).add(str);
        }

        // Return all anagram groups
        return new ArrayList<>(map.values());
    }
    String l05longestPalindrome(String s) {
        if(s==null||s.length()<0){
            return "";
        }
        int start=0;//startoflongeststr
        int end=0;//endoflongeststr

        for(int i=0;i<s.length();i++){
            //assuming each point in string as centre and find palindrome for it;
            int len1=l05HelperExpand(s,i,i);//len1 will give value if palindrome is odd
            int len2=l05HelperExpand(s,i,i+1);//for even 
            int len=Math.max(len1,len2);

            //updating start and end to store the indices of longest palindfrome
            if(len>(end-start+1)){
                start=i-(len-1)/2; //len-1 done bcoz for even case it gives extra 1
                end=i+len/2;
            }

        }
        return s.substring(start,end+1);

        
    }
    int l05HelperExpand(String s,int left, int right){
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            int length=(right-1)-(left+1)+1;
            return length;//due to right ++ and left-- are after while(inside while) the right increased by extra 1 same for left and hence that extra 1 is first removed and than length is calculated
        }
    int l647countSubstrings(String s) {
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
