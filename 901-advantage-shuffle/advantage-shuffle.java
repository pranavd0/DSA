class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        //here we need to find the smallest element from nums1 which is just greater than nums2 element for every element of nums2 
        //TreeGraph is Datastructure which stores the elmenets in key value pair but as like min heap
        //smallest element at root
        //it has function which will give us element just greater than given element i.e higher key
        //we will add all elements of nums1 in treemap
        //find just greater element for every element for nums2
        //if greater element not found than we will add the smallest remaining element in such position
        //after adding that element in ans we will remve that element from tree
        TreeMap<Integer,Integer> t =new TreeMap<>();
        //first add all elements in tree
        for(int n:nums1){
            t.put(n,t.getOrDefault(n,0)+1);
        }

        int[] ans =new int[nums1.length];
        //now find just greater element for every element of nums2
        for(int i=0;i<nums2.length;i++){
            //this function will give us that value
            Integer key=t.higherKey(nums2[i]);
            //if we dont get element greater than nums2[i] than add smallest element remaiang in that position
            if(key==null){
                //first key will give us smallest element remaing in our tree
                key=t.firstKey();
            }
            
            ans[i]=key;
            //after using that element remove its one occurance from tree
            t.put(key,t.get(key)-1);
            if(t.get(key)==0){
                t.remove(key);
            }
        }
        return ans;
    }
}