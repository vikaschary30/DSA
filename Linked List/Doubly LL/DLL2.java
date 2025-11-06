// Insert into a DLL - optimal : TC:O(N) SC:O(1) The code builds a doubly linked list from an array and allows insertion of a new node at the head, tail, or any given position, then prints the updated list.

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
class DLL2{
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
    public static Node insertAtHead(int val, Node head){
        Node newNode=new Node(val,head,null);
        head.prev=newNode;   
        return newNode;
    }
    public static Node insertAtTail(int val, Node head){
        if(head.next==null){
            return insertAtHead(val, head);
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newNode=new Node(val,null,temp);
        temp.next=newNode;
        return head;
    } 
    public static Node insertAtPos(int val, Node head, int pos){
        if(pos==1){
            return insertAtHead(val, head);
        }
        Node temp=head;
        int c=0;
        while(temp!=null){
            c++;
            if(c==pos){
                break;
            }
            temp=temp.next;
        }
        Node after=temp.next;
        Node newNode=new Node(val,after,temp);
        temp.next=newNode;
        after.prev=newNode;
        return head;
    }
    public static void main(String[] args) {
        int a[]={12,5,8,7};
        Node head=arrayToDll(a);
        head=insertAtPos(4, head, 2);
        printDll(head);
    }
}