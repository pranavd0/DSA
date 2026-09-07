/*
 * Platform: GeeksforGeeks
 * Problem: Multiply Two Linked Lists
 * URL: https://www.geeksforgeeks.org/problems/multiply-two-linked-lists/1
 * Language: Unknown
 * Difficulty: Easy
 * Topics: Amazon, Linked List, Modular Arithmetic
 * Runtime: 0.14 s
 * Memory: N/A
 * Synced: 2026-09-07T18:29:18.410Z
 */

if(first==null||second==null){
             return 0;
         }
         //in this question we will form awhole numbers from individual nodes of linked list
         //and then multiply both numbers and return ans
         //to form number we will 
         //we will traverse the ll while traversing as we move from higherv bits to lower 
         //we will multiply our number by 10 and then add the current node element in our number
         //but here is one problem when we form a number in such way than the number can get very large
         //even grater than long thats why que told us to give modulus of multiplication modulus by 1000000007
         //but doing modulus after multiplication is ok
         //but what if already 2 numbers are very huge 
         //hence we perform modulus at each stage 
         //and after multiplication this gives us the same answer
         Node curr=first;
         long mod=1000000007;
         long firstnomod=0;
         while(curr!=null){
             firstnomod=(firstnomod*10+curr.data)%mod;
             curr=curr.next;
         }

         curr=second;
         long secondnomod=0;
         while(curr!=null){
             secondnomod=(secondnomod*10+curr.data)%mod;
             curr=curr.next;
         }
         return (int)((firstnomod*secondnomod)%mod);
        
            
    }
}
