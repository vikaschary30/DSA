// Segregate even and odd nodes in LinkedList - Problem Statement : Given the head of a singly linked list. Group all the nodes with odd indices followed by all the nodes with even indices and return the reordered list. Consider the 1st node to have index 1 and so on. The relative order of the elements inside the odd and even group must remain the same as the given input.
//                                              1) brute force - TC:O(N) SC:O(N) first collects values of nodes at odd indices followed by even indices into a list, then rewrites the linked list nodes in that order while preserving their relative positions.
//                                              2) optimal - TC:O(N) SC:O(1) rearranges pointers by linking all odd-indexed nodes first, then appends the even-indexed nodes, achieving in-place reordering without extra space. 

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
class LL10{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }

    // brute force:
    // public static Node oddevenLL(Node head){
        // if(head==null || head.next==null){
        //     return head;
        // }
    //     List<Integer> l=new ArrayList<>();
    //     Node temp=head;
    //     while(temp!=null && temp.next!=null){
    //         l.add(temp.data);
    //         temp=temp.next.next;
    //     }
    //     if(temp!=null) l.add(temp.data);
    //     temp=head.next;
    //     while(temp!=null && temp.next!=null){
    //         l.add(temp.data);
    //         temp=temp.next.next;
    //     }
    //     if(temp!=null) l.add(temp.data);
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
    public static Node oddevenLL(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node odd=head;
        Node even=head.next;
        Node evenhead=head.next;
        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenhead;
        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eighth = new Node(8);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next=sixth;
        sixth.next=seventh;
        seventh.next=eighth;
        eighth.next=null;
        head=oddevenLL(head);
        printDll(head);
    }
}