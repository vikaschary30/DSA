// Remove the last set bit

import java.util.*;
class BM8{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int res=n&n-1;
        System.out.println(res);
    }
}