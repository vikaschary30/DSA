// Implement Stack using single Queue
class MyStack{
    java.util.Queue<Integer> q = new java.util.LinkedList<>();   
    void push(int x){
        q.add(x);
        for(int i=0;i<q.size()-1;i++){
            q.add(q.remove());    
        }
    }
    int pop(){
        if(q.size()==0){
            System.out.println("Empty");
            return -1;
        }
        return q.remove();
    }
    int peek(){
        if(q.size()==0){
            System.out.println("Empty");
            return -1;
        }
        return q.peek();
    }
    int size(){
        return q.size();
    }
}
class SQ5{
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.peek());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.peek());
        System.out.println("Size of the stack after removing element: " + s.size());
    }
}