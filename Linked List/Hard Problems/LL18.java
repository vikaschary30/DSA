// Reverse Linked List in groups of Size K - Problem Statement :  Given the head of a singly linked list containing integers, reverse the nodes of the list in groups of k and return the head of the modified list. If the number of nodes is not a multiple of k, then the remaining nodes at the end should be kept as is and not reversed. Do not change the values of the nodes, only change the links between nodes.
//                                           1) optimal - TC:O(N) SC:O(1) Reverse the linked list in chunks of size k by isolating each group, reversing it, and reconnecting it while leaving remaining nodes unchanged.

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
class LL18{
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

    public static Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        return prev;
    }

    public static Node reversek(Node head, int k){
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            Node knode=findknode(temp, k);
            if(knode==null){
                if(prev!=null) prev.next=temp;
                break;
            }
            Node nextnode=knode.next;
            knode.next=null;
            reverse(temp);
            if(temp==head) head=knode;
            else prev.next=knode;
            prev=temp;
            temp=nextnode;
        }
        return head;
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
        head=reversek(head,2);
        printDll(head);
    }
}