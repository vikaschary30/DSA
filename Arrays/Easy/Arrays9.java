//Union of two sorted arrays -- 1) Treeset/ hashset/ brute force        2) 2-pointer technique

import java.util.*;

class Arrays9{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int a[]=new int[n1];
        for (int i = 0; i < n1; i++){
            a[i]=sc.nextInt();
        } 
        int n2=sc.nextInt();
        int b[]=new int[n2];
        for (int i = 0; i < n2; i++){
            b[i]=sc.nextInt();
        } 
        // TreeSet<Integer> ts=new TreeSet<>();
        // for(int num: a){
        //     ts.add(num);
        // }
        // for(int num: b){
        //     ts.add(num);
        // }

        int p1=0;
        int p2=0;
        List<Integer> ls=new ArrayList<>();
        while(p1<n1 && p2<n2){
            if(a[p1]<=b[p2]){
                if(ls.size()==0 || !ls.contains(a[p1])){
                    ls.add(a[p1]);
                }
                p1++;
            }
            else{
                if(ls.size()==0 || !ls.contains(b[p2])){
                    ls.add(b[p2]);
                }
                p2++;
            }
        }
        while(p1<n1){
            if(ls.size()==0 || !ls.contains(a[p1])){
                ls.add(a[p1]);
            }
            p1++;
        }
        while(p2<n2){
            if(ls.size()==0 || !ls.contains(b[p2])){
                ls.add(b[p2]);
            }
            p2++;
        }
        System.out.println(ls);
    }
}