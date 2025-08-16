// next permutation -- 1) brute force - generating all permutations, iterating till the desired permutation and return its next permutation.
//                     2) optimal - Find the first decreasing element from the right, swap it with the next greater element, then reverse the suffix.

import java.util.*;
class Arrays23{
    public static void swap(int a[],int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void reverse(int a[],int i,int j){
        while(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int id=-1;
        for(int i=n-2;i>=0;i--){
            if(a[i]<a[i+1]){
                id=i;
                break;
            }
        }
        if(id!=-1){
            for(int i=n-1;i>id;i--){
                if(a[i]>a[id]){
                    swap(a,i,id);
                    break;
                }
            }
            reverse(a,id+1,n-1);
        }
        else{
            reverse(a,0,n-1);
        }
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}