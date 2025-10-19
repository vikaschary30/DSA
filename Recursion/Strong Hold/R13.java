// Reverse a stack using recursion - Problem Statement : You are given a stack of integers. Your task is to reverse the stack using recursion. You may only use standard stack operations (push, pop, top/peek, isEmpty). You are not allowed to use any loop constructs or additional data structures like arrays or queues.Your solution must modify the input stack in-place to reverse the order of its elements.
//                                   1) optimal - TC:O(N^2) SC:O(N) Recursively pop all elements, then during backtracking insert each popped element at the bottom using recursion to reverse the stack in-place.

import java.util.*;
class R13{
    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()) return;
        int x=st.pop();
        reverseStack(st);
        insertatbottom(st,x);
    }
    public static void insertatbottom(Stack<Integer> st, int x){
        if(st.isEmpty()){
            st.push(x);
            return;
        }
        int y=st.pop();
        insertatbottom(st, x);
        st.push(y);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(9);
        stack.push(11);

        
        reverseStack(stack);

        System.out.println("After reverse:");
        while (!stack.isEmpty()) { 
            System.out.print(stack.pop()+" ");
        }
    }
}