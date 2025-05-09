class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int maxi=0;
        for(int i=0;i<heights.length;i++){
            while(st.peek()!=-1 && heights[i]<heights[st.peek()]){
                int x=st.pop();
                int rightmin=i;
                int leftmin=st.peek();
                maxi=Math.max(heights[x]*((rightmin-leftmin)-1),maxi);
            }
            st.push(i);
        }
        while(st.peek()!=-1){
            int x=st.pop();
            int rightmin=heights.length;
            int leftmin=st.peek();
            maxi=Math.max(heights[x]*((rightmin-leftmin)-1),maxi);
        }
        return maxi;
    }
}