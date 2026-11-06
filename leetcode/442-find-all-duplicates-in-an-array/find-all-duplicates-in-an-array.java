class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //for every element marks the element -1 th index elment as negative 
        //element -1 th index elment is already negative than that elment is duplicate 
        ArrayList<Integer> res = new ArrayList<>();

        for(int i =0; i<nums.length; i++)
        {
            if(nums[Math.abs(nums[i])-1]<0)
            {
                res.add(Math.abs(nums[i]));
            }
            else
            {
                nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i])-1];
            }
        }

        return res;
        
    }
}
