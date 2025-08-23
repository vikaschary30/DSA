//Find the repeating and missing numbers -- 1) brute force  - TC:O(N^2) SC:O(1) Check each number 1..n in array to find missing and repeating.
//                                          2) better  - TC:O(N) SC:O(N) Use a hash array to count occurrences of each number.
//                                          2) optimal 1 - TC:O(N) SC:O(1) Use math (sum and sum of squares) to find missing and repeating.
//                                          2) optimal 2 - TC:O(N) SC:O(1) Use XOR partitioning to separate missing and repeating numbers.




import java.util.*;
class Arrays38{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }

        //brute force
        //int mnum=-1,tnum=-1;
        //int asum=(n*(n+1))/2;
        // for(int i=1;i<=n;i++){
        //     int c=0;
        //     for(int j=0;j<n;j++){
        //         if(i==a[j]){
        //             c++;
        //         }
        //     }
        //     if(c==2){
        //         tnum=i;
        //     }
        //     if(c==0){
        //         mnum=i;
        //     }
        //     if(tnum!=-1 && mnum!=-1) break;
        // }


        // better
        // int hash[]=new int[n+1];
        // for(int i=0;i<n;i++){
        //     hash[a[i]]++;
        // }
        // for(int i=1;i<=n;i++){
        //     if(hash[i]==0){
        //         mnum=i;
        //     }
        //     if(hash[i]==2){
        //         tnum=i;
        //     }
        // }


        //optimal-1
        //int x=-1,y=-1;
        // int s=0,sn=0;
        // int s2=0,s2n=0;
        // sn=(n*(n+1))/2;
        // s2n=(n*(n+1)*(2*n+1))/6;
        // for(int i=0;i<n;i++){
        //     s+=a[i];
        //     s2+=(a[i]*a[i]);
        // }
        // int val1=s-sn;
        // int val2=s2-s2n;
        // int rem=val2/val1;
        // x=(val1+rem)/2;
        // y=rem-x;

 
        //optimal-2
        int x=-1,y=-1;
        int xor=0;
        for(int i=0;i<n;i++){
            xor^=a[i];
            xor^=i;
        }
        int number=(xor & ~(xor-1));
        int zero=0;
        int one=0;
        for(int i=0;i<n;i++){
            if((a[i]&number)!=0){
                one^=a[i];
            }
            else{
                zero^=a[i];
            }
        }
        for(int i=1;i<=n;i++){
            if((i&number)!=0){
                one^=i;
            }
            else{
                zero^=i;
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(a[i]==zero){
                c++;
            }
        }
        if(c==0) System.out.print(one+" "+zero);
        else System.out.print(zero+" "+one);
    }
}