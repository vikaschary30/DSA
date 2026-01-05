// Add two numbers represented as Linked Lists - Problem Statement : Add two numbers represented as Linked Lists.
//                                               1) optimal - TC:O(max(n1,n2)) SC:O(max(n1,n2)) Traverse both lists digit by digit, add corresponding digits with carry, and build the result list using modulo and division.

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
class LL17{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }

    public static Node addlists(Node head1, Node head2){
        Node temp1=head1;
        Node temp2=head2;
        Node dummy=new Node(-1);
        Node curr=dummy;
        int carry=0;
        while(temp1!=null || temp2!=null){
            int sum=carry;
            if(temp1!=null) sum+=temp1.data;
            if(temp2!=null) sum+=temp2.data;
            Node newnode=new Node(sum%10);
            carry=sum/10;
            curr.next=newnode;
            curr=curr.next;
            if(temp1!=null) temp1=temp1.next;
            if(temp2!=null) temp2=temp2.next;
        }
        if(carry==1){
            Node add=new Node(1);
            curr.next=add;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        Node second = new Node(3);
        Node third = new Node(5);
        Node head2 = new Node(4);
        Node fifth = new Node(4);
        head1.next = second;
        second.next = third;
        third.next = null;
        head2.next = fifth;
        fifth.next=null;
        Node res=addlists(head1,head2);
        printDll(res);
    }
}