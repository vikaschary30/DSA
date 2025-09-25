// Next Greater Element 1 - Problem Statement : The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
//                          1) brute force -  TC:O(N^2) SC:O(N) For each element, linearly scan its right side to find the next greater element.
//                          2) optimal - TC:O(2N) SC:O(N) Traverse from right using a stack to keep potential greater elements, achieving O(2N).

import java.util.*;
class SQ15{
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
        //     for(int j=i+1;j<n;j++){
                
        //         if(a[j]>a[i]){
        //             res[i]=a[j];
        //             break;
        //         }
        //         else{
        //             res[i]=-1;
        //         }
        //     }
        // }
        // res[n-1]=-1;


        // optimal:
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i]=st.peek();
            }
            st.push(a[i]);
        }
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}