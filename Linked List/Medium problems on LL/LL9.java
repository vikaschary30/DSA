// Check if the given Linked List is Palindrome - Problem Statement :  Given the head of a singly linked list representing a positive integer number. Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. Check whether the linked list values form a palindrome or not. Return true if it forms a palindrome, otherwise, return false.
//                                                1) brute force - TC:O(N) SC:O(N) Push all node values onto a stack, then traverse the list again comparing each node with the stack’s top to check for palindrome symmetry.
//                                                2) optimal - TC:O(N) SC:O(1) Find the middle using slow–fast pointers, reverse the second half of the list, compare both halves node by node, and optionally restore the list.
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
class LL9{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    
    //brute force:
    // public static boolean ispalindrome(Node head){
    //     Stack<Integer> st=new Stack<>();
    //     Node curr=head;
    //     while(curr!=null){
    //         st.push(curr.data);
    //         curr=curr.next;
    //     }
    //     curr=head;
    //     while(curr!=null){
    //         if(curr.data==st.peek()){
    //             st.pop();
    //             curr=curr.next;
    //         }
    //         else{
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    //optimal:
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
    public static boolean ispalindrome(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node newhead=reverse(slow.next);
        Node firstp=head;
        Node secondp=newhead;
        while(secondp!=null){
            if(firstp.data!=secondp.data){
                reverse(newhead);
                return false;
            }
            firstp=firstp.next;
            secondp=secondp.next;
        }
        return true;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(4);
        Node sixth = new Node(3);
        Node seventh = new Node(2);
        Node eighth = new Node(1);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next=sixth;
        sixth.next=seventh;
        seventh.next=eighth;
        eighth.next=null;
        System.out.println(ispalindrome(head));
    }
}