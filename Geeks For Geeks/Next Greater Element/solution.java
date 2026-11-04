/*
 * Platform: GeeksforGeeks
 * Problem: Next Greater Element
 * URL: https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
 * Language: Java
 * Difficulty: Medium
 * Topics: Flipkart, Amazon, Microsoft, MakeMyTrip, Adobe, Stack
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-11-04T05:09:18.743Z
 */

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        //next greater element in the right
        //for each element find first greater than it in right of it
        //here order matters 
        //we want first element int the right but whuch should be greater also
        //hence: ORDER-> stack
        // we wil start with empty stack 
        //start processing array from right
        //whenever we get element greater than itself stop 
        //until than pop  all elements as they wont be useful for any further elements in left
        //as the that specific element is greater than them hence next elements can use it only
        //if we dont found any element add -1
        //if we found than we will add that specific in ansi.e stack.peek()
        //add the current element in stack everytime
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> stack= new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            //pop elements until we get element>current
            while(!stack.isEmpty()&&stack.peek()<=arr[i]){
                stack.pop();
            }
            //if noy found 
            if(stack.isEmpty()){
                ans.add(-1);   
            }
            //if found stack.peek()
            else{
                ans.add(stack.peek());
            }
            //add every element in stack
            stack.push(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
