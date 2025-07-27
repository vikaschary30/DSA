//Selection sort -- simply selecting minimum from unsorted array and swap with first index of unsorted array, this makes the array sorted.


import java.util.*;
class Selections{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int temp=0;
        for(int i=0;i<=n-2;i++){
            int mini=i;
            for(int j=i;j<=n-1;j++){
                if(a[mini]>a[j]){
                    mini=j;
                }
            }
            temp=a[mini];
            a[mini]=a[i];
            a[i]=temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}