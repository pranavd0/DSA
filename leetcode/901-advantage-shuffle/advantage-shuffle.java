class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Integer[] index=new Integer[nums2.length];
        for(int i=0;i<nums2.length;i++){
            index[i]=i;
        }
        Arrays.sort(index, (a, b) -> nums2[b] - nums2[a]);
        int[] ans= new int[nums1.length];
        int l=0;
        int r=nums1.length-1;
        for(int i=0;i<nums2.length;i++){
            if(nums1[r]>nums2[index[i]]){
                ans[index[i]]=nums1[r];
                r--;
            }
            else{
                ans[index[i]]=nums1[l];
                l++;
            }
        }
        return ans;

    }
}