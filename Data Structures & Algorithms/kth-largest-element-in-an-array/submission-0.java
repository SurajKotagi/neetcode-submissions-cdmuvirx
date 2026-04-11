class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> b - a);
        for(int x : nums) q.add(x);
        while(k != 1){
            q.remove();
            k--;
        } 
        return q.remove(); 
    }
}
