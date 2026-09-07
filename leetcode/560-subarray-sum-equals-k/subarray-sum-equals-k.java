import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // subarray sum
        // it gives hint for prefix sum
        // here we can apply prefix sum but prefix sum gives us sum from 0to ith element 
        // but we want sub array sum=k
        // prefix[i]-prefix[0 to i-1]=k(subarraysum)
        // i.e currentprefix-anyofpreviousprefix=k(subarraysum)
        // anyofprevprefix(ifexist)=currprefix-k
        // hence we will calculate prefix sum and always check whether any prefix exist for 
        // currprefix-k
        // if exist it means there is subarray with sum k
        // but to check whethere we have any prevprefix 
        // we will need contains function-> hashmap

        // we will create n+1 prefix hashmap
        // whileadding prefix we will check whether there exist any prefix=currprefix-k
        HashMap<Integer, Integer> prefix = new HashMap<>();
        // as we have to make prefix of [n+1] pattern
        // intialiste first key with 0
        prefix.put(0, 1);
        // pre will be our currprefix
        int pre = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // calculate currprefix
            // formula for n+1 prefix-> prefix[n+1]=prefix[i]+arr[i]
            // here as we intialised hashmap with we are already a index head in prefix compared to array
            pre = pre + nums[i];
            // check for currprefix-k
            if (prefix.containsKey(pre - k)) {
                // if exist add all its ocurrances(i.e frequency)
                count += prefix.get(pre - k);
            }  
            // add curr prefix in map
            prefix.put(pre, prefix.getOrDefault(pre, 0) + 1);  
        }
        return count;
    }
}
