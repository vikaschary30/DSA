// Detect a Cycle in a Linked List - Problem Statement: Given a Linked List, determine whether the linked list contains a cycle or not.
//                                   1) brute force - TC:O(N) SC:O(N) Keep a record of visited nodes using a HashSet; if a node repeats, a cycle exists.
//                                   2) optimal(Floyd’s Cycle Detection) - TC:O(N) SC:O(1) Move one pointer one step and another two steps — if they ever meet, the linked list has a cycle.
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
class LL5{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    
    // brute force:
    // public static boolean detectLoop(Node head) {
    //     Node temp = head;
    //     HashMap<Node, Integer> nodeMap = new HashMap<>();
    //     while (temp!=null) {
    //         if (nodeMap.containsKey(temp)) {
    //             return true;
    //         }
    //         nodeMap.put(temp, 1);
    //         temp = temp.next;
    //     }
    //     return false;
    // }

    //optimal:
    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;   
            if (slow == fast) return true;
        }
        return false;
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
        boolean loop=detectLoop(head);
        System.out.println(loop);
    }
}