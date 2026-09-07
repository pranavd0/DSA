import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        // prefix sum + hashmap
        // treat 0 as -1 and 1 as 1
        // if prefix sum repeats at index i and j, subarray between them has equal 0s and 1s
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0;
        int maxLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            pre += (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(pre)) {
                maxLen = Math.max(maxLen, i - map.get(pre));
            } else {
                map.put(pre, i);
            }
        }
        return maxLen;
    }
}
