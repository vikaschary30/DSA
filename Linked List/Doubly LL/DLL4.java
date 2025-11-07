// Reverse a Doubly Linked List - Problem Statement : Given a doubly linked list of size ‘N’ consisting of positive integers, your task is to reverse it and return the head of the modified doubly linked list.
//                                1) brute force - TC:O(2N) SC:O(N) reverses a doubly linked list by pushing all node values onto a stack and then reassigning them back to the list in reverse order.

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
class DLL4{
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

    //brute force:
    public static void reverse(Node head){
        Stack<Integer> st=new Stack<>();
        Node temp=head;
        while(temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }
        Node curr=head;
        while(curr!=null){
            curr.data=st.pop();
            curr=curr.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Node head=arrayToDll(a);
        printDll(head);
        System.out.println();
        reverse(head);
        printDll(head);
    }
}