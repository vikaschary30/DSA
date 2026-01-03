// Delete the Middle Node of the Linked List - Problem Statement : Given the head of a linked list of integers, delete the middle node of the linked list and return the modified head. However, if the linked list has an even number of nodes, delete the second middle node.
//                                             1) brute force - TC:O(2N) SC:O(1) first counts the total number of nodes, computes the middle position (second middle if even), and deletes that node by updating pointers.
//                                             2) optimal - TC:O(N) SC:O(1) uses slow and fast pointers to locate the middle node (second middle for even length) in a single traversal and deletes it by adjusting pointers.


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
class LL12{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    
    //bruteforce:
    public static Node middleNode(Node head){
        if(head==null) return null;
        int c=0;
        Node temp=head;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        temp=head;
        int mid=(int)Math.floor(c/2);
        while(temp!=null){
            mid--;
            if(mid==0) break;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }



    //optimal:
    // public static Node middleNode(Node head){
    //     if(head==null){
    //         return null;
    //     }
    //     Node slow=head;
    //     Node fast=head;
    //     fast=fast.next.next;
    //     while(fast!=null && fast.next!=null){
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }
    //     slow.next=slow.next.next;
    //     return head;
    // }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        // Node eighth = new Node(8);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next=sixth;
        sixth.next=seventh;
        seventh.next=null;
        //eighth.next=null;
        head=middleNode(head);
        printDll(head);
    }
}