// Sort a Linked List - Problem Statement :  Given a linked list, sort its nodes based on the data value in them. Return the head of the sorted linked list.
//                                        1) brute force - TC:O(NlogN) SC:O(N) The algorithm copies all node values into a list, sorts the list, and rewrites the linked list in sorted order.
//                                        2) optimal - TC:O(NlogN) SC:O(logN) recursively divides the linked list into halves, sorts each half, and merges them to produce a sorted linked list.

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
class LL13{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    
    //bruteforce:
    // public static Node sortLL(Node head){
    //     if(head==null || head.next==null){
    //         return head;
    //     }
    //     List<Integer> l=new ArrayList<>();
    //     Node temp=head;
    //     while(temp!=null){
    //         l.add(temp.data);
    //         temp=temp.next;
    //     }
    //     if(temp!=null) l.add(temp.data);
    //     Collections.sort(l);
    //     temp=head;
    //     int i=0;
    //     while(temp!=null){
    //         temp.data=l.get(i);
    //         i++;
    //         temp=temp.next;
    //     }
    //     return head;
    // }

    
    //optimal:
    public static Node findmiddle(Node head){
        if(head==null){
            return null;
        }
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node mergesortll(Node head1, Node head2){
        Node t1=head1;
        Node t2=head2;
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(t1!=null && t2!=null){
            if(t1.data<t2.data){
                temp.next=t1;
                temp=temp.next;
                t1=t1.next;
            }
            else{
                temp.next=t2;
                temp=temp.next;
                t2=t2.next;
            }
        }
        if(t1!=null) temp.next=t1;
        else temp.next=t2;
        return dummy.next;
    }
    public static Node sortLL(Node head){
        if(head==null || head.next==null) return head;
        Node mid=findmiddle(head);
        Node lefthead=head;
        Node righthead=mid.next;
        mid.next=null;
        lefthead=sortLL(lefthead);
        righthead=sortLL(righthead);
        return mergesortll(lefthead,righthead);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(5);
        Node third = new Node(6);
        Node fourth = new Node(3);
        Node fifth = new Node(2);
        Node sixth = new Node(7);
        Node seventh = new Node(4);
        Node eighth = new Node(8);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next=sixth;
        sixth.next=seventh;
        seventh.next=eighth;
        eighth.next=null;
        System.out.println("before sort:");
        printDll(head);
        head=sortLL(head);
        System.out.println("\nAfter sort:");
        printDll(head);
    }
}