class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
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
}