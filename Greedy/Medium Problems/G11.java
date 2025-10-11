// Candy - Problem Statement : A line of N kids is standing there. The rating values listed in the integer array ratings are assigned to each kid. These kids are receiving candy according to the following criteria:There must be at least one candy for every child.Kids whose scores are higher than their neighbours receive more candies than their neighbours.Return the minimum number of candies needed to distribute among children.
//         1) brute force - TC:O(3N) SC:O(2N) It performs two full passes — left-to-right and right-to-left — assigning candies in each direction (left[] and right[] arrays), then takes the maximum candies needed for each child from both sides to ensure all conditions are satisfied.
//         2) better - TC:O(2N) SC:O(N) It first assigns candies in a left-to-right pass, then uses a single variable during the right-to-left pass to adjust for decreasing ratings and directly compute the total by taking the maximum of both directions on the fly, saving extra space.


import java.util.*;
class G11{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ratings[]=new int[n];
        for (int i = 0; i < n; i++) {
            ratings[i]=sc.nextInt();   
        }

        //brute force:
        // int left[]=new int[n];
        // int right[]=new int[n];
        // Arrays.fill(left, 1);
        // Arrays.fill(right, 1);
        // for(int i=1;i<n;i++){
        //     if(ratings[i]>ratings[i-1]){
        //         left[i]=left[i-1]+1;
        //     }
        // }
        // for(int i=n-2;i>=0;i--){
        //     if(ratings[i]>ratings[i+1]){
        //         right[i]=right[i+1]+1;
        //     }
        // }
        // int sum=0;
        // for(int i=0;i<n;i++){
        //     sum+=Math.max(left[i],right[i]);
        // }
        // System.out.println(sum);


        //better:
        int left[]=new int[n];
        Arrays.fill(left, 1);
        int sum=0;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }
        }
        int curr=1;
        sum=Math.max(left[n-1],1);
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                curr++;
            }
            else{
                curr=1;
            }
            sum+=Math.max(left[i],curr);
        }
        System.out.println(sum);

    }
}