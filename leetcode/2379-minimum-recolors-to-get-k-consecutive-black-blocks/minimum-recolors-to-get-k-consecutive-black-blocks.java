class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int min = Integer.MAX_VALUE;
        int white = 0;
        int l =0;

        for(int r = 0;r<blocks.length();r++)
        {
            if(blocks.charAt(r)=='W')
            {
                white++;
            }
            if(r-l+1 == k)
            {
                min=Math.min(white,min);
                if(blocks.charAt(l)=='W')
                {
                    white--;
                }
                l++;
            }
        }
        return min;
        
    }
}
