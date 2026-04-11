class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int x : nums) {
            pq.add(x);
        }
        while(pq.size() > k) pq.remove();
    }
    
    public int add(int val) {
        if(pq.size() == k){
            if(val >= pq.peek()){
                pq.add(val);
                pq.remove();
            }
        } else {
            pq.add(val);
        }
        return pq.peek();
    }
}
