class MinStack {
    List<Integer> arr;
    PriorityQueue<Integer> pq;
    public MinStack() {
        arr = new ArrayList<>();
        pq = new PriorityQueue<>();
    }
    
    public void push(int val) {
        arr.add(val);
        pq.add(val);
    }
    
    public void pop() {
        pq.remove(arr.get(arr.size()-1));
        arr.remove(arr.size()-1);        
    }
    
    public int top() {
        return arr.get(arr.size()-1);
    }
    
    public int getMin() {
        return pq.peek();
    }
}
