
// Implement Stack using Array


import java.util.Scanner;

class Stack{
    static int top=-1;
    static int[] a=new int[20];
    public static void push(int x){
        if(top==a.length-1){
            System.out.println("Stack full");
            return;
        }
        top++;
        a[top]=x;
    }
    public static int pop(){
        if(isEmpty()){
            System.out.println("Stack empty");
            return -1;
        }
        int ele=a[top];
        top--;
        return ele;
    }
    public static int peek(){
        if(isEmpty()){
            System.out.println("Stack empty");
            return -1;
        }
        return a[top];
    }
    public static int size(){
        return top+1;
    }
    public static boolean isEmpty() {
        return top == -1;
    }
}
class SQ1{
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
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("invalid input");
            }
        }
    }
}