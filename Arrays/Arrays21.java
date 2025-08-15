//Buy and sell stocks -- 1) brute force - O(N^2) iterate over through the array with each element and checking the max element after that and validating the condition.
//                       2) better - O(N) we check for the prev minimal element by tracking down the min element during iterations.
//                       3) optimal - Dynamic programming(later).


import java.util.*;
class Arrays21{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int price[]=new int[n];
        for(int i=0;i<n;i++){
            price[i]=sc.nextInt();
        }
        int ans=0;
        // for(int i=0;i<n;i++){
        //     int j=i+1;
        //     while(j<n){
        //         ans=Math.max(price[j]-price[i], ans);
        //         j++;
        //     }
        // }


        int min=price[0];
        for(int i=1;i<n;i++){
            ans=Math.max(ans,price[i]-min);
            min=Math.min(min, price[i]);
        }
        System.out.println(ans);
    }
}