
import java.util.HashMap;

import java.util.PriorityQueue;

public class Heap_Question {
    class Heapsort_l912 {
    int[] l912_HeapSort_sortArray(int[] nums) {
        int n=nums.length;
        //build max heap
        //building a complete max heap always works on BOTTOM UP approach
        //as we have to heapify all the nodes-> we have to heapify in bottom up approach
        //heapify just heapifies the current tree starting from the given node to the one side 
        //it doesnt check the subtrees of its silbling node(rather it doesnt check its sibling) 
        //but here we have to build max heap of whole tree means we have to consider every node of tree
        //heance here we sequentially check all the nodes from bottom till up and make it complete max heap
        //we dont have to check leaf nodes
        //heance we start from first non leaf node i.e---> n/2-1  where n is length
        for(int i=n/2-1;i>=0;i--){
            heapify(nums,n,i);
        }
        //now heap sort algorithm tells-
        //whenever we get max heap 
        //the max elment is at first index so swap it with last element 
        //now the elment is started 
        //move our pointer forward which was pointing to the last
        //heapify the remaining array (excluding last which is sorted)
        //again swap first with our pointer and move the pointer
        /*
        *1. set pointer on last
        *2. swap first and last
        *3. heapify remaing array till last(exclude)
        *4. pointer--
        *5. swap and repeat
        */ 
        //in this way make two parts sorted and usorted 
        //the array after our pointer comes under sorted part
    
        for(int i=n-1;i>0;i--){
            //swAP first and i
            int temp=nums[i];
            nums[i]=nums[0];
            nums[0]=temp;
            //heapify remaining array
            heapify(nums,i,0);
        }
        return nums;   
    }
    private void heapify(int[] arr,int n,int i){
        //heapify function works on TOP DOWN approach
        //it heapifies the current parent node 
        //but it continues to check the child which with the parent has been swapped
        //becasue even after swapping there may be error in the down the tree
        //it heapifies until the current parent node is greater than both the childs
        //whenevr it get parent greater than both th childs it stops 
        //here n tells us the position until which we have to heapify(n is excluded)
        while(true){
            //here i is our parent node from where we are starting to heapify 
            int leftChild=i*2+1;
            int rightChild=i*2+2;
            //now we will find who is larger among parent and childrens
            //thats why intially we take parent as a largest
            int largest =i;
            //if our left child is greater we will say it largest
            //we will always check n for both the childs as we have to heapify till n only 
            //n is the bottom limit of heapify
            if(leftChild<n&&(arr[leftChild]>arr[largest])){
                largest=leftChild;
            }
            //if our right child is greater we will say it largest
            if(rightChild<n&&(arr[rightChild]>arr[largest])){
                largest=rightChild;
            }
            //if no changes happens means parent himself is largest we will stop the loop
            if(largest==i){
                break;
            }
            //swap parent with largest child
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            //now again start heapifying from that child
            i=largest;


        }
    }
    }
    int[] l347topKFrequent(int[] nums, int k){
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
    

