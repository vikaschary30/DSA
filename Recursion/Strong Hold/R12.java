// Sort a Stack - Problem Statement : You are given a stack of integers. Your task is to sort the stack in descending order using recursion, such that the top of the stack contains the greatest element. You are not allowed to use any loop-based sorting methods (e.g., quicksort, mergesort). You may only use recursive operations and the standard stack operations (push, pop, peek/top, and isEmpty).
//                1) optimal - TC:O(N^2) SC:O(N) Recursively pop elements until stack is empty, then insert each popped element back into the already-sorted stack in its correct descending position using recursion.

import java.util.*;
class R12{
    public static void sortStack(Stack<Integer> st){
        if(st.isEmpty()) return;
        int x=st.pop();
        sortStack(st);
        insertintost(st,x);
    }
    public static void insertintost(Stack<Integer> st, int x){
        if(st.isEmpty() || x>st.peek()){
            st.push(x);
            return;
        }
        int y=st.pop();
        insertintost(st, x);
        st.push(y);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        
        sortStack(stack);

        System.out.println("After sort:");
        while (!stack.isEmpty()) { 
            System.out.print(stack.pop());
        }
    }
}