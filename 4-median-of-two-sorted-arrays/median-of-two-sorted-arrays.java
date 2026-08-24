class Solution {
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        if(num1.length>num2.length){
            return findMedianSortedArrays(num2,num1);
        }
        int n=num1.length;
        int m=num2.length;

        int low=0; int high=n;
        while(low<=high){
            int part1= (low+high)/2; //part1 is mid of our binary search
            int part2=((n+m+1)/2)-part1;

            int maxleftnum1= (part1==0) ? Integer.MIN_VALUE : num1[part1 - 1];
            int maxleftnum2= (part2==0) ? Integer.MIN_VALUE : num2[part2 - 1];
            int minrightnum1=(part1==n) ? Integer.MAX_VALUE : num1[part1];
            int minrightnum2=(part2==m) ? Integer.MAX_VALUE : num2[part2];

            if(maxleftnum1<=minrightnum2&&maxleftnum2<=minrightnum1){
                if((n+m)%2==0){
                    return (Math.max(maxleftnum1,maxleftnum2)+Math.min(minrightnum1,minrightnum2))/2.0;
                }
                else{
                    return (Math.max(maxleftnum1,maxleftnum2));
                }
                }
            else if(maxleftnum1>minrightnum2){
                    high=part1-1;   // relocating our high to change the mid(part1) searching only in left half, eliminating right half

            }
            else{
                low=part1+1;
            }
        }
        return 0.0;

        
        
    }
}