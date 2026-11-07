class Solution {
    public int findMaxLength(int[] nums) {
        //Contigous array
        //array with equal number of zeros and ones

        //first observation- whenever an subarray have equal no. of zero and one: 
        //its sum(i.e number of 1s)=(ending position(ending index of subarray(i))-startingposition(starting index of subarray(j)))/2
        //ones=(i-j)/2
        //2*Ones(of current subarray)=i-j(number of element in subarray)
        //2*Ones(current subarray)=Ones(of current subarray)+Zeros(of current subarray)
        //2*Ones-(Ones+Zeros)=0
        //Ones-Zeros=0

        //hence this equation tells us that whenever difference between number of ones and number of zeros is zero our subarray will have equal number of ones and zeros

        //key idea:
        //instaed of treating one as 1 ann zero as 0
        //treat them as ONe:+1 and Zero:-1
        //hence whenever we have equal zeros and ones there sum automatically becomes zero

        //Prefix:
        //whenever we calculate prefix treat One as +1 and zero as -1
        //there may more than one same prefix 
        /*
        index:       0    1    2    3    4    5    6    7
        nums:        1    1    1    0    1    0    0    1
                    ↓    ↓    ↓    ↓    ↓    ↓    ↓    ↓
        change:     +1   +1   +1   -1   +1   -1   -1   +1

        balance:    +1   +2   +3   +2   +3   +2   +1   +2
        (prefix)          ↑         ↑         ↑         ↑
                         +2        +2        +2        +2
        */ 
        //our observation says that:
        //if we get a prefix at one position
        //and again we get that same prefix anywhere front in array
        //it means that in between both positions 0s and ones have contributed equally
        //but note that first we get a prefix at i index and later at j
        //than the subarray which is balanced is from i+1

        //MOST IMPORTANT key Finding:
        //hence we will always try to find the same prefix(balance) that we have seen before at earliest positiom
        //earliest postion will give us longest subarray

        //HashMap:
        //we will store prefix->position(index)in hashmap
        //and try to find out the current prefix at earliest position
        //but Hashmap dont store duplicate keys althoug hour prefix will be same
        //but here comes the main part we are only going to store the prefix which comes first 
        //if it comes again we will just check whether it exist in map and calculate our subarray length
        //but we will not add it again as we want longest subarray 
        //and the earliest prefix will give us that

        //Final Indexing:
        //we will start our indexing from -1:
        /*
        index:      -1   0    1    2    3    4    5    6    7
        nums:        -   1    1    1    0    1    0    0    1
                     ↓   ↓    ↓    ↓    ↓    ↓    ↓    ↓    ↓
        change:      -  +1   +1   +1   -1   +1   -1   -1   +1

        balance:     0  +1   +2   +3   +2   +3   +2   +1   +2
        */ 
        //for equal prefix at j and i index our balanced subarray will be j+1 to i
        //to avoid this conflict we use dummy index -1 which help us to calulate subarray length
        //from its own index
        //i.e for equal prefix at j and i our subarray length will be i-j
        //also it helps for subarrays starting from zeroth index

        //hashmap containg prefix with there index
        HashMap<Integer,Integer> map= new HashMap<>();
        //insert first index
        map.put(0,-1);
        //max will store max length
        int max=0;
        //pre will store current prefix
        int pre=0;
        for(int i=0;i<nums.length;i++){
            //for zero-> -1
            if(nums[i]==0){
                pre+=-1;
            }
            //for one-> +1
            else{
                pre+=1;
            }
            //check we have same prefix
            if(map.containsKey(pre)){
                //if yes get its index and calculate length of subarray
                //using:current index - previous prefix index
                max=Math.max(max,i-map.get(pre));
            }
            //if we are seeing that prefix for first time add it in map
            else{
            map.put(pre,i);
            }
        }
        return max;
        
    }
}
