// Maximum Product Subarray in an Array -- 1) brute force - TC:O(N^2) SC:O(1) checks every subarray by multiplying elements to find the maximum product.


import java.util.*;
class Arrays40{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int pro=1,maxi=1;
        for(int i=0;i<n;i++){
            pro=1;
            for(int j=i;j<n;j++){
                pro*=a[j];
                maxi=Math.max(pro,maxi);
            }
        }
        System.out.println(maxi);
    }
}