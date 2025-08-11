//Intersection of two sorted arrays -- 1) brute force -- O(N^2)
//                                     2) 2-pointer technique

import java.util.*;

class Arrays11{
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
        List<Integer> l=new ArrayList<>();
        // int vis[]=new int[n2];
        // for(int i=0;i<n2;i++){
        //     vis[i]=0;
        // }
        // for(int i=0;i<n1;i++){
        //     for(int j=0;j<n2;j++){
        //         if(a[i]==b[j] && vis[j]==0){
        //             l.add(a[i]);
        //             vis[j]=1;
        //             break;
        //         }
        //     }
        // }
        int i=0;
        int j=0;
        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                i++;
            }
            else if(b[j]<a[i]){
                j++;
            }
            else{
                l.add(a[i]);
                i++;
                j++;
            }
        }
        for(int num:l){
            System.out.print(num+" ");
        }
    }
}