class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(String elm : tokens) {
            if(elm.equals("+") || elm.equals("-") || elm.equals("*") || elm.equals("/")) {
                int operand2 = Integer.parseInt(st.pop());
                int operand1 = Integer.parseInt(st.pop());
                if (elm.equals("+")) { 
                    st.push(String.valueOf(operand1 + operand2));
                } else if(elm.equals("-")) {
                    st.push(String.valueOf(operand1 - operand2));
                } else if(elm.equals("*")) {
                    st.push(String.valueOf(operand1 * operand2));
                } else if(elm.equals("/")) {
                    st.push(String.valueOf(operand1 / operand2));
                } 
            } else {
                st.push(elm);
            }
        }
        return Integer.parseInt(st.pop());
    }
}
