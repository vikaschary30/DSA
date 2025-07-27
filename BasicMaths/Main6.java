//prime number



import java.util.*;
class Main6{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                c++;
                if((n/i)!=i){
                    c++;                                  //O(sqrt(n))
                }
            }
        } 
        if(c!=2){
            System.out.println("false");
        }
        else{
            System.out.println("true");
        }
    }
}