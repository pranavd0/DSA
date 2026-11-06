class Solution {
    public int countElements(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            small= Math.min(nums[i],small);
            big = Math.max(nums[i],big);
        }
        int Ans = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < big && nums[i] > small)
            {
                Ans++;
            }
        }

        return Ans;
        
    }
}
