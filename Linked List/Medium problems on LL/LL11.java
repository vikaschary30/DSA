// Remove N-th node from the end of a Linked List - Problem Statement :  Given a linked list and an integer N, the task is to delete the Nth node from the end of the linked list and print the updated linked list.
//                                                  1) brute force - TC:O(2*L) SC:O(1) L:length of list first counts the total number of nodes, calculates the position of the node to delete from the start, and then removes it by adjusting the next pointer.
//                                                  2) optimal - TC:O(L) SC:O(1) L:length of list Uses two pointers separated by N nodes so that when the fast pointer reaches the end of the list, the slow pointer deletes the Nth node from the end.

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
class LL11{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }

    // brute force:
    // public static Node deleteNodeFromEnd(Node head,int n){
    //     if(head==null) return null;
    //     int c=0;
    //     Node temp=head;
    //     while(temp!=null){
    //         c++;
    //         temp=temp.next;
    //     }
    //     if(n==c){
    //         return head.next;
    //     }
    //     int res=c-n;
    //     temp=head;
    //     while(temp!=null){
    //         res--;
    //         if(res==0) break;
    //         temp=temp.next;
    //     }
    //     temp.next=temp.next.next;
    //     return head;
    // }

    
    //optimal:
    public static Node deleteNodeFromEnd(Node head,int n){
        if(head==null) return null;
        Node fast=head;
        Node slow=head;
        for(int i=0;i<n;i++) fast=fast.next;
        if(fast == null){
            return head.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eighth = new Node(8);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next=sixth;
        sixth.next=seventh;
        seventh.next=eighth;
        eighth.next=null;
        int n=sc.nextInt();
        head=deleteNodeFromEnd(head,n);
        printDll(head);
    }
}