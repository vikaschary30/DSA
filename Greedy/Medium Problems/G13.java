// Shortest Job First (or SJF) CPU Scheduling - Problem Statement :  Given a list of job durations representing the time it takes to complete each job. Implement the Shortest Job First algorithm to find the average waiting time for these jobs.
//                                              1) optimal - 


import java.util.*;
class G13{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }

        int t=0,wt=0;
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            wt+=t;
            t+=a[i];
        }
        System.out.println(wt);
    }
}