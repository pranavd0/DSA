/*
 * Platform: GeeksforGeeks
 * Problem: Next Permutation
 * URL: https://www.geeksforgeeks.org/problems/next-permutation5226/1
 * Language: Java
 * Difficulty: Medium
 * Topics: Infosys, Flipkart, Amazon, Microsoft, FactSet, Hike, MakeMyTrip, Google
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-11-04T05:11:48.281Z
 */

class Solution {
    void nextPermutation(int[] nums) {
        // code here
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                int k=0;
                //this loop for finding succesor element i.e first greater element than pivot
                for(int j=nums.length-1;j>=i;j--){
                    if(nums[j]>nums[i-1]){
                        k=j;
                        break;
                    }
                }
                //swap successor and pivot
                int temp=nums[i-1];
                nums[i-1]=nums[k];
                nums[k]=temp;

                //reverse the array from pivot+1 till end
                int r=nums.length-1;
                while(i<r){
                    int emp=nums[i];
                    nums[i]=nums[r];
                    nums[r]=emp;
                    i++;
                    r--;
                }
                break;
            }
            //if we on last permutation just reversing the whole array
            else if(i==1){
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
