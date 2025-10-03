// Max Consecutive Ones III - Problem Statement : Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//                            1) brute force -


import java.util.*;
class SW2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        //brute force:
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int zeroes=0;
            for(int j=i;j<n;j++){
                if(a[j]==0){
                    zeroes++;
                }
                if(zeroes>k){
                    break;
                }
                max=Math.max(max,j-i+1);
            }
        }
        System.out.println(max);
    }
}