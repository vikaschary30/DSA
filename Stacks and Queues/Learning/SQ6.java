// Implement Queue using Stack

//approach 1:
// class Queue{
//     java.util.Stack<Integer> st1=new java.util.Stack<>();
//     java.util.Stack<Integer> st2=new java.util.Stack<>();
//     void push(int x){
//         while(!st1.isEmpty()){
//             st2.push(st1.pop());
//         }
//         st1.push(x);
//         while(!st2.isEmpty()){
//             st1.push(st2.pop());
//         }
//     }
//     int pop(){
//         if(st1.isEmpty()){
//             System.out.println("empty");
//             return -1;
//         }
//         int val=st1.peek();
//         st1.pop();
//         return val;
//     }
//     int peek(){
//         if(st1.isEmpty()){
//             System.out.println("empty");
//             return -1;
//         }
//         return st1.peek();
//     }
//     int size(){
//         return st1.size();
//     }
// }


//approach 2:
class MyQueue{
    java.util.Stack<Integer> st1=new java.util.Stack<>();
    java.util.Stack<Integer> st2=new java.util.Stack<>();
    void push(int x){
        st1.push(x);
    }
    int pop(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.peek());
                st1.pop();
            }
        }
        int val=st2.peek();
        st2.pop();
        return val;
    }
    int peek(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.peek());
                st1.pop();
            }
        }
        return st2.peek();
    }
    int size(){
        return st1.size()+st2.size();
    }
}
class SQ6{
    public static void main(String args[]) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());

    }
}