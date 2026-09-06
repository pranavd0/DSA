import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Array_Questions{
    int[] l1minmax(int[] a){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            max=Math.max(a[i], max);
            min=Math.min(a[i], min);
        }
        return new int[]{max,min};
    }
    int[] l2reverse(int[] a){
        int[] rev= new int[a.length];
        for(int i=0;i<a.length;i++){
            rev[i]=a[a.length-1-i];
        }
        return rev;
        
    }
    int[] l2OreverseOptimal(int[] a){
        int l=0;
        int r=a.length-1;

        while(l<r){
            int temp=a[l];
            a[l]=a[r];
            a[r]=temp;
            l++;
            r--;
        }
        return a;
    }
    int l3maxsubarrsumkedan(int[] a){
        int maxsum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            maxsum=Math.max(maxsum, sum);
            if(sum<0){
                sum=0;
            }

        }
        return maxsum;
    }
    int l42trapped_water(int[] a){
        int leftmax= Integer.MIN_VALUE;
        int rightmax= Integer.MIN_VALUE;
        int l=0, r=a.length-1, water=0;
        
        while(l<r){
            if(a[l]<a[r]){
                //first we will consider the lowest height among left and right so it will be safe to 
                //calculate the water in that side
                if(a[l]<leftmax){
                    //if the currheight is less than max height we subtract that height from max height 
                    //because the water will be present on the block so the hight diff will us that wter quantity
                    water+=(leftmax-a[l]);
                    l++;
                }
                else{
                    //if curr height is greater than max height of that side we will not calculate water 
                    //we will just change our leftmax
                    leftmax=a[l];
                    l++;
                }
            }
            else{
                //if right height is smaller we will perform same operations on right
                if(a[r]<rightmax){
                    water+=(rightmax-a[r]);
                    r--;
                }
                else{
                    rightmax=a[r];
                    r--;
                }
            }
        }
        return water;
    }
    boolean l217Duplicate(int[] a){
        HashSet<Integer> set= new HashSet<>();
        for(int i: a){
            if (set.contains(i)){
                return true;
            }
            else{
                set.add(i);
            }
        }
        return false;
        
    }
    int g_ChoclateDistribution(int[] a,int m){
        Arrays.sort(a);
        int l=0;
        int currMin=0;
        int minDiff=Integer.MAX_VALUE;
        for(int r=0;r<a.length;r++){
            if(r-l+1==m){
                currMin=a[r]-a[l];
                minDiff=Math.min(minDiff, currMin);
                l++;    
            }
        }
        return minDiff;
    }
    int l33rotatedSortedarr(int[] a, int k) {

        int left = 0;
        int right = a.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (a[mid] == k) {
                return mid;
            }

            // Left half is sorted
            if (a[left] <= a[mid]) {

                // Target lies in the sorted left half
                if (a[left] <= k && k < a[mid]) {
                    right = mid - 1;
                }
                // Target lies in the other half
                else {
                    left = mid + 1;
                }

            }

            // Right half is sorted
            else {

                // Target lies in the sorted right half
                if (a[mid] < k && k <= a[right]) {
                    left = mid + 1;
                }
                // Target lies in the other half
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
    void l31nextPermutation(int[] nums) {
        //in this que we will use a stratergy which check elements from last
        //find the pair which has right element greater than left(left willbecome pivot)
        //it tells us thst swapping this elements or making changes in right side of this elements
        //will give us next permutation
        //now what changes?
        //we will again find from right a element which is greater than our pivot
        //we will swp that element with pivot as it is the smallest element present in right part(after pivot)
        //now we will reverse the array after pivot as the current sturcture is in descending order
        //i.e larger number first
        //we will get elements in asscending ordr i.e. smallest element
        //which we needfor next permutation

        //first lop for finding pivot element
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                int k=0;
                //this loop for finding succesor element i.e just greater element than pivot
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

                //reverse the array from pivot+1(next element of pivot) till end
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
    int l121maxProfit(int[] prices) {
        int maxprofit=0;
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++){
            int currprice=prices[i];
            if(currprice<min){
                min=currprice;
            }
            else{
                int profit=currprice-min;
                maxprofit=Math.max(maxprofit,profit);
            }
        }
        return maxprofit;
    }
    int l215findKthLargest(int[] nums, int k) {
        //we will create a heap
        //heap is a data structure which makes a tree in which min or max among all the elemnts is always at the top of the tree
        //if we consider min heap than smallest element will be at topmost root and the next greater element will be on its left child node and than right child node
        //here we will create a min heap of size k and add elements one by one in it
        //whenever the size exceeds we will remove the topmost element(smallest) element from heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer i:nums){
            pq.add(i);
            //first we add the elemnt in heap and then check its size if its greater than k than remive the top
            //most elemnt  
            if(pq.size()>k){
                pq.poll();
            }
            //at the end this will give us min heap of k largest elemnt among all of them and the topmost elemnt 
            //will be our kth largest elemnt 
        }
        return pq.poll();

    }
    int[] l238productExceptSelf(int[] nums) {
        //as we cant use division we will use use the pre multipilcation and post multiplication for each number of array
        //first we will calculate the leftmultiplication of each number(0 to i-1) and than add it to the answer array
        //than we will calculate right multi in same way and then multiply it with answer[i] i.e the leftmulti of that number(index)
        int leftmulti=1;
        int rightmulti=1;
        int [] answer= new int[nums.length];
        //there is no elemeny in left of first element so we will keep it as 1
        //and start loop from 1
        answer[0]=1;
        //left multi calculation loop
        for(int i=1;i<nums.length;i++){
            leftmulti*=nums[i-1];
            answer[i]=leftmulti;
        }
        //right multi calculation loop 
        //right most(end) element dont have any element on right since we will start loop from n-2
        for(int i=nums.length-2;i>=0;i--){
            rightmulti*=nums[i+1];
            answer[i]*=rightmulti;
        }
        return answer;
    }
    int[] l239maxSlidingWindow(int[] nums, int k) {
        //we will need the deque to solve this problem as we need to add and remove the element from both sides
        //we can also solve the problem with the help of priority queue but the time complexity of remove function is high
        //we will keep largest element of the current window in front side of deque
        //we just store the indices of element not the actual element to avoid confusion
        //while adding element we will add it from last
        //if current element is greater than last element of dq we will remove it  
        Deque<Integer> pq=new ArrayDeque<>();
        int fw[]=new int[nums.length-k+1];
        int l=0;
        for(int r=0;r<nums.length;r++){
            //removing the elements smaller than r from back side
            while(!pq.isEmpty()&&(nums[r]>nums[pq.peekLast()])){
                pq.pollLast();
            }
            //now add that element from last(back side)
            pq.offerLast(r);

            if(r-l+1==k){
                //add first element in array as its the largest element of window
                fw[l]=nums[pq.peekFirst()];
                //as our oldest element will be on the first(front) side we will check it 
                //it will be on first position as we remove elments from last
                //if its equal to l we will remove it
                //as we remove lot of elements at the time of appending the elements in dq
                //hence we need to check whether l exist or not in our dq
                if (pq.peekFirst() == l) {
                    pq.pollFirst();
                }
                l++;
            }
        }
        return fw;
    }
    ArrayList<Integer> ib_repeatedNumber(final List<Integer> A) {
        //in this question we cannot use extra memory
        //we have given first n numbers 
        //hence we know 2 properties of first n numbers 
        //i.e sum of first n numbers and sum of products of first n numbers
        //we can can calulate sum og given numbers 
        //also we can calculate sum of squares of first n numbers
        //than we formulas for both 
        //so we have actual sum, actual sqauresum, expextedsum(using formula),expextedswm(using formula)
        //by mathematics:
        //actualsum-expextedsum=duplicate-missing
        //actualsqauresum-expextedsquaresum=(duplicate-missing)*(duplicate+missing)
        long actualSum = 0;
        long actualSquareSum = 0;

        long n = A.size();

        for (int num : A) {
            actualSum += num;
            actualSquareSum += (long) num * num;
        }

        long expectedSum = n * (n + 1) / 2;
        long difference = actualSum - expectedSum;

        long expectedSquareSum = n * (n + 1) * (2 * n + 1) / 6;
        long squareDifference = actualSquareSum - expectedSquareSum;
        //sum is duplicate +missing
        //as we have equation:
        //actualsqauresum-expextedsquaresum=(duplicate-missing)*(duplicate+missing)
        long sum = squareDifference / difference;

        long duplicate = (sum + difference) / 2;
        long missing = duplicate - difference;

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add((int) duplicate);
        ans.add((int) missing);

        return ans;
    }
    int[] l645findErrorNums(int[] nums) {
        //frequency array
        //as we have continous elements from 1 to n
        //if freq=0 ->missing
        //if freq=2 ->duplicate
        int[] count= new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int[] ans=new int[2];
        for(int i=1;i<count.length;i++){
            if(count[i]==2){
                ans[0]=i;
            }
            if(count[i]==0){
                ans[1]=i;
            }
        }
        return ans;
        
    }
    int l152maxProduct(int[] nums) {
        //dynamic programming 
        //to calculate max product among all subarrays
        //we will keep track on max and min product at each position
        //as greatest negative number mulyiplying with negative number can give us the maxproduct
        //we will calucate max and min product among all subaarays ENDING on ith position for every iteration

        //this are the maxproduct and min product of current subbarays which Ends on ith poistion of loop
        int maxproduct = nums[0];
        int minproduct = nums[0];
        int ans=nums[0];

        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            //we use this 2 extra variables as our values of maxproduct and minproduct may change during comparison
            int oldMax = maxproduct;
            int oldMin = minproduct;
            //we compare among 3 (curr,max*curr,min*curr)
            maxproduct = Math.max(curr, Math.max(oldMax * curr, oldMin * curr));
            minproduct = Math.min(curr, Math.min(oldMax * curr, oldMin * curr));
            //our ans stores the final maximum product
            ans=Math.max(ans,maxproduct);
        }
        //image provided for better understanding (Home->Mission 2026)
        return ans;
        
    }
    int l1984_g_minimumDifference(int[] nums, int k) {
        //here we want highest and lowest scores close to each other 
        //it will difficult find them individually
        //hence we will sort the arrray and all the elments automatically gets closer to each other
        //after sorting we can easily use the slididng windowof size k
        //as array is sorted the r will give us highest of the subarray
        //l will show lowest
        Arrays.sort(nums);
        int l=0;
        int difference=Integer.MAX_VALUE;
        for(int r=0;r<nums.length;r++){
            if(r-l+1==k){
                int d=nums[r]-nums[l];
                difference=Math.min(difference,d);
                l++;
            }
        }
        return difference;
        
    }
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
} 