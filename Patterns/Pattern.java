
import java.util.Scanner;

class Pattern{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        pattern7(n);
    }
    public static void pattern1(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.err.print("*"+" ");
            }
            System.err.println();
        }
    }
    public static void pattern2(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.err.print("*"+" ");
            }
            System.err.println();
        }
    }
    public static void pattern3(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.err.print((j+1)+" ");
            }
            System.err.println();
        }
    }
    public static void pattern4(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.err.print((i+1)+" ");
            }
            System.err.println();
        }
    }
    public static void pattern5(int n) {
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                System.err.print("*"+" ");
            }
            System.err.println();
        }
    }
    public static void pattern6(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" "+" ");
            }
            for(int j=0;j<(2*i)+1;j++){
                System.out.print("*"+" ");
            }
            for(int j=0;j<n-i-1;j++){
                System.out.print(" "+" ");
            }
            System.out.println();
        }
    }
    public static void pattern7(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print(" "+" ");
            }
            for(int j=0;j<(2*n)-((2*i)+1);j++){
                System.out.print("*"+" ");
            }
            for(int j=0;j<i;j++){
                System.out.print(" "+" ");
            }
            System.out.println();
        }
    }
}