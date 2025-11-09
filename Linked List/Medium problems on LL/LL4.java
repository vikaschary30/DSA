// Find middle element in a Linked List - Problem Statement : Given the head of a linked list of integers, determine the middle node of the linked list. However, if the linked list has an even number of nodes, return the second middle node.
//                                        1) brute force - TC:O(N+(N/2)) SC:O(1) first counting all nodes and then traversing again to the (count/2+1)(\text{count}/2 + 1)(count/2+1)-th node.
//                                        2) optimal - TC:O(N) SC:O(1) middle node using two pointers — moving the fast pointer twice as fast as the slow pointer, so when fast reaches the end, slow points to the middle node.

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
class LL4{
    public static Node arrayToll(int[] a){
        Node head=new Node(a[0]);
        Node curr=head;
        for(int i=1;i<a.length;i++){
            Node newNode=new Node(a[i], null);
            curr.next=newNode;
            curr=newNode;
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
    // public static Node middleNode(Node head){
    //     if(head==null){
    //         return null;
    //     }
    //     Node temp=head;
    //     int c=0;
    //     while(temp!=null){
    //         c++;
    //         temp=temp.next;
    //     }
    //     temp=head;
    //     int mid=(c/2)+1;
    //     while(temp!=null){
    //         mid--;
    //         if(mid==0){
    //             break;
    //         }
    //         temp=temp.next;
    //     }
    //     return temp;
    // }

    
    
    //optimal:
    public static Node middleNode(Node head){
        if(head==null){
            return null;
        }
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Node head=arrayToll(a);
        printDll(head);
        System.out.println();
        Node midNode=middleNode(head);
        System.out.println(midNode.data);
    }
}