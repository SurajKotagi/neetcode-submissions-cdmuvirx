class MinStack {
    long min;
    Stack<Long> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(0L);
            min = val;
        } else {
            st.push(val - min);
            if(val - min < 0) min = val;
        }

    }
    
    public void pop() {
        long x = st.pop();
        if(x < 0) {
            min = min - x;
        }
    }
    
    public int top() {
        if(st.peek() < 0) return (int) min;
        return (int) (st.peek() + min);
    }
    
    public int getMin() {
        return (int) min;
    }
}
