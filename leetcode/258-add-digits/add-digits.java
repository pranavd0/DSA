class Solution {
    public int addDigits(int num) {
        int iSum =num;
        while(iSum >= 10)
        {
            iSum = 0;
            while(num != 0)
            {
                iSum+= num%10;
                num /= 10;
            }
            num=iSum;
        }
        return num;
    }
}
