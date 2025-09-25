// Next Greater Element 2 - Problem Statement : The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.You are given two distinct 0-indexed integer arrays a and b, where a is a subset of b.For each 0 <= i < a.length, find the index j such that a[i] == b[j] and determine the next greater element of b[j] in b. If there is no next greater element, then the answer for this query is -1.Return an array ans of length a.length such that ans[i] is the next greater element as described above.
//                          1) brute force - TC:O(N1*N2) SC:O(1) For each element in a, find its position in b and linearly scan right to get the next greater element.
//                          2) optimal - TC:O(N1+N2) SC:O(N2) Precompute next greater elements for all of b using a monotonic stack and store them in a map, then directly lookup answers for a.


import java.util.*;
class SQ16{
    public static void main(String[] args) {   
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int[] a=new int[n1];
        for(int i=0;i<n1;i++){
            a[i]=sc.nextInt();
        }
        int n2=sc.nextInt();
        int[] b=new int[n2];
        for(int i=0;i<n2;i++){
            b[i]=sc.nextInt();
        }

        int[] res=new int[n1];
        // brute force :
        // for(int i=0;i<n1;i++){
        //     int val = a[i];
        //     int nextGreater = -1;
        //     for(int j=0;j<n2;j++){
        //         if(val==b[j]){
        //             for(int k=j+1;k<n2;k++){
        //                 if(b[k]>val){
        //                     nextGreater=b[k];
        //                     break;
        //                 }
        //             }
        //             break;
        //         }
        //     }
        //     res[i]=nextGreater;
        // }


        // optimal:
        HashMap<Integer,Integer> hm=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int i=n2-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=b[i]){
                st.pop();
            }
            if(st.isEmpty()){
                hm.put(b[i],-1);
            }
            else{
                hm.put(b[i],st.peek());
            }
            st.push(b[i]);
        }
        for(int i=0;i<n1;i++){
            res[i]=hm.get(a[i]);
        }
        for(int i=0;i<n1;i++){
            System.out.print(res[i]+" ");
        }
    }
}