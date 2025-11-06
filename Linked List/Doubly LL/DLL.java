// Array to DLL - optimal : TC:O(N) SC:O(1) converts an integer array into a doubly linked list and then prints its elements in order.

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data, Node next, Node prev) {
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class DLL{
    public static Node arrayToDll(int[] a){
        Node head=new Node(a[0]);
        Node back=head;
        for(int i=1;i<a.length;i++){
            Node newNode=new Node(a[i], null, back);
            back.next=newNode;
            back=newNode;
        }
        return head;
    }
    public static void printDll(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    public static void main(String[] args) {
        int a[]={12,5,8,7};
        Node head=arrayToDll(a);
        printDll(head);
    }
}