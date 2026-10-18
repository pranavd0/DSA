/*
 * Platform: GeeksforGeeks
 * Problem: Toggle Case
 * URL: https://www.geeksforgeeks.org/problems/toggle-case/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Strings
 * Runtime: 0.15 s
 * Memory: N/A
 * Synced: 2026-10-18T13:25:50.743Z
 */

class Solution {
    public String toggleCase(String s) {
        StringBuilder sb = new StringBuilder(""); 
        // code here
        for(int i=0;i<s.length();i++)
        {
            char cVal=s.charAt(i);
            
            //uppercase->lowercase
                if(cVal >= 'A' && cVal <= 'Z')
                {
                    cVal += ('a' - 'A');
                    sb.append(cVal);
                }
                //lowercase->uppercase
                else if(cVal >= 'a' && cVal <= 'z')
                {
                    cVal += ('A' - 'a');
                    sb.append(cVal);
                }
        }
        return sb.toString();
    }
}
