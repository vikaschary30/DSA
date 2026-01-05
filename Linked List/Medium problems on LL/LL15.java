// Find intersection of Two Linked Lists - Problem Statement : Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
//                                         1) brute force - TC:O(N1+N2) SC:O(N1) Store all nodes of the first list in a HashSet, then traverse the second list and return the first node that already exists in the set.
//                                         2) better - TC:O(N1+N2) SC:O(1) Compute lengths of both lists, advance the longer list by the length difference, then move both pointers together until they meet at the intersection node.
//                                         3) optimala - TC:O(N1+N2) SC:O(1) Traverse both lists using two pointers that switch heads after reaching the end, ensuring they meet at the intersection node or both reach null.

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
class LL15{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    
    //brute force:
    // public static Node intersectionNode(Node head1, Node head2){
    //     if(head1==null || head2==null) return null;
    //     Node temp=head1;
    //     HashSet<Node> hs=new HashSet<>();
    //     while(temp!=null){
    //         hs.add(temp);
    //         temp=temp.next;
    //     }
    //     temp=head2;
    //     while(temp!=null){
    //         if(hs.contains(temp)){
    //             return temp;
    //         }
    //         temp=temp.next;
    //     }
    //     return null;
    // }

    //better:
    // public static Node collidepoint(Node head1, Node head2, int d){
    //     Node temp1=head1;
    //     while(d > 0 && temp1 != null){
    //         temp1 = temp1.next;
    //         d--;
    //     }
    //     Node temp2=head2;
    //     while(temp1!=null && temp2!=null){
    //         if(temp1==temp2) return temp1;
    //         temp1=temp1.next;
    //         temp2=temp2.next;
    //     }
    //     return null;
    // }
    // public static Node intersectionNode(Node head1, Node head2){
    //     if(head1==null || head2==null) return null;
    //     Node temp=head1;
    //     int n1=0;
    //     while(temp!=null){
    //         n1++;
    //         temp=temp.next;
    //     }
    //     int n2=0;
    //     temp=head2;
    //     while(temp!=null){
    //         n2++;
    //         temp=temp.next;
    //     }
    //     if(n1>n2) return collidepoint(head1,head2,n1-n2);
    //     return collidepoint(head2,head1,n2-n1);
    // }

    
    //optimal:
    public static Node intersectionNode(Node head1, Node head2){
        if(head1==null || head2==null) return null;
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=temp2){
            temp1=(temp1==null)?head2:temp1.next;
            temp2=(temp2==null)?head1:temp2.next;
        }
        return temp1;
    }


    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node second = new Node(4);
        Node third = new Node(3);
        Node fourth = new Node(2);
        Node head2 = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(10);
        Node eighth = new Node(8);
        head1.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;
        head2.next=sixth;
        sixth.next=seventh;
        seventh.next=eighth;
        eighth.next=third;
        Node intersection = intersectionNode(head1, head2);
        if(intersection != null)
            System.out.println(intersection.data);
        else
            System.out.println("No intersection");
    }
}