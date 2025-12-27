// Reverse a Linked List - Problem Statement : Given the head of a singly linked list, write a program to reverse the linked list, and return the head pointer to the reversed list.
//                         1) iterative - TC:O(N) SC:O(1) iteratively reverses the linked list by redirecting each node’s next pointer to its previous node while traversing the list, finally returning the new head.
//                         2) recursion - TC:O(N) SC:O(N) recursively reverses the linked list by reversing the remaining list and then fixing the current node’s next link.

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
class LL6{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
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
    public static Node reverserecursive(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newhead=reverserecursive(head.next);
        Node after=head.next;
        after.next=head;
        head.next=null;
        return newhead;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        System.out.println("Before reverse:");
        printDll(head);

        //iterative:
        // head=reverse(head);
        // System.out.println("\nAfter reverse reverse:");
        // printDll(head);

        //recursive:
        head=reverserecursive(head);
        System.out.println("\nAfter reverse reverse:");
        printDll(head);
    }
}