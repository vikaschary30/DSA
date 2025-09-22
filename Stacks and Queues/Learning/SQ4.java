
// Implement Queue using LinkedList


import java.util.Scanner;

class Queue{
    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    static Node front;
    static Node rear;
    static int size;
    Queue(){
        this.front=null;
        this.rear=null;
        this.size=0;
    }
    public static void push(int x){
        Node temp=new Node(x);
        if(front==null){
            front=temp;
            rear=temp;
        }
        else{
            rear.next=temp;
            rear=temp;
        }
        size++;
    }
    public static int pop(){
        if(front==null){
            return -1;
        }
        Node temp=front;
        front=front.next;
        size--;
        return temp.data;
    }
    public static int peek(){
        if(front==null){
            return -1;
        }
        return front.data;
    }
    public static int size(){
        return size;
    }
    public static boolean isEmpty() {
        return front==null;
    }
    public void printQueue() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
class SQ4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Queue q=new Queue();
        while(true){
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    int x=sc.nextInt();
                    q.push(x);
                    break;
                case 2:
                    int ele=q.pop();
                    if(ele!=-1){
                        System.out.println(ele);
                    }
                    break;
                case 3:
                    int peekele=q.peek();
                    if(peekele!=-1){
                        System.out.println(peekele);
                    }
                    break;
                case 4:
                    System.out.println(q.size());
                    break;
                case 5:
                    q.printQueue();
                    break;
                case 6:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("invalid input");
            }
        }
    }
}