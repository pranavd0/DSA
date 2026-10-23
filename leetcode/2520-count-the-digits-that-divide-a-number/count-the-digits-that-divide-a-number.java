class Solution {
    public int countDigits(int num) {
        int ans = 0;
        int n = num;
        while(n != 0)
        {
            if(num % (n % 10) == 0 )
            {
                ans++;
            }
            n /= 10;
        }
        
        return ans;
    }
}
