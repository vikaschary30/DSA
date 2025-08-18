//Linear search 

import java.util.*;
class Arrays8{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt(),f=-1;
        for(int i=0;i<n;i++){
            if(a[i]==k){
                f=i;
                break;
            }
        }
        System.out.println(f);
    }
}