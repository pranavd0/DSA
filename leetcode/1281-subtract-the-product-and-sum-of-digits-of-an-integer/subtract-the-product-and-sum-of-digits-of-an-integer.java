class Solution {
    public int subtractProductAndSum(int n) {
        int iSum = 0;
        int iPro = 1;

        while( n != 0)
        {
            iSum += (n%10);
            iPro *= (n%10);
            n /= 10;
        }

        return iPro - iSum;
    }
}
