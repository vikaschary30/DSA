// Rotate a Linked List - Problem Statement : Given the head of a singly linked list containing integers, shift the elements of the linked list to the right by k places and return the head of the modified list. Do not change the values of the nodes, only change the links between nodes.
//                        1) optimal - TC:O(N) SC:O(1) Find the length of the list, make it circular, break it at the (len − k)th node, and return the next node as the new head.

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data, Node next) {
        this.data=data;
        this.next=next;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class LL19{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    
    public static Node findknode(Node temp,int k) {
        k-=1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }


    public static Node rotatek(Node head, int k){
        if(head == null || head.next == null || k == 0) return head;
        Node tail=head;
        int len=1;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        k=k%len;
        if(k==0) return head;
        Node newtail=findknode(head, len-k);
        Node newhead=newtail.next;
        tail.next=head;
        newtail.next=null;
        return newhead;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        int k=sc.nextInt();
        head=rotatek(head,k);
        printDll(head);
    }
}