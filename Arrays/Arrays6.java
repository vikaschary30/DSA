//Left rotate array by k places -- reverse first d elements, then reverse n-d elements, then the reverse the whole array to get the 
                                    //rotated array

import java.util.*;
class Arrays6{
    public static void reverse(int[] a, int st, int end){
        while(st<=end){
            int temp=a[st];
            a[st]=a[end];
            a[end]=temp;
            st++;
            end--;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        } 
        int d=sc.nextInt();
        // int temp[]=new int[n];
        // for(int i=0;i<d;i++){
        //     temp[i]=a[i];                 
        // }
        // for(int i=d;i<n;i++){
        //     a[i-d]=a[i];
        // }
        // for(int i=n-d;i<n;i++){
        //     a[i]=temp[i-(n-d)];
        // }
        d=d%n;
        reverse(a,0,d-1);
        reverse(a,d,n-1);
        reverse(a,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}