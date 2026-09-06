import java.util.HashSet;

public class LinkedList_Question {
    class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}   
class LinkedList{
    class l707MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;

    public l707MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        if(index<0){
            return -1;
        }
        Node curr=head;
        int i=0;
        while(i!=index&&curr!=null){
            curr=curr.next;
            i++;
        }
        if(curr==null){
            return -1;
        }
        return curr.val;
        
    }
    
    public void addAtHead(int val) {
        Node node=new Node(val);
        node.next=head;
        head=node;
        
    }
    
    public void addAtTail(int val) {
        if(head == null){
            head = new Node(val);
            return;
        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next= new Node(val);
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index==0){
            Node node=new Node(val);
            node.next=head;
            head=node;
            return;
        }
        int i=0;
        Node curr=head;
        Node prev=curr;
        while(curr.next!=null&&i!=index){
            prev=curr;
            i++;
            curr=curr.next;
        }
        if(i==index){
            Node node=new Node(val);
            prev.next=node;
            node.next=curr;
            return;
        }
        if((i+1==index)){
            curr.next= new Node(val);
        }
        
    }
    
    public void deleteAtIndex(int index) {
        if(head==null){
            return;
        }
        if(index==0){
            head=head.next;
            return;
        }
        int i=0;
        Node curr=head;
        Node prev = curr;
        while(curr.next!=null&&i!=index){
            prev=curr;
            i++;
            curr=curr.next;
        }
        if(i==index){
            prev.next=curr.next;
            return;
        }

        
    }
}
    ListNode l206reverseList(ListNode head) {

        // Previous node starts as null
        ListNode previous = null;

        // Current node starts from head
        ListNode current = head;

        while (current != null) {

            // 1. Save the next node
            ListNode next = current.next;

            // 2. Reverse the link
            current.next = previous;

            // 3. Move previous forward
            previous = current;

            // 4. Move current forward
            current = next;
        }
        // Previous becomes the new head
        return previous;
    }
    boolean l141hasCycle(ListNode head) {
        //add each node in hashset
        // traverse and check it in hashset 
        if(head==null||head.next==null){
            return false;
        }
        HashSet<ListNode> hs=new HashSet<>();
        ListNode current=head;
        while(current!=null){
            if(hs.contains(current)){
                return true;
            }
            hs.add(current);
            current=current.next;
        }
        return false;
    }
    boolean l141OPT_FloydeSlowFast_hasCycle(ListNode head) {
        //using floyds slow fast algorithm
        // slow and fast intersects at pos
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null&&fast.next!=null){
            
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    ListNode l142detectCycle(ListNode head) {
        //first we will check the cycle using slow fast
        //after getting cycle 
        //take one of the pointer on head and move both the pointers 1 at atime
        //the meeting point is pos
        if(head==null){
            return null;
        }
        if(head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                
                fast=head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
    ListNode l876middleNode(ListNode head) {
        //whenever our fast reaches the end our slow is on middle
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    ListNode l19removeNthFromEnd(ListNode head, int n) {
        //as we have given node to be deleted from last 
        //we can use 2 pointers which maintains the same distance between 
        //hence whenever one pointer is at end other pointer is at n distance from it
        //so we can easily delete that node 
        //we will maintain distance between the pointers

        if(head.next==null){
            return null;
        }
        //fast will move fast and go to the end 
        //while slow will maintain distance 
        ListNode fast=head;
        ListNode slow=head;
        int d=0;
        while(fast.next!=null){
            fast=fast.next;
            d++;
            while(d>n){
                slow=slow.next;
                d--;
            }
        }
        //even after reaching the end our n is greater than the distance it means 
        //they are telling us to delete first node 
        if(d<n){
            head=head.next;
            return head;
        }
        slow.next=slow.next.next;
        return head;   
    }
    ListNode gdeleteWithoutHead(ListNode x){
        x.val=x.next.val;
        x.next=x.next.next;
        return x;

    }
    void l237_g_deleteNode(ListNode node) {
        //store the value of next node in given node and than delete next node
        node.val=node.next.val;
        node.next=node.next.next;
    }
    ListNode l203removeElements(ListNode head, int val) {
        //we will start from head and traverse the whole ll while checking the next node val 
        //we will always check the next node val 
        //firstly we will check head seprately
        if(head==null){
            return null;
        }
        //remove matching nodes from begining
        
        while(head!=null&&head.val==val){
            head=head.next;
        }
        //(this case is when we delete all nodes from front) 
        if(head==null){
            return null;
        }
        ListNode curr=head;
        //here we check the next node 
        //most imp part-----
        //we will only move forward if our next.val!=val
        //as there can be continous nodes with same values
        while(curr.next!=null){
            //check if next node has val
            if(curr.next.val==val){
                //delete next node 
                curr.next=curr.next.next;
            }
            //only move forward if next node val is different
            else{
                curr=curr.next;
            }
        }
        return head;
        
    }
    ListNode l1836_g_removeDuplicateUnsorted(ListNode head){
        //dupicate means we will need to check whether we have seeen it before
        //hence hashset
        //add every node value in hashset while adding check if its present remove that node
        //for removing the node we should be one node behind the deletable node
        //hence we wiil always check the next node
        if(head==null){
            return null;
        }
        HashSet<Integer> hs= new HashSet<>();
        ListNode curr=head;
        hs.add(head.val);
        while(curr.next!=null){
            //if hashset contains the number delete the node
            if(hs.contains(curr.next.val)){
                curr.next=curr.next.next;
            }
            //most imp point
            //move forward only if next node values is not contained in our hashset
            //as there could be continous set of same value 
            //hence we cannot move forward at every iteration
            else{
                hs.add(curr.next.val);
                curr=curr.next;
            }

        }
        return head;

    }
    ListNode l83deleteDuplicates(ListNode head) {
        //as we have already given the sorted ll
        //all the duplicates value will be continous(if present)
        //hence we will just compare the value of next node with current node if it equals delete the node
        //as we have to delete the node we must present one node behind the deletable node
        //hence we will always check the next node val
        if(head==null){
            return null;
        }
        ListNode curr=head;
        while(curr.next!=null){
            if(curr.next.val==curr.val){
                curr.next=curr.next.next;
            }
            //most imp point
            //move forward only if next node values is not equal to curr
            //as there could be continous set of same value 
            //hence we cannot move forward at every iteration
            else{
                curr=curr.next;
            }

        }
        return head;

    }
    long gMultiply2numbers(ListNode a, ListNode b){
        if(a==null||b==null){
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
        ListNode curr=a;
        long mod=1000000007;
        long firstno_mod=0;
        while(curr!=null){
            firstno_mod=(firstno_mod*10+curr.val)%mod;
            curr=curr.next;
        }
        
        curr=b;
        long secondno_mod=0;
        while(curr!=null){
            secondno_mod=(secondno_mod*10+curr.val)%mod;
            curr=curr.next;
        }
        return (long)(firstno_mod*secondno_mod)%mod;
    }
    ListNode l02addTwoNumbers(ListNode l1, ListNode l2) {
        //here in this question we will perform node node by addition 
        //it is possible as the digits are given in reverse order 
        //while performing addition at each node we add result in new linked list
        //also we have to handle the carry(heance we add result%10 in answer linked list and result/10 in carry)
        //to make new node at each iteration for answer linked list 
        //we will add the value in first node Manually so we can made new node for each iteration while adding value in it
        //*********we cant create node from that position only************ 
        //as we have syntax current_node.next=new ListNode(val);
        //we have to create new node from the previous node only 
        //thats why we have to intialise the first node.
        //we have to also handle the condition of different length linked lists
        //At that situattion we will add only carry +that node value in answer linked list
        //there is one more condition:
        //even after all addition if we have carry 
        //than we have add it in new node
        
        //operate first node manually
        ListNode head=new ListNode((l1.val+l2.val)%10);
        ListNode ans=head;
        int carry=(l1.val+l2.val)/10;
        //current starts from l.next as we already processed l1
        ListNode curr1=l1.next;
        ListNode curr2=l2.next;
        while(curr1!=null&&curr2!=null){
            int result = curr1.val + curr2.val + carry;
            //only due to this syntax we have to operate first node manually
            //we cant create node from that position only 
            //we can create it from one stage backward
            ans.next=new ListNode(result % 10);
            carry = result / 10;
            ans=ans.next;
            curr2=curr2.next;
            curr1=curr1.next;
        }
        if(curr1==null&&curr2!=null){
            while(curr2!=null){
                int result=curr2.val+carry;
                ans.next=new ListNode(result%10);
                carry=result/10;
                curr2=curr2.next;
                ans=ans.next;
            }
        }
        if(curr2==null&&curr1!=null){
            while(curr1!=null){
                int result=curr1.val+carry;
                ans.next=new ListNode(result%10);
                carry=result/10;
                curr1=curr1.next;
                ans=ans.next;
            }
        }
        if(carry>0){//for last carry
            ans.next=new ListNode(carry);
        }
        return head;
        
    }    
    ListNode l02OPTaddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            carry = sum / 10;
        }

        return dummy.next;
    }
}

    
}
