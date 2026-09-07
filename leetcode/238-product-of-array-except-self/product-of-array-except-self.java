class Solution {
    public int[] productExceptSelf(int[] nums) {
        // as we cant use division we will use use the pre multipilcation and post multiplication for each number of array
        // first we will calculate the leftmultiplication of each number(0 to i-1) and than add it to the answer array
        // than we will calculate right multi in same way and then multiply it with answer[i] i.e the leftmulti of that number(index)
        int leftmulti = 1;
        int rightmulti = 1;
        int[] answer = new int[nums.length];
        // there is no element in left of first element so we will keep it as 1
        // and start loop from 1
        answer[0] = 1;
        // left multi calculation loop
        for (int i = 1; i < nums.length; i++) {
            leftmulti *= nums[i - 1];
            answer[i] = leftmulti;
        }
        // right multi calculation loop 
        // right most(end) element dont have any element on right since we will start loop from n-2
        for (int i = nums.length - 2; i >= 0; i--) {
            rightmulti *= nums[i + 1];
            answer[i] *= rightmulti;
        }
        return answer;
    }
}
