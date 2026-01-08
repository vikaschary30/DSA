// Count number of bits to be flipped to convert A to B - Problem Statement :  Given two integers start and goal. Flip the minimum number of bits of start integer to convert it into goal integer.A bits flip in the number val is to choose any bit in binary representation of val and flipping it from either 0 to 1 or 1 to 0.

import java.util.*;
class BM13{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int st=sc.nextInt();
        int end=sc.nextInt();
        int ans=st^end;
        int c=0;
        while(ans!=0){
            ans=ans&(ans-1);
            c++;
        }
        System.out.println(c);
    }
}