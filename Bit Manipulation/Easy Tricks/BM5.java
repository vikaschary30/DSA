// Set the i-th bit 

import java.util.*;
class BM5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=sc.nextInt();
        int res=(n|(1<<i));
        System.out.println(res);
    }
}