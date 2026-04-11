class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] rightSmaller = new int [n];
        for (int i = heights.length-1; i >= 0; i--) {
            int cur = heights[i];
            while(!st.isEmpty() && heights[st.peek()] >= cur){
                st.pop();
            }
            if(st.isEmpty()) rightSmaller[i] = n;
            else {
                rightSmaller[i] = st.peek();
            }
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        int[] leftSmaller = new int [n];
        for (int i = 0; i < n; i++) {
            int cur = heights[i];
            while(!st.isEmpty() && heights[st.peek()] >= cur){
                st.pop();
            }
            if(st.isEmpty()) leftSmaller[i] = -1;
            else {
                leftSmaller[i] = st.peek();
            }
            st.push(i);
        }
        int maxArea = 0;
        for(int i = 0 ;i < n; i++){
            maxArea = Math.max(maxArea, (rightSmaller[i] - leftSmaller[i] - 1)*heights[i]);
        }
        return maxArea;
    }
}
