// Fractional Knapsack Problem : Greedy Approach - Problem Statement : The weight of N items and their corresponding values are given. We have to put these items in a knapsack of weight W such that the total value obtained is maximized. We can either take the item as a whole or break it into smaller units.
//                                                 1) optimal - TC:O(NlogN+N) SC:O(1) Sort items by their value-to-weight ratio in descending order and greedily take whole or fractional parts until the knapsack is full to maximize total value.

import java.util.*;
class G2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] val=new int[n];
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        int wt[] = new int[m];
        for(int i=0;i<m;i++){
            wt[i]=sc.nextInt();
        }
        int w=sc.nextInt();

        double[] per=new double[n];
        for(int i=0;i<n;i++){
            per[i]=(double)val[i]/wt[i];
        }
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++) idx[i]=i;
        Arrays.sort(idx, (a, b) -> Double.compare(per[b], per[a]));
        double total=0;
        for(int i=0;i<n;i++){
            if(wt[idx[i]]<=w){
                total+=val[idx[i]];
                w-=wt[idx[i]];
            }
            else{
                total+=(per[idx[i]]*w);
                break;
            }
        }
        System.out.println(total);
    }
}