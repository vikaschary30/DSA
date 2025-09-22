
// Implement Stack using LinkedList - O(1) time for all operations


import java.util.Scanner;

class Stack{
    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    static Node top;
    static int size;
    Stack(){
        this.top=null;
        this.size=0;
    }
    public static void push(int x){
        Node temp=new Node(x);
        temp.next=top;
        top=temp;
        size++;
    }
    public static int pop(){
        if(top==null) return -1;
        int ele=top.data;
        Node temp=top;
        top=top.next;
        size--;
        return ele;
    }
    public static int peek(){
        if(top==null) return -1;
        int ele=top.data;
        return ele;
    }
    public static int size(){
        return size;
    }
    public static boolean isEmpty() {
        return top==null;
    }
    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
class SQ3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack st=new Stack();
        while(true){
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    int x=sc.nextInt();
                    st.push(x);
                    break;
                case 2:
                    int ele=st.pop();
                    if(ele!=-1){
                        System.out.println(ele);
                    }
                    break;
                case 3:
                    int peekele=st.peek();
                    if(peekele!=-1){
                        System.out.println(peekele);
                    }
                    break;
                case 4:
                    System.out.println(st.size());
                    break;
                case 5:
                    st.printStack();
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