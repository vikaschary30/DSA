class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY stringList
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
    // Write your code here
        int n=stringList.size();
        int m=queries.size();
        int c=0;
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<String,Integer> hm=new HashMap<>();
        for(String s: stringList){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        for(String s:queries){
            res.add(hm.getOrDefault(s,0));
        }
        return res;
    }

}