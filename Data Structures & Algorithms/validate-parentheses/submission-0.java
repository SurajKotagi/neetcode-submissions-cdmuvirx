class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
                continue;
            } else if (ch ==')') {
                if(st.isEmpty() || st.peek() != '(') return false;
            } else if (ch ==']') {
                if(st.isEmpty() || st.peek() != '[') return false;
            } else if (ch =='}') {
                if(st.isEmpty() || st.peek() != '{') return false;
            }
            st.pop();
        }
        if(st.isEmpty()) return true;
        return false;
    }
}
