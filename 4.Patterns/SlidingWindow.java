import java.util.*;

//Practice progression

    //Beginner
    //1. Maximum sum subarray of size K
    //2. Average of subarrays of size K
    //3. First negative number in every window

    //Intermediate
    //4. Longest substring without repeating characters
    //5. Maximum number of vowels in a substring of size K
    //6. Longest substring with at most K distinct characters
    //7. Longest subarray with at most K zeros

    //Advanced
    //8. Permutation in String
    //9. Find All Anagrams in a String
    //10. Longest Repeating Character Replacement
    //11. Subarrays with K Different Integers
    //12. Minimum Window Substring
    //13. Sliding Window Maximum

public class SlidingWindow {
    //First Type:Fixed size sw

    //our key approach will be:
    //   1.take 2 pointers from 0th position
    //   2.move first pionter until our window gets of size k
    //   3.use 'if' to check size of window if it is of size k move l++
    //   4.note:we can move each pinter max once in every iteration

    //1.Maximum sum subarray of size K
    int maxsumofsubarrsizek(int[] a, int k){
        int l=0;
        int sum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int r=0;r<a.length;r++){
            sum+=a[r];
            if(r-l+1==k){//condition until our meets the k'th position also for some last edge of arrray
                maxsum=Math.max(maxsum, sum);
                sum-=a[l];//maintaining the window if we add in window than we have to remove to miantain its 
                // fixed size
                l++;
            }
        }
        return maxsum;
    }
    //2.Average of subarrays of size K
    double[] avgsubarrsizek(int[]a, int k){
        int l=0;
        int sum=0;
        double[] avg= new double[a.length-k+1];//a.length-k+1 to make the array of exact size as the no.of 
        // subarrays wil form of size k

        for(int r=0;r<a.length;r++){
            sum+=a[r];
            if(r-l+1==k){
                avg[r]=(double)sum/k;
                sum-=a[l];
                l++;
            }

        }
        return avg;

    }
    //3.First negative number in every window
    int[] firstnegativeofsubarr(int[]a, int k){
        int l=0;
        int index=0;

        int[] first_negative=  new int[a.length-k+1];

        for(int r=0;r<a.length;r++){
            if(r-l+1==k){
                // Find first negative in current window
                int i=l;
                //in slidig we window we can move l and r only onve at at time so we will give value of l to i
                //  so it can move freely in current sub array to find its first negative element 
                while(i<r){
                    if(a[i]<0){
                        first_negative[index]=a[i];
                        break;
                    }
                    i++;
                }
                index++;
                l++;
            }
        }
        return first_negative;
    }
    //5. Maximum number of vowels in a substring of size K
    int maxvovelsinSubString(String s, int k){
        int l=0;
        int maxvovel=0;
        int vovel=0;
        //intialised left and right from zero 
        for(int r=0;r<s.length();r++){
            //while increasing the window we will keep track on vovels
            //if we get vovels we increase vovel count
            if(s.charAt(r) == 'a' || s.charAt(r) == 'e' || s.charAt(r) == 'i' || s.charAt(r) == 'o' || s.charAt(r) == 'u'){
                vovel++;
            }
            
            if(r-l+1==k){
                //now when we shrink our window we also have to remove the previously counted vovels 
                //so we check whether it comes on our left pointer and then decrease our left pointer
                //before reducing our vovvels we calculate max vovels
                maxvovel=Math.max(vovel,maxvovel);
                if(s.charAt(l) == 'a' || s.charAt(l) == 'e' || s.charAt(l) == 'i' || s.charAt(l) == 'o' || s.charAt(l) == 'u'){
                    vovel--;
                }
                l++;
            } 
        }
        return maxvovel;
    
    }
    //sortng+fixed size sw
    int l1984minimumDifference(int[] nums, int k) {
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
    //----------------------------------------------------------------------------------
    //Second type: Variable length sw::

    //main key to make a variable length window is:
    //   1.we have to move right until our condition get invalid
    //   2.After condition invalidation we will move (shrink) left until our condition comes in valid stage
    //   3.for moving left we will use 'while' instead of 'if' (as we use 'if' in the fixed sw )
    //   4.main motive is grow and shrink

    //4.Longest substring without repeating characters
    int longestDistinctsubstr(String s){
        int l=0;
        int max=0;
        //we will hashset as if to check whether the current chrecter already exist or not
        //we will keep the current non repeating substring in the hashset 
        HashSet <Character> m=new HashSet<>();
        for(int r=0;r<s.length();r++){
            //first we will check whether the character already exist in our hashset 
            //if yes we shrink our left until we remove it
            while(m.contains(s.charAt(r))){
                m.remove(s.charAt(l));
                l++;
            }
            //we add that chracter in hashset
            m.add(s.charAt(r));

            max=Math.max(max,r-l+1);
        }
        return max;
    }

    //6. Longest substring with at most K distinct characters
    int maxSubstringWithAtMostkDistinctElements(String s,int k){
        //we will use the hashmap to keep track on the chrecters as well as there frequencies
        int l=0;
        int maxsize=0;
        //we will add each chracter into the hashmap
        HashMap <Character,Integer> m=new HashMap<>();
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            m.put(ch, m.getOrDefault(ch, 0)+1);
            // after adding we will check how much distinct elemnts we currently hold 
            //we shrink our window until our distinct elements comes under k
            while(m.size()>k){
                m.put(s.charAt(l), m.get(s.charAt(l))-1);
                if(m.get(s.charAt(l))==0){
                    m.remove(s.charAt(l));
                }
                l++;
            }
            maxsize=Math.max(maxsize, r-l+1);
        }
        return maxsize;
        /*overall logic:
              right expands
                    ↓
            Add character to map
                    ↓
            map.size() > k ?
                ↙       ↘
                YES        NO
                ↓          ↓
        shrink window   calculate
                ↓
        remove left char
                ↓
            left++ */
    }
        
    
}
