// Leaders in a array -- 1) brute force -  iterate through the elements and check if is there any greater than the curr element, else add it to the res.
//                       2) optimal - Traverse the array from right to left, keeping track of the maximum seen so far, and mark an element as a leader if it is greater than this maximum.

import java.util.*;
class Arrays24{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        List<Integer> res=new ArrayList<>();
        // int f=0;
        // for(int i=0;i<n;i++){
        //     int curr=a[i];
        //     int j=i+1;
        //     while(j<n){
        //         if(a[j]>curr){
        //             f=1;
        //             break;
        //         }
        //         f=0;
        //         j++;
        //     }
        //     if(f==0){
        //         res.add(a[i]);
        //     }
        // }


        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(a[i]>max){
                res.add(a[i]);
                max=Math.max(max, a[i]);
            }
        }
        Collections.reverse(res);
        System.out.println(res);
    }
}