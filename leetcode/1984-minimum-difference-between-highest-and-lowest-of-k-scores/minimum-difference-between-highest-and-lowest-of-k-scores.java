import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        // here we want highest and lowest scores close to each other 
        // it will difficult find them individually
        // hence we will sort the arrray and all the elments automatically gets closer to each other
        // after sorting we can easily use the slididng windowof size k
        // as array is sorted the r will give us highest of the subarray
        // l will show lowest
        Arrays.sort(nums);
        int l = 0;
        int difference = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            if (r - l + 1 == k) {
                int d = nums[r] - nums[l];
                difference = Math.min(difference, d);
                l++;
            }
        }
        return difference;
    }
}
