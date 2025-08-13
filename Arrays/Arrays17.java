// Sort 0's,1's,2's -- 1) brute force - sort the array (that is not expected).
//                     2) better -  count the 0,1,2 and then make an array with first 0's, then 1's, then 2's.
//                     3) Dutch Natinal Flag Algorithm - rearranges an array of 0s, 1s, and 2s in a single pass using three pointers (low, mid, high) to partition the elements into their correct groups in-place.

import java.util.*;
class Arrays17{
    public static void swap(int a[],int l,int h){
        int temp=a[l];
        a[l]=a[h];
        a[h]=temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        } 
        // int c1=0,c2=0,c3=0;
        // for(int i=0;i<n;i++){
        //     if(a[i]==0){
        //         c1++;
        //     }
        //     else if(a[i]==1){
        //         c2++;
        //     }
        //     else{
        //         c3++;
        //     }
        // }
        // int i=0;
        // while(c1-->0){
        //     a[i++]=0;
        // }
        // while(c2-->0){
        //     a[i++]=1;
        // }
        // while(c3-->0){
        //     a[i++]=2;
        // }

        int low=0, mid=0, high=n-1;
        while(mid<=high){
            if(a[mid]==0){
                swap(a,low,mid);
                low++;
                mid++;
            }
            else if(a[mid]==1){
                mid++;
            }
            else{
                swap(a,mid,high);
                high--;
            }
        }
        for(int j=0;j<n;j++){
            System.out.print(a[j]+" ");
        }
    }
}