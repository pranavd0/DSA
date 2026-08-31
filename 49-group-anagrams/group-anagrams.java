class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
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
}