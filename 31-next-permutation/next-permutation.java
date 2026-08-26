class Solution {
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                int k=0;
                for(int j=nums.length-1;j>=i;j--){
                    if(nums[j]>nums[i-1]){
                        k=j;
                        break;
                    }
                }
                int temp=nums[i-1];
                nums[i-1]=nums[k];
                nums[k]=temp;

                int r=nums.length-1;
                while(i<r){
                    int emp=nums[i];
                    nums[i]=nums[r];
                    nums[r]=emp;
                    i++;
                    r--;
                }
                break;
            }else if(i==1){
                int k=nums.length-1;
                int z=i-1;
                while(z<k){
                    int emp=nums[z];
                    nums[z]=nums[k];
                    nums[k]=emp;
                    z++;
                    k--;
                }
            }
        }
    }
}