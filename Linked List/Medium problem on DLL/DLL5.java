// Remove duplicates from sorted DLL - Problem Statment : Given the head of a doubly linked list with its values sorted in non-decreasing order. Remove all duplicate occurrences of any value in the list so that only distinct values are present in the list.Return the head of the modified linked list.
//                                     1) optimal - TC:O(N) SC:O(1) Traverse the sorted doubly linked list once and skip consecutive nodes having the same value by updating next and prev pointers.

import java.util.*;
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data, Node next, Node prev) {
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class DLL5{
    public static Node arrayToDll(int[] a){
        Node head=new Node(a[0]);
        Node back=head;
        for(int i=1;i<a.length;i++){
            Node newNode=new Node(a[i], null, back);
            back.next=newNode;
            back=newNode;
        }
        return head;
    }
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }

    public static Node sortDLL(Node head){
        if(head==null || head.next==null) return head;
        Node temp=head;
        while(temp!=null && temp.next!=null){
            Node nextnode=temp.next;
            while(nextnode!=null && nextnode.data==temp.data){
                nextnode=nextnode.next;
            }
            temp.next=nextnode;
            if(nextnode!=null) nextnode.prev=temp;
            temp=temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Node head=arrayToDll(a);
        System.out.println("Before removing duplicates:");
        printDll(head);
        System.out.println();
        System.out.println("After removing duplicates:");
        head=sortDLL(head);
        printDll(head);
    }
}
