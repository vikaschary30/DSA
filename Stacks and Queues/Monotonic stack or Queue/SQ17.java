// Next Greater Element 3 - Problem Statement : Given a circular integer array A, return the next greater element for every element in A. The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner. If it doesn't exist, return -1 for this element.
//                          1) brute force -  TC:O(N^2) SC:O(N) For each element, check the next n-1 elements circularly to find the first greater element.
//                          2) optimal - TC:O(4N) SC:O(2N) Traverse the array twice in reverse using a monotonic stack to efficiently find the next greater element for each element in the circular array.

import java.util.*;
class SQ17{
    public static void main(String[] args) {   
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        int[] res=new int[n];
        //brute force :
        // for(int i=0;i<n;i++){
        //     res[i]=-1;
        //     for(int j=i+1;j<i+n;j++){
        //         int id=j%n;
        //         if(a[id]>a[i]){
        //             res[i]=a[id];
        //             break;
        //         }
        //     }
        // } 


        // optimal:
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=a[i%n]){
                st.pop();
            }
            if(i<n){
                if(st.isEmpty()){
                    res[i]=-1;
                }
                else{
                    res[i]=st.peek();
                }
            }
            st.push(a[i%n]);
        }
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}