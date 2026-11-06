class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int freq[]= new int[nums.length+1];

        for(int i =0; i< nums.length; i++)
        {
            freq[nums[i]]++;
        }
        ArrayList<Integer> res = new ArrayList<>();

        for(int i =1; i<freq.length; i++)
        {
            if(freq[i] == 2)
            {
                res.add(i);
            }
        }

        return res;
        
    }
}
