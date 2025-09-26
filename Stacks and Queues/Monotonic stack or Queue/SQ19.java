// Trapping Rainwater - Problem Statement : Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.
//                      1) brute force - TC:O(N) SC:O(N) Precompute maximum heights to the left and right of each element, then sum the trapped water at each position.
//                      2) optimal - TC:O(N) SC:O(1) Use two pointers from both ends, updating left/right max heights on the go to calculate trapped water in a single pass with constant space.


import java.util.Scanner;

class SQ19{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        //brute force:
        // int[] psum=new int[n];
        // int[] ssum=new int[n];
        // psum[0]=a[0];
        // ssum[n-1]=a[n-1];
        // for(int i=1;i<n;i++){
        //     psum[i]=Math.max(a[i], psum[i-1]);
        // }
        // for(int i=n-2;i>=0;i--){
        //     ssum[i]=Math.max(a[i], ssum[i+1]);
        // }
        // int total=0;
        // for(int i=0;i<n;i++){
        //     total+=Math.min(psum[i],ssum[i])-a[i];
        // }
        // System.out.println(total);


        // optimal:
        int lmax=0,rmax=0,total=0;
        int left=0, right=n-1;
        while(left<=right){
            if(a[left]<a[right]){
                if(lmax>a[left]){
                    total+=lmax-a[left];
                }
                else{
                    lmax=a[left];
                }
                left++;
            }
            else{
                if(rmax>a[right]){
                    total+=rmax-a[right];
                }
                else{
                    rmax=a[right];
                }
                right--;
            }
        }
        System.out.println(total);
    }
}