// Sort a Linked List of 0's 1's and 2's by changing links - Problem Statement : Given a linked list containing only 0's, 1's, and 2's, sort the linked list by rearranging the links (not by changing the data values).
//                                                           1) optimal - TC:O(N) SC:O(1) Traverse the list once to split nodes into three separate linked lists for 0s, 1s, and 2s using dummy heads, then connect these lists in order (0 → 1 → 2) by rearranging links without changing node data.

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
class LL14{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    
    public static Node sort012(Node head){
        if(head==null || head.next==null) return head;
        Node zerohead=new Node(-1);
        Node onehead=new Node(-1);
        Node twohead=new Node(-1);
        Node zero=zerohead;
        Node one=onehead;
        Node two=twohead;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
                temp=temp.next;
            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;
                temp=temp.next;
            }
            else{
                two.next=temp;
                two=two.next;
                temp=temp.next;
            }
        }
        zero.next=(onehead.next!=null)?onehead.next:twohead.next;
        one.next=twohead.next;
        two.next=null;
        return zerohead.next;
    }
    

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(0);
        Node third = new Node(2);
        Node fourth = new Node(2);
        Node fifth = new Node(0);
        Node sixth = new Node(1);
        Node seventh = new Node(1);
        Node eighth = new Node(0);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next=sixth;
        sixth.next=seventh;
        seventh.next=eighth;
        eighth.next=null;
        System.out.println("Before sort:");
        printDll(head);
        head=sort012(head);
        System.out.println("\nAfter sort:");
        printDll(head);
    }
}