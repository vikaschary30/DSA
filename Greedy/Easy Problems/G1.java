// Assign Cookies - Problem Statement : Consider a scenario where a teacher wants to distribute cookies to students, with each student receiving at most one cookie. Given two arrays, student and cookie, the ith value in the student array describes the minimum size of cookie that the ith student can be assigned. The jth value in the cookie array represents the size of the jth cookie. If cookie[j] >= student[i], the jth cookie can be assigned to the ith student. Maximize the number of students assigned with cookies and output the maximum number.
//                  1) optimal - TC:O(NLogN+MLogM+N) SC:O(1) Sort both arrays and use two pointers to greedily assign the smallest cookie that satisfies each student, maximizing the total number of satisfied students.

import java.util.*;

class G1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int Student[] = new int[n];
        for(int i=0;i<n;i++){
            Student[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        int Cookie[] = new int[m];
        for(int i=0;i<m;i++){
            Cookie[i]=sc.nextInt();
        }

        Arrays.sort(Student);
        Arrays.sort(Cookie);
        int l=0,r=0;
        while(l<n && r<m){
            if(Student[l]<=Cookie[r]){
                l++;
            } 
            r++;
        }
        System.out.println(l);
    }
}