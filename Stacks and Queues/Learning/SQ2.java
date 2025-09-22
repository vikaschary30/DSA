
// Implement Queue using Array - O(1) time for all operations


import java.util.Scanner;

class Queue{
    static int a[];
    static int front, rear, currSize, maxSize;
    public Queue() {
        this(20);
    }
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        a = new int[maxSize];
        front = 0;
        rear = -1;
        currSize = 0;
    }
    public static void push(int x){
        if(currSize==maxSize){
            System.out.println("Stack full");
            return;
        }
        rear=(rear+1)%maxSize;
        a[rear]=x;
        currSize++;
    }
    public static int pop(){
        if(currSize==0){
            System.out.println("Stack empty");
            return -1;
        }
        int ele=a[front];
        front=(front+1)%maxSize;
        currSize--;
        return ele;
    }
    public static int peek(){
        if(currSize==0){
            System.out.println("Stack empty");
            return -1;
        }
        return a[front];
    }
    public static int size(){
        return currSize;
    }
}
class SQ2{
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
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("invalid input");
            }
        }
    }
}