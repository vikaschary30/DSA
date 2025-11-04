// Inserting a node in LinkedList - optimal : TC:O(N) SC:O(1) Inserts a new node at the specified position in a singly linked list by traversing up to that position and adjusting pointers.

import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data=data;   
    }
}
class LL1{
    public static Node insertAtpos(Node head, int pos, int data){
        if (head == null) {
            if (pos == 1) return new Node(data);
            else return null;
        }
        if(pos==1){
            Node newnNode=new Node(data);
            newnNode.next=head;
            return newnNode;
        }
        int c=0;
        Node temp=head;
        Node newnode=new Node(data);
        while(temp!=null){
            c++;
            if(c==pos-1){
                newnode.next=temp.next;
                temp.next=newnode;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
    public static void printList(Node head){
        if(head==null){
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int val=sc.nextInt();
        Node head=new Node(10);
        head.next=new Node(20);
        head=insertAtpos(head,k,val);
        printList(head);
    }
}