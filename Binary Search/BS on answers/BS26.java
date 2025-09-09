// Median of Two Sorted Arrays of different sizes - Problem statement :  Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two sorted arrays. The median is defined as the middle value of a sorted list of numbers. In case the length of the list is even, the median is the average of the two middle elements.
//                                                  1) brute force - TC:O(n1+n2) SC:O(n1+n2) Merge both sorted arrays into a single sorted list and compute the median from the merged list.
//                                                  2) better - TC:O(n1+n2) SC:O(1) Use two pointers to traverse both arrays simultaneously, tracking only the middle elements needed for the median without storing the full merged array.
//                                                  3) optimal - TC: O(log(min(n1, n2))) SC: O(1) Apply binary search on the smaller array to partition both arrays such that the left side contains half of the total elements, ensuring max(left) ≤ min(right).

import java.util.*;
class BS26{
    public static double medianofarrays(int[] a,int[] b){
        int n1=a.length, n2=b.length;
        int n=n1+n2;
        int left=(n1+n2+1)/2;
        if(n1>n2) return medianofarrays(b,a);
        int low=0, high=n1;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            if(mid1>0){
                l1=a[mid1-1];
            }
            if(mid2>0){
                l2=b[mid2-1];
            }
            if(mid1<n1){
                r1=a[mid1];
            }
            if(mid2<n2){
                r2=b[mid2];
            }
            if(l1<=r2 && l2<=r1)
            {
                if(n%2==0){
                    double median=(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                    return median;
                }
                else{
                    return Math.max(l1, l2);
                }
            }
            else if(l1>r2){
                high=mid1-1;
            }
            else{
                low=mid1+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int a[]=new int[n1];
        for(int i=0;i<n1;i++){
            a[i]=sc.nextInt();
        }
        int n2=sc.nextInt();
        int b[]=new int[n2];
        for(int i=0;i<n2;i++){
            b[i]=sc.nextInt();
        }

        //brute force
        // int n=n1+n2;
        // ArrayList<Integer> l=new ArrayList<>();
        // int left=0;
        // int right=0;
        // while(left<n1 && right<n2){
        //     if(a[left]<=b[right]){
        //         l.add(a[left]);
        //         left++;
        //     }
        //     else{
        //         l.add(b[right]);
        //         right++;
        //     }
        // }
        // while(left<n1){
        //     l.add(a[left]);
        //     left++;
        // }
        // while(right<n2){
        //     l.add(b[right]);
        //     right++;
        // }
        
        // if(n%2==0){
        //     double median= (l.get(n / 2) + l.get((n / 2) - 1)) / 2.0;
        //     System.out.println(median);
        // }
        // else{
        //     System.out.println(l.get(n/2));
        // }


        //better
        // int n=n1+n2;
        // int id2=n/2;
        // int id1=id2-1;
        // int e1=-1, e2=-1;
        // int c=0;
        // ArrayList<Integer> l=new ArrayList<>();
        // int left=0;
        // int right=0;
        // while(left<n1 && right<n2){
        //     if(a[left]<=b[right]){
        //         if(c==id1) e1=a[left];
        //         if(c==id2) e2=a[left];
        //         c++;
        //         left++;
        //     }
        //     else{
        //         if(c==id1) e1=b[right];
        //         if(c==id2) e2=b[right];
        //         c++;
        //         right++;
        //     }
        // }
        // while(left<n1){
        //     if(c==id1) e1=a[left];
        //     if(c==id2) e2=a[left];
        //     c++;
        //     left++;
        // }
        // while(right<n2){
        //     if(c==id1) e1=b[right];
        //     if(c==id2) e2=b[right];
        //     c++;
        //     right++;
        // }
        
        // if(n%2==0){
        //     double median= (e1+e2)/(2.0);
        //     System.out.println(median);
        // }
        // else{
        //     System.out.println(e2);
        // }

        double median=medianofarrays(a,b);
        System.out.println(median);
    }
}