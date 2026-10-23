class Solution {
    public int findNumbers(int[] nums) 
    {
        int total = 0;

        for(int i = 0; i < nums.length; i++)
        {
            int nl = 0;
            int n = nums[i];
            while(n!=0)
            {
                nl++;
                n=n/10;
            }
            if(nl%2==0)
            {
                total++;
            }
        }

        return total;
    }
}
