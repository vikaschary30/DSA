// Find minimum number of coins - Problem Statement : Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency, i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins and/or notes needed to make the change.
//                                1) optimal - Greedy Approach : TC:O(worst-(v/smallest_denomination)  or  avg-(1)) SC:O(deno.length) always pick the largest denomination less than or equal to the remaining value until the total sum equals the target amount.

import java.util.*;
class G3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] deno={1,2,5,10,20,50,100,500,1000};
        int v=sc.nextInt();
        int c=0;
        for(int i=deno.length-1;i>=0;i--){
            while(deno[i]<=v){
                v-=deno[i];
                c++;
            }
        }
        System.out.println(c);
    }
}