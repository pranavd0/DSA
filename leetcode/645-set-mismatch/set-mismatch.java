class Solution {
    public int[] findErrorNums(int[] nums) {
        // frequency array
        // as we have continous elements from 1 to n
        // if freq=0 ->missing
        // if freq=2 ->duplicate
        int[] count = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int[] ans = new int[2];
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) {
                ans[0] = i;
            }
            if (count[i] == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }
}
