//Count reverse pairs - 1)


import java.util.*;
class Arrays41{
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int a[]=new int[n];
            for (int i = 0; i < n; i++){
                a[i]=sc.nextInt();
            }
            int c=0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(a[i]>2*a[j]){
                        c++;
                    }
                }
            }
            System.out.println(c);
    }
}