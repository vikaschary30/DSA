// Search an element in the LL - optimal :

class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data=data;   
    }
}
class LL3{
    public static boolean searchNode(Node head, int val){
        if(head==null){
            return false;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==val){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        int a[]={20,30,10,4,5};
        Node head=new Node(a[0]);
        head.next=new Node(a[1]);
        head.next.next=new Node(a[2]);
        head.next.next.next=new Node(a[3]);
        head.next.next.next.next=new Node(a[4]);
        int val=4;
        boolean search=searchNode(head,val);
        System.out.println(search);
    }
}