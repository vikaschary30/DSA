// Lemonade Change - Problem Statement : Given an array representing a queue of customers and the value of a they hold, determine if it is possible to provide correct change to each customer. Customers can only pay with 5$, 10$ or 20$ a and we initially do not have any change at hand. Return true, if it is possible to provide correct change for each customer otherwise return false.
//                   1) optimal - Greedy approach — TC:O(n) SC:O(1) always give change using higher denominations first (prefer one $10 + one $5 over three $5 bills) to preserve smaller bills for future customers.q

import java.util.*;
class G4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int five=0,ten=0;
        for(int i=0;i<n;i++){
            if(a[i]==5){
                five++;
            }
            else if(a[i]==10){
                if(five>0){
                    five--;
                    ten++;
                }
                else{
                    System.out.println("false");
                    return;
                }
            }
            else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }
                else if(five>=3){
                    five-=3;
                }
                else{
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
        return;
    }
}