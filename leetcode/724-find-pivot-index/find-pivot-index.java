class Solution {
    public int pivotIndex(int[] nums) {
        //we will build prefix as well as suffix for the array of size n+1
        //here in the question they tolf us to exclude current element 
        //so n+1 prefix and suffix array will be most useful here
        //we want first pivot from left 
        //hence we will build suffix first bcoz while building prefix we can check the condition for pivot along with building of prefix
        int[] suffix=new int[nums.length+1];
        //sufix n+1
        /*  arr:     2   4   1   5   3
                     ↓   ↓   ↓   ↓   ↓
            suffix:  2   6   7   12  15  0
        */ 
        //for suffix of n+1
        //there is no +1 conflict suffix of each element belong to there index
        for(int i=nums.length-1;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i];
        }

        int[] prefix=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            //while building prefix check for pivot
            if(prefix[i]==suffix[i+1]){
                return i;
            }
            prefix[i+1]=prefix[i]+nums[i];
        }
        
        
        return -1;
        
    }
}