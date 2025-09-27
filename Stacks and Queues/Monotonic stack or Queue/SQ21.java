// Asteroid Collision - Problem Statement : We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
//                                          For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//                                          Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//                      1) optimal - TC:O(N) SC:O(N) Use a stack to simulate collisions by removing smaller right-moving asteroids when hit by left-moving ones, keeping only the survivors.


import java.util.*;
class SQ21{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        //optimal:
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(a[i]>0){
                st.push(a[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && Math.abs(a[i])>st.peek()){
                    st.pop();
                }
                if(!st.empty() && st.peek()==Math.abs(a[i])){
                    st.pop();
                }
                else if(st.empty() || st.peek()<0){
                    st.push(a[i]);
                }
            }
        }
        for(int x: st){
            System.out.print(x+" ");
        }
    }
}