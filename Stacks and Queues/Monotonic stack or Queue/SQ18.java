// Next Smaller Element  - Problem Statement : Given an array of integers arr, your task is to find the Next Smaller Element (NSE) for every element in the array.The Next Smaller Element for an element x is defined as the first element to the right of x that is smaller than x.If there is no smaller element to the right, then the NSE is -1
//                          1) brute force -  TC:O(N^2) SC:O(N) For each element, scan all elements to its right to find the first smaller element.
//                          2) optimal - TC:O(2N) SC:O(N) Traverse from right using a stack to efficiently track and find the next smaller element for each element.

import java.util.*;
class SQ18{
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
                
        //         if(a[j]<a[i]){
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
            while(!st.isEmpty() && st.peek()>=a[i]){
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