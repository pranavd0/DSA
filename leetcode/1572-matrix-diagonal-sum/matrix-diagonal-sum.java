class Solution {
    public int diagonalSum(int[][] mat) {
        int i =0, j=0, iSum = 0;
        
        while(i < mat.length)
        {
            iSum += mat[i][j];
            i++;
            j++;
        }

        i = mat.length-1;
        j = 0;

        while(i >= 0)
        {
            if ( i == j)
            {
                i--;
                j++;
                continue;
            }

            iSum += mat[i][j];
            i--;
            j++;
        }

        return iSum;
        
    }
}
