// Minimum number of platforms required for a railway - Problem Statement : We are given two arrays that represent the arrival and departure times of trains that stop at the platform. We need to find the minimum number of platforms needed at the railway station so that no train has to wait.
//                                                      1) brute force - TC:O(N^2) SC:O(1) For each train, it checks how many other trains overlap in time with it (arrival–departure overlap) and keeps track of the maximum overlaps — which equals the minimum number of platforms required.
//                                                      2) optimal - TC:O(NlogN+N) SC:O(1) It sorts arrival and departure times, then uses two pointers to simulate train movements — increasing the platform count on arrivals and decreasing it on departures — tracking the maximum count needed at any time.


import java.util.*;
class G9{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int dep[]=new int[n];
        for (int i = 0; i < n; i++) {
            dep[i]=sc.nextInt();
        }

        //brute force:
        // int max=0,c=0;
        // for(int i=0;i<n;i++){
        //     c=1;
        //     for(int j=i+1;j<n;j++){
        //         if((arr[i]<=dep[j] && arr[i]>=arr[j]) || (arr[j]<=dep[i] && arr[j]>=arr[i])){
        //             c++;
        //         }
        //         max=Math.max(max,c);
        //     }
        // }
        // System.out.println(max);


        //optimal:
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0,max=0,c=0;
        while(i<n){
            if(arr[i]<=dep[j]){
                c++;
                i++;
            }
            else if(dep[j]<arr[i]){
                c--;
                j++;
            }
            max=Math.max(max,c);
        }
        System.out.println(max);
    }
}