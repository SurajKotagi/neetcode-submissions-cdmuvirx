class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : stones) pq.add(x);

        while(pq.size() > 1){
            int one = pq.remove();
            int two = pq.remove();
            if(one > two){
                pq.add(one-two);
            } else if(two > one) {
                pq.add(two-one);
            }
        }
        return pq.size() > 0 ? pq.remove() : 0;
    }
}
