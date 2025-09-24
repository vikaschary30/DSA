// Implement Min Stack - Problem Statement :  Implement Min Stack | O(2N) and O(N) Space Complexity. Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//                       1) brute force - TC:O(1) SC:O(2N) Your code works by storing each element along with the minimum so far in a pair inside the stack, so getmin() is always available in O(1) time.
//                       2)



//brute force:
class Pair{
    int x,y;
    public Pair(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
class MinStack{
    java.util.Stack<Pair> st;
    MinStack() {
        st = new java.util.Stack<>();
    }
    void push(int x){
        if(st.isEmpty()){
            st.push(new Pair(x,x));
        }
        else{
            int min=Math.min(st.peek().y,x);
            st.push(new Pair(x, min));
        }
    }
    int pop(){
        if(st.isEmpty()){
            System.out.println("Empty");
            return -1;
        }
        return st.pop().x;
    }
    int peek(){
        if(st.isEmpty()){
            System.out.println("Empty");
            return -1;
        }
        return st.peek().x;
    }
    int getmin(){
        if(st.isEmpty()){
            System.out.println("Empty");
            return -1;
        }
        return st.peek().y;
    }
}
class SQ8{
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(3);
        s.push(2);
        s.push(4);
        System.out.println(s.getmin());
        s.push(1);
        System.out.println("Top of the stack: " + s.peek());
        System.out.println(s.getmin());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println(s.getmin());
        System.out.println("Top of the stack after removing element: " + s.peek());
    }
}