// Maximum continuous 1's --    1) brute force: iterate over array and use count variable
//                              2) 

import java.util.*;                      
class Arrays12{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        } 
        int c=0,ans=0;
        for(int i=0;i<n;i++){
            if(a[i]==1){
                c++;
                ans=Math.max(ans, c);
            }
            else if(a[i]==0){
                c=0;
            }
        }
        System.out.println(ans);
    }
}