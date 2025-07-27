//print all divisors

import java.util.*;
class Main5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        // int i=1;
        // while(i<=n){
        //     if(n%i==0){
        //         System.out.println(i);                          //O(n)
        //         i++;
        //     }
        //     i++;
        // }
        List<Integer> l=new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                l.add(i);
                if((n/i)!=i){
                    l.add(n/i);                                  //O(sqrt(n))
                }
            }
        } 
        Collections.sort(l);
        System.out.println(l);
    }
}