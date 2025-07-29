//check if array is sorted.

import java.util.*;
class Arrays3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        boolean issort=true;
        for(int i=1;i<n;i++){
            if(a[i]<a[i-1]){
                issort=false;
                break;
            }
        }
        if(issort){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}