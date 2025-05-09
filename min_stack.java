class MinStack {
    class Pair{
        int ele;
        int min;
        Pair(int ele,int min){
            this.ele=ele;
            this.min=min;
        }
    }
    Stack<Pair> st;
    public MinStack() {
        st= new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }
        else{
            int currmin=st.peek().min;
            int mini=Math.min(currmin,val);
            st.push(new Pair(val,mini));
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek().ele;
        }
        return 0;
    }
    
    public int getMin() {
        if(!st.isEmpty()){
            return st.peek().min;
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */