// Delete node in a DLL - optimal : TC:O(N) SC:O(1) This program creates a doubly linked list from an array and efficiently deletes a node at a given position (head, tail, or middle) while maintaining correct next and prev links.

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
class DLL3{
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
    public static Node deleteAtHead(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node temp=head;
        head=head.next;
        head.prev=null;
        temp.next=null;
        return head;
    }
    public static Node deleteAtTail(Node head){
        if(head==null) return null;
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        Node back=curr.prev;
        curr.prev=null;
        curr.next=null;
        back.next=null;
        return head;
    } 
    public static Node deleteAtPos(Node head, int pos){
        if(pos==1){
            return deleteAtHead(head);
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
        Node back=temp.prev;
        Node after=temp.next;
        back.next=after;
        after.prev=back;
        return head;
    }
    public static void main(String[] args) {
        int a[]={12,5,8,7};
        Node head=arrayToDll(a);
        head=deleteAtPos(head, 3);
        printDll(head);
    }
}