
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.awt.*;
import javax.swing.*;

public static class LL{
    public static class node{
        int data;
        node next;
        
        public node(int data){
        this.data=data;
        this.next=null;
        }
        
    }
    public static node head;
    public static node tail;
    public static int size;
    
    public void addfirst(int data){
        node newnode = new node(data);
        size++;
        if(head == null){
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head=newnode;
        
    }
    
    public void addlast(int data){
        node newnode = new node(data);
        size++;
        if(head == null){
            head = tail = newnode;
            return;
        }
        tail.next= newnode;
        tail=newnode;
    }
    
    public void printll(){
        if(head ==null){
            System.out.println("ll is empty");
        }
        node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
        
        
    }
    public void add(int idx, int data){
        if(idx==0){
            addfirst(data);
        }
        node newnode = new node(data);
        size++;
        node temp= head;
        int i = 0;
        while(i < idx-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        
        
    }
    public int removefirst(){
        if(size==0){
            System.out.println("ll is empty");
            return -1;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
            
        }
        int val= head.data;
        head=head.next;
        size--;
        return val;
    }
    
    public int removelast(){
        if(size==0){
            System.out.println("ll is empty");
            return -1;
            
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size = 0;
            return val;
        }
        node prev=head;
        for(int i=0; i<size-2; i++){
            prev=prev.next;
        }
        int val=tail.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
        
        
    }
    public int iter_search(int key){
        int i=0;
        node temp = head;
        while(temp!=null){
            if(key==temp.data){
                return i;
            }
            temp=temp.next;
            i++;
        }return -1;
        
    }
}
public class LinkedList_Implementation{
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        LL ll = new LL();
        ll.addfirst(2);
        ll.addfirst(1);
        ll.addlast(3);
        ll.addlast(4);
        ll.add(2,9);
        ll.printll();
        System.out.println(ll.iter_search(3));
    }
}
