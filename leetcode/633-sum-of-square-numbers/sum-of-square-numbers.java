class Solution {
    public boolean judgeSquareSum(int c) 
    {
        long l = 0;
        long r = (long)Math.sqrt(c);

        while(l<=r)
        {
            long res = l*l + r*r;

            if(res == c)
            {
                return true;
            }
            else if(res>c)
            {
                r--;
            }
            else
            {
                l++;
            }
        }
        return false;   
    }
}
