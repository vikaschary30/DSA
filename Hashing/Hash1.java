//count freq of each element

import java.util.*;
class Hash1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("enter n elements:");
        int a[]=new int[n];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            hm.put(a[i], hm.getOrDefault(a[i], 0)+1);
        }
        // int hash[]=new int[100];
        // for(int i=0;i<n;i++){
        //     hash[a[i]]+=1;
        // }
        System.out.println("Enter no of queries");
        int q=sc.nextInt();
        while(q-->0){
            int e=sc.nextInt();
            System.out.println(hm.get(e));
        }
    }
}