class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    // Write your code here
        int max=10001;
        int a[]=new int[max];
        int b[]=new int[max];
        for(int i: arr){
            a[i]++;
        }
        for(int i: brr){
            b[i]++;
        }
        List<Integer> al=new ArrayList<>();
        for(int i=0;i<max;i++){
            if(b[i]>a[i]){
                al.add(i);
            }
        }
        return al;
    }

}