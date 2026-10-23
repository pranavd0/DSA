class Solution {
    public int countPrimes(int n) 
    {
        int ip= 0;
        for(int i = 1; i <= n; i++)
        {
            int j =0;
            for(j = 1; j <= i/2; j++)
            {
                if(i % j == 0)
                {
                    break;
                }
            }
            if(j == i/2 + 1)
            {
                ip++;
            }
        }  
        return ip;  
    }
}
