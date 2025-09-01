//Binary Search to find an X in sorted array - 1) iterative : TC:O(LogN)
//                                             2) recursion : TC:O(LogN) 

import java.util.*;
// class BS1{
//     public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // int a[]=new int[n];
        // for (int i = 0; i < n; i++){
        //     a[i]=sc.nextInt();
        // }
        // int target=sc.nextInt();
//         int low=0,high=n-1;
//         int f=0;
//         while(low<=high){
//             int mid=(low+high)/2;
            // if(a[mid]==target){
            //     f=1;
            //     System.out.println(mid);
            //     break;
            // }
            // else if(target<a[mid]){
            //     high=mid-1;
            // }
            // else{
            //     low=mid+1;
            // }
//         }
//         if(f==0){
//             System.out.println("-1");
//         }
//     }
// }


class BS1{
    public static int binarysearch(int[] a, int low, int high, int target){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(a[mid]==target){
            return mid;
        }
        else if(target<a[mid]){
            return binarysearch(a, low, mid-1, target);
        }
        return binarysearch(a, mid+1, high, target);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        System.out.println(binarysearch(a,0,n-1,target));
    }
}