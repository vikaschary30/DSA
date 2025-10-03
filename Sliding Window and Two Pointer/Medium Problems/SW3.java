// Fruit Into Baskets - Problem Statement : There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.
//                                          he goal is to gather as much fruit as possible, adhering to the owner's stringent rules :There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. One of the baskets must hold the harvested fruits.
//                                          Once reaching a tree with fruit that cannot fit into any basket, stop.Return the maximum number of fruits that can be picked.
//                      1) brute force -
//                      2) better -
//                      3) optimal -

import java.util.*;
class SW3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        //brute force:
        int max=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> hs=new HashSet<>();
            for(int j=i;j<n;j++){
                hs.add(a[j]);
                if(hs.size()>2){
                    break;
                }
                else{
                    max=Math.max(max, j-i+1);
                }
            }
        }
        System.out.println(max);
    }
}