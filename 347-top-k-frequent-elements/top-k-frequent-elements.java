class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //k most frequent element
        //top k gives hint for priority queue of min heap
        //but we need to prioritise them on the basis of frquency 
        //frequency can be calculated using hashmap
        //hence the approach will be hashmap+min heap(priority queue)
        //we will maintain min heap of k elements 
        //always remove the topmost element(least frequent element) 
        //atlast we have top k most frequent elements
        
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int n:nums){
            hm.put(n,hm.getOrDefault(n, 0)+1);
        }
        //min heap which compares frequences rather than numbers
        //hm.get(key) gives frequency of particular number
        PriorityQueue<Integer> pq =new PriorityQueue<>((a, b) -> hm.get(a) - hm.get(b));
        for(Integer key:hm.keySet()){
            pq.add(key);
            //whenever size>k
            //remove top(least frequent)
            if(pq.size()>k){
                int j=pq.peek();
                pq.poll();
            }
        }
        int ans[]= new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }
        return ans;
    
        
        
    }
}