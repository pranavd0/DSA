/*
 * Platform: GeeksforGeeks
 * Problem: String Duplicates Removal
 * URL: https://www.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Amazon, Microsoft, Adobe, Arrays, Strings
 * Runtime: 0.18 s
 * Memory: N/A
 * Synced: 2026-09-19T05:55:29.296Z
 */

class Solution {
    String removeDuplicates(String s) {
        HashSet<Character> set= new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
}
