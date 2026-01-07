// Check if the number is power of 2 or not

import java.util.*;
class BM9{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if((n&n-1)==0) System.out.println("Yes");
        else System.out.println("No");
    }
}