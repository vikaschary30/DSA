// Find the length of the linkedlist - optimal : TC:O(N) SC:O(1) Traverses the linked list from head to tail, counting nodes to determine its total length.


class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data=data;   
    }
}
class LL2{
    public static int lengthoflist(Node head){
        if(head==null){
            return 0;
        }
        Node temp=head;
        int c=0;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        return c;
    }
    public static void main(String[] args) {
        int a[]={20,30,10,4,5};
        Node head=new Node(a[0]);
        head.next=new Node(a[1]);
        head.next.next=new Node(a[2]);
        head.next.next.next=new Node(a[3]);
        head.next.next.next.next=new Node(a[4]);
        int length=lengthoflist(head);
        System.out.println(length);
    }
}