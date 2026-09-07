class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;

    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        Node curr = head;
        int i = 0;
        while (i != index && curr != null) {
            curr = curr.next;
            i++;
        }
        if (curr == null) {
            return -1;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            Node node = new Node(val);
            node.next = head;
            head = node;
            return;
        }
        int i = 0;
        Node curr = head;
        Node prev = curr;
        while (curr != null && i != index) {
            prev = curr;
            i++;
            curr = curr.next;
        }
        if (i == index) {
            Node node = new Node(val);
            prev.next = node;
            node.next = curr;
            return;
        }
        if (i + 1 == index && curr == null) {
            prev.next = new Node(val);
        }
    }
    
    public void deleteAtIndex(int index) {
        if (head == null || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        int i = 0;
        Node curr = head;
        Node prev = curr;
        while (curr != null && i != index) {
            prev = curr;
            i++;
            curr = curr.next;
        }
        if (i == index && curr != null) {
            prev.next = curr.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
