class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n+2];
        long max =0,curr=0;
        for(List<Integer> q : queries){
            int a =q.get(0);
            int b =q.get(1);
            int k =q.get(2);
            arr[a]+=k;
            arr[b+1]-=k;
        }
        for(int i=0;i<arr.length;i++){
            curr+=arr[i];
            if(max<curr){
                max=curr;
            }
        }
        return max;

    }

}