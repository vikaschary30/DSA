// Add 1 to a number represented by LL - Problem Statement : Given the head of a singly linked list representing a positive integer number. Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. The task is to add one to the value represented by the linked list and return the head of a linked list containing the final value.
//                                       1) iterative - TC:O(N) SC:O(1) Reverse the linked list, add 1 from the least significant digit while propagating carry, create a new node if carry remains, then reverse the list back.
//                                       2) recursive - TC:O(N) SC:O(N) Recursively reach the last node, add 1 while backtracking to propagate carry toward the head, and insert a new node if carry remains after the head.

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
class LL16{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }

    //iterative:
    // public static Node reverse(Node head){
    //     Node curr=head;
    //     Node prev=null;
    //     while(curr!=null){
    //         Node after=curr.next;
    //         curr.next=prev;
    //         prev=curr;
    //         curr=after;
    //     }
    //     return prev;
    // }
    // public static Node onetolist(Node head){
    //     if(head==null) return head;
    //     int carry=1;
    //     head=reverse(head);
    //     Node temp=head;
    //     while(temp!=null){
    //         temp.data=temp.data+carry;
    //         if(temp.data<10){
    //             carry=0;
    //             break;
    //         }
    //         else{
    //             carry=1;
    //             temp.data=0;
    //         }
    //         temp=temp.next;
    //     }
    //     if(carry==1){
    //         Node newnode=new Node(1);
    //         head=reverse(head);
    //         newnode.next=head;
    //         return newnode;
    //     }
    //     head=reverse(head);
    //     return head;
    // }


    //recursive:
    public static int helper(Node temp){
        if(temp==null) return 1;
        int carry=helper(temp.next);
        temp.data=temp.data+carry;
        if(temp.data<10){
            return 0;
        }
        temp.data=0;
        return 1;
    }
    public static Node onetolist(Node head){
        Node temp=head;
        int carry=helper(head);
        if(carry==1){
            Node newnode=new Node(1);
            newnode.next=head;
            return newnode;
        }
        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(9);
        Node second = new Node(9);
        Node third = new Node(9);
        Node fourth = new Node(9);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;
        System.out.println("Before adding 1 to list:");
        printDll(head);
        System.out.println("\nAfter adding 1 to list:");
        head=onetolist(head);
        printDll(head);
    }
}