//Move zeroes to end of array

import java.util.*;
class Arrays7{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();                   // 1 2 0 3 0 0 1 1 
        }
        // List<Integer> l=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     if(a[i]!=0){
        //         l.add(a[i]);
        //     }
        // }
        // int id=0;
        // for(int num:l){
        //     a[id]=num;
        //     id++;
        // }
        // for(int i=id;i<n;i++){
        //     a[i]=0;
        // }                                                 "Bruteforce"


        //"better"
        // int j=-1;
        // for(int i=0;i<n;i++){
        //     if(a[i]==0){
        //         j=i;
        //         break;
        //     }
        // }
        // if(j==-1){
            //     return;
            // }
            // else{
            // for(int i=j+1;i<n;i++){
            //     if(a[i]!=0){
            //         int temp=a[i];
            //         a[i]=a[j];
            //         a[j]=temp;
            //         j++;
            //     }
            // }
        // }

        //"optimal"
        int j=0;
        for(int i=0;i<n;i++){
            if(a[i]!=0){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                j++;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}