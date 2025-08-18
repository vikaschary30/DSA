//remove duplicates in-place from the array or move the unique elements to the beginning
import java.util.*;
class Arrays4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        // HashSet<Integer> hs=new HashSet<>();
        // for(int i=0;i<n;i++){
        //     a[i]=sc.nextInt();
        //     if(!hs.contains(a[i])){
        //         hs.add(a[i]);
        //     }
        // }
        for (int s = 0; s < n; s++){
            a[s]=sc.nextInt();
        }
        int i=0;
        for(int j=0;j<n;j++){
            if(a[j]!=a[i]){
                a[i+1]=a[j];
                i++;
            }
        }
        for (int k = 0; k <=i; k++) {
            System.out.print(a[k]+" ");
        }
    }
}