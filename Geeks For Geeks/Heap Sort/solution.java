/*
 * Platform: GeeksforGeeks
 * Problem: Heap Sort
 * URL: https://www.geeksforgeeks.org/problems/heap-sort/1
 * Language: Java
 * Difficulty: Medium
 * Topics: Amazon, Microsoft, Samsung, 24*7 Innovation Labs, Oracle, Visa, Intuit, SAP Labs
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-11-04T05:11:20.954Z
 */

class Solution {
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[]) {
        // code here
        int n=arr.length;
        //build complete maxheap
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
        
        for(int i=n-1;i>0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            
            heapify(arr,i,0);
        }
        
    }
    
    private void heapify(int[] arr, int n, int i) {

        while (true) {

            int largest = i;

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Check left child
            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            // Check right child
            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            // Parent is already largest
            if (largest == i) {
                break;
            }

            // Swap
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Continue downward
            i = largest;
        }
    }
}
