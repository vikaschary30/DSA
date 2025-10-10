// Jump Game I - Problem Statement : Given an array where each element represents the maximum number of steps you can jump forward from that element, return true if we can reach the last index starting from the first index. Otherwise, return false.
//               1) optimal - TC:O(N) SC:O(1) track the farthest index reachable at each step, and if the current index ever exceeds this reach, return false; otherwise, true if the end is reachable.

import java.util.*;
class G7{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }

        int max=0;
        for(int i=0;i<n;i++){
            if(i>max){
                System.out.println("false");
                return;
            }
            max=Math.max(max,i+a[i]);
        }
        System.out.println("true");
    }
}