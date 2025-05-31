class Result {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
    // Write your code here
        int n=arr.size();
        int ps=0,ts=0,ss=0,ele=0;
        for(int i=0;i<n;i++){
            ts+=arr.get(i);
        }
        for(int i=0;i<n;i++){
            ele=arr.get(i);
            ss=ts-ele-ps;
            if(ss==ps){
                return "YES";
            }
            ps+=ele;
        }
        return "NO";
    }

}