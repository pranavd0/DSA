import java.util.Arrays;
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        //first we will store all occurances of x in temp array
        int[] temp=new int[nums.length];
        Arrays.fill(temp,-1);

        //fid occurances will modify our temp array and fill the indices of occurances of x in it
        //we will pass 2 index 
        //i for nums 
        //j for temp
        findOccurance(nums,x,0,0,temp);

        //ans array will store  final answer
        int ans[]=new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            
            //our queries have indices starting from 1 but temp contains from 0
            //so -1 to match the indices
            int q = queries[i] - 1;

            if(q < nums.length && temp[q] != -1){
                ans[i] = temp[q];
            }
            else{
                ans[i] = -1;
            }
        }
        return ans;
    }
    void findOccurance(int[] nums,int x,int i,int j,int[] temp){
        //f(n)=(nums[i]==x)+f(i+1)
        if(i>=nums.length){
            return;
        }
        //if x occures than store it in jth index of temp
        if(nums[i]==x){
            temp[j]=i;
            //increase the j
            j++;
        }

        findOccurance(nums,x,i+1,j,temp);
    }
}
