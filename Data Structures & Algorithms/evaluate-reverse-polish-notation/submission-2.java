class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String elm : tokens) {
            if(elm.equals("+") || elm.equals("-") || elm.equals("*") || elm.equals("/")) {
                int operand2 = st.pop();
                int operand1 = st.pop();
                if (elm.equals("+")) { 
                    st.push(operand1 + operand2);
                } else if(elm.equals("-")) {
                    st.push(operand1 - operand2);
                } else if(elm.equals("*")) {
                    st.push(operand1 * operand2);
                } else if(elm.equals("/")) {
                    st.push(operand1 / operand2);
                } 
            } else {
                st.push(Integer.parseInt(elm));
            }
        }
        return st.pop();
    }
}
