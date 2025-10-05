// Maximum point you can obtain from cards - Problem Statement :  Given N cards arranged in a row, each card has an associated score denoted by the cardScore array. Choose exactly k cards. In each step, a card can be chosen either from the beginning or the end of the row. The score is the sum of the scores of the chosen cards.
//                                           1) brute force - TC:O(N^2) SC:O(1) Try every possible split of i cards taken from the front and k-i cards from the back, compute the sum, and return the maximum.
//                                           2) optimal - TC:O(N) SC:O(1) Start with the sum of the first k cards, then gradually replace front cards with back cards while tracking the maximum sum.


import java.util.*;
class SW8{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        //brute force:
        // int msum=0;
        // for(int i=0;i<=k;i++){
        //     int tsum=0;
        //     for(int j=0;j<i;j++){
        //         tsum+=a[j];
        //     }
        //     for(int j=0;j<k-i;j++){
        //         tsum+=a[n-1-j];
        //     }
        //     msum=Math.max(msum, tsum);
        // }
        // System.out.println(msum);



        //optimal:
        int msum=0,lsum=0;
        for(int i=0;i<k;i++){
            lsum+=a[i];
        }
        msum=lsum;
        int rsum=0,rind=n-1;
        for(int i=k-1;i>=0;i--){
            lsum-=a[i];
            rsum+=a[rind];
            rind--;
            msum=Math.max(msum, lsum+rsum);
        }
        System.out.println(msum);
    }
}