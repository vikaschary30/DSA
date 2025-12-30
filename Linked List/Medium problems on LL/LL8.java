// Length of Loop in Linked List - Problem Statement : Given the head of a linked list, determine the length of a loop present in the linked list. If there's no loop present, return 0.
//                                 1) brute force - TC:O(N) SC:O(N) Traverse the list while storing each node’s first occurrence index in a HashMap; when a node repeats, the difference between current index and stored index gives the loop length.
//                                 2) optimal - TC:O(N) SC:O(1) Use slow and fast pointers to detect a loop, then move one pointer around the cycle until it meets again, counting steps to determine the loop length.
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
class LL8{
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
     
    //brute force:
    // public static int lengthofLoop(Node head){
    //     HashMap<Node, Integer> hm=new HashMap<>();
    //     Node curr=head;
    //     int c=0;
    //     while(curr!=null){
    //         if(hm.containsKey(curr)){
    //             return c-hm.get(curr);
    //         }
    //         hm.put(curr,hm.getOrDefault(curr, 0)+1);
    //         c++;
    //         curr=curr.next;
    //     }
    //     return 0;
    // }

    //optimal:
    public static int lengthofLoop(Node head){
        Node slow=head;
        Node fast=head;
        int c=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                c=1;
                fast=fast.next;
                while(slow!=fast){
                    fast=fast.next;
                    c++;
                }
                return c;
            }
        }
        return 0;
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
        int res=lengthofLoop(head);
        System.out.println(res);
    }
}