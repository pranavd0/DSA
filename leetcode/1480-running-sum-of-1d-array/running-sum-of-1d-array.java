class Solution {
    public int[] runningSum(int[] nums) {
        // here we will create a nomral nsize prefix as we dont have to acces the elments
        // so we will not face 0th index conflict
        int[] prefix = new int[nums.length];
        int currsum = 0;
        for (int i = 0; i < nums.length; i++) {
            currsum = currsum + nums[i];
            prefix[i] = currsum;
        }
        return prefix;
    }
}
