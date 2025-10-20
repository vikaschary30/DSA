// Merge two Sorted Arrays Without Extra Space -- 1) brute force - TC:O(N+M)+O(N+M) SC:O(N+M) Merges two sorted arrays by storing all elements in a temporary list and then copying them back, using extra space.
//                                                2) optimal1 - TC:O(Min(n1,n2))+O(n1logn1)+O(n2logn2) SC:O(1) Swap larger elements from the end of the first array with smaller elements from the start of the second array, then sort both arrays.
//                                                3) optimal2 - TC:O((n1+n2) log(n1+n2)) SC:O(1) Use Shell sort's gap method to repeatedly compare and swap elements across both arrays until fully sorted.
 

import java.util.*;
class Arrays37{
    public static void swap(int[] a,int[] b,int i,int j){
        int temp=a[i];
        a[i]=b[j];
        b[j]=temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int a[]=new int[n1];
        for (int i = 0; i < n1; i++){
            a[i]=sc.nextInt();
        }
        int n2=sc.nextInt();
        int b[]=new int[n2];
        for (int i = 0; i < n2; i++){
            b[i]=sc.nextInt();
        }

        // int i=0;
        // int j=0;
        // List<Integer> temp=new ArrayList<>();
        // while(i<n1 && j<n2){
        //     if(a[i]<b[j]){
        //         temp.add(a[i]);
        //         i++;
        //     }
        //     else{
        //         temp.add(b[j]);
        //         j++;
        //     }
        // }
        // while(i<n1){
        //     temp.add(a[i]);
        //     i++;
        // }
        // while(j<n2){
        //     temp.add(b[j]);
        //     j++;
        // }
        // for(int k=0;k<(n1+n2);k++){
        //     if(k<n1){
        //         a[k]=temp.get(k);
        //     }
        //     else{
        //         b[k-n1]=temp.get(k);
        //     }
        // }

        // int i=n1-1;
        // int j=0;
        // while(i>=0 && j<n2){
        //     if(a[i]>b[j]){
        //         swap(a,b,i,j);
        //     }
        //     else{
        //         break;
        //     }
        //     i--;
        //     j++;
        // }
        // Arrays.sort(a);
        // Arrays.sort(b);

        int len=n1+n2;
        int gap=((len)/2)+((len)%2);
        while(gap>0){
            int left=0;
            int right=left+gap;
            while(right<len){
                if(left<n1 && right>=n1){
                    if(a[left]>b[right-n1]){
                        swap(a, b, left, right-n1);
                    }
                }
                else if(left>=n1){
                    if(b[left-n1]>b[right-n1]){
                        swap(b, b, left-n1, right-n1);
                    }
                }
                else{
                    if(a[left]>a[right]){
                        swap(a, a, left, right);
                    }
                }
                left++;
                right++;
            }
            if(gap==1) break;
            else gap=(gap/2)+(gap%2);
        }

        
        for(int p1=0;p1<n1;p1++){
            System.out.print(a[p1]+" ");
        }
        System.out.println();
        for(int p2=0;p2<n2;p2++){
            System.out.print(b[p2]+" ");
        }
    }
}