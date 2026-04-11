class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int x : nums) {
            if(pq.size() == k){
                if(x >= pq.peek()){
                    pq.add(x);
                    pq.remove();
                }
            } else {
                pq.add(x);
            }
        }
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
