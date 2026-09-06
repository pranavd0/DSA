import java.util.HashMap;

public class Prefix_sum {
    //prefix_sum[i]=sum of elements of array from 0 to ith position
    /* 
    arr:     2   4   1   5   3
             ↓   ↓   ↓   ↓   ↓
    prefix:  0   2   6   7   12  15

    java standard template:
    int n = arr.length;

    int[] prefix = new int[n + 1];

    for(int i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + arr[i];
    }

    we start prefix from i=1 to avoid the conflict at index 0
    */
   //1480 → 303 → 724 → 560 → 525 → 974


    //1. normal n size prefix sum
    int[] l1480runningSum(int[] nums) {
        //here we will create a nomral nsize prefix as we dont have to acces the elments
        //so we will not face 0th index conflict
        int[] prefix=new int[nums.length];
        int currsum=0;
        for(int i=0;i<nums.length;i++){
            currsum=currsum+nums[i];
            prefix[i]=currsum;
        }
        return prefix;
        
    }
    int l303sumRange(int left, int right,int[] arr) {
        //here we will create a prefix array with n+1 size
        //standard formula for n+1 prefix array
        //prefix[n+1]=prefix[i]+arr[i];
        int[] prefix=new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            prefix[i+1]=prefix[i]+arr[i];
        }

        return prefix[right+1]-prefix[left];
    }
    
    //2. prefix and suffix
    int l724pivotIndex(int[] nums) {
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
    
    //3.prefix sum+hashmap
    int l560subarraySum(int[] nums, int k) {
        //subarray sum
        //it gives hint for prefix sum
        //here we can apply prefix sum but prefix sum gives us sum from 0to ith element 
        //but we want sub array sum=k
        //prefix[i]-prefix[0 to i-1]=k(subarraysum)
        //i.e currentprefix-anyofpreviousprefix=k(subarraysum)
        //anyofprevprefix(ifexist)=currprefix-k
        //hence we will calculate prefix sum and always check whether any prefix exist for 
        //currprefix-k
        //if exist it means there is subarray with sum k
        //but to check whethere we have any prevprefix 
        //we will need contains function-> hashmap

        //we will create n+1 prefix hashmap
        //whileadding prefix we will check whether there exist any prefix=currprefix-k
        HashMap<Integer,Integer> prefix=new HashMap<>();
        //as we have to make prefix of [n+1] pattern
        //intialiste first key with 0
        prefix.put(0,1);
        //pre will be our currprefix
        int pre=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            //calculate currprefix
            //formula for n+1 prefix-> prefix[n+1]=prefix[i]+arr[i]
            //here as we intialised hashmap with we are already a index head in prefix compared to array
            pre=pre+nums[i];
            //check for currprefix-k
            if(prefix.containsKey(pre-k)){
                //if exist add all its ocurrances(i.e frequency)
                count+=prefix.get(pre-k);
            }  
            //add curr prefix in map
            prefix.put(pre,prefix.getOrDefault(pre,0)+1);  
        }
        return count;

        
    }
}
