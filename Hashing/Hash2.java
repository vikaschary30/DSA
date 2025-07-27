// highest freq of ele


import java.util.*;
class Hash2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("enter n elements:");
        int a[]=new int[n];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            hm.put(a[i], hm.getOrDefault(a[i], 0)+1);
        }
        int max=Integer.MIN_VALUE,ans=0;
        for(int i=0;i<n;i++){
            if(hm.get(a[i])>max){
                max=Math.max(hm.get(a[i]), max);
                ans=a[i];
            }
        }
        System.out.println(ans);
    }
}