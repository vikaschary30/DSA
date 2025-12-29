//Starting point of loop in a Linked List -  Problem Statement : Given the head of a linked list that may contain a cycle, return the starting point of that cycle. If there is no cycle in the linked list return null.
//                                           1) brute force - TC:O(N) SC:O(N) Traverse the linked list while storing visited nodes in a HashSet/HashMap, and the first node encountered again is the starting point of the loop.
//                                           2) optimal - TC:O(N) SC:O(1) Use slow and fast pointers to detect a cycle, then reset one pointer to head and move both one step at a time to find the loop’s starting node.

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
class LL7{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }

    //brute force:
    // public static Node startingNodeofLoop(Node head){
    //     HashMap<Node, Integer> hm=new HashMap<>();
    //     Node curr=head;
    //     while(curr!=null){
    //         if(hm.containsKey(curr)){
    //             return curr;
    //         }
    //         hm.put(curr, hm.getOrDefault(curr,0)+1);
    //         curr=curr.next;
    //     }
    //     return null;
    // }

    //optimal:
    public static Node startingNodeofLoop(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
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
        eighth.next=fourth;
        Node res=startingNodeofLoop(head);
        System.out.println("Starting Node of loop is : "+res.data);
    }
}