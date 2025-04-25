public class Node {
    int val;
    Node next;
    Node(int val){
        this.val =val;
        next=null;
    }
}
class MyLinkedList {
    Node head;
    int length;
    public MyLinkedList() {
        this.head=null;
        this.length=0;
    }
    
    public int get(int index) {
        Node temp = head;
        if(head==null){
            return -1;
        }
        if(index<0 || index>=length){
            return -1;
        }
        for(int i=0;i<length && temp!=null;i++){
            if(i==index){
                return temp.val;
            }
            temp=temp.next;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        Node newnode = new Node(val);
        newnode.next=head;
        head=newnode;
        length+=1;
    }
    
    public void addAtTail(int val) {
        Node temp=head;
        Node newnode = new Node(val);
        if(head==null){
            head=newnode;
            length+=1;
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.next=null;
        length+=1;
    }
    
    public void addAtIndex(int index, int val) {
        Node temp=head;
        Node newnode = new Node(val);
        if(index<0 || index>length){
            return;
        }
        if(index==0){
            addAtHead(val);
            return;
        }
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        length+=1;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=length){
            return;
        }
        if(index==0){
            head=head.next;
        }
        else{
        Node temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        length-=1;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */