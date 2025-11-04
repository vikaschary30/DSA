// Insertion and Deletion a node in LinkedList - 1) insertion - optimal : TC:O(N) SC:O(1) Inserts a new node at the specified position in a singly linked list by traversing up to that position and adjusting pointers.
//                                               2) deletion - optimal : TC:O(N) SC:O(1) Traverses the linked list to the given position and removes that node by linking its previous node directly to its next node.

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
    public static Node deleteAtpos(Node head, int pos){
        if (head == null) {
            return null;
        }
        if(pos==1){
            return head.next;
        }
        int c=0;
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            c++;
            if(c==pos){
                prev.next=temp.next;
                break;
            }
            prev=temp;
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
        System.out.println("Original List:");
        printList(head);
        head = insertAtpos(head, k, val);
        System.out.println("After Insertion at position " + k + ":");
        printList(head);
        head = deleteAtpos(head, k);
        System.out.println("After Deletion at position " + k + ":");
        printList(head);
    }
}