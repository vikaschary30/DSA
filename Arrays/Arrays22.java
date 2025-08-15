//Rearrange Array Elements by Sign -- 1) brute force - (if pos==neg && pos!=neg) O(N^2) create pos and neg arrays , store the values and append them at last alteratively using even and odd indices.
//                                    2) optimal - (if pos==neg) O(N) use a two pointers like pos and neg to alternatively iterate and store the pos and neg in res array.


import java.util.*;
class Arrays22{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }


        // brute force - for both varieties i.e if (pos==neg) && (pos!neg)

        // List<Integer> l1=new ArrayList<>();
        // List<Integer> l2=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     if(a[i]>0){
        //         l1.add(a[i]);
        //     }
        //     else if(a[i]<0){
        //         l2.add(a[i]);
        //     }
        // }
        // if(l1.size()>l2.size()){
        //     for(int i=0;i<l2.size();i++){
        //         a[2*i]=l1.get(i);
        //         a[2*i+1]=l2.get(i);
        //     }
        //     int id=l2.size()*2;
        //     for(int i=l2.size();i<l1.size();i++){
        //         a[id]=l1.get(i);
        //         id++;
        //     }
        // }
        // else{
        //     for(int i=0;i<l1.size();i++){
        //         a[2*i]=l1.get(i);
        //         a[2*i+1]=l2.get(i);
        //     }
        //     int id=l1.size()*2;
        //     for(int i=l1.size();i<l2.size();i++){
        //         a[id]=l2.get(i);
        //         id++;
        //     }
        // }
        

        // optimal - for (pos==neg) only.
        int res[]=new int[n];
        int pos=0,neg=1;    
        for(int i=0;i<n;i++){
            if(a[i]>0 && pos<n){
                res[pos]=a[i];
                pos+=2;
            }
            else if(a[i]<0 && neg<n){
                res[neg]=a[i];
                neg+=2;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}