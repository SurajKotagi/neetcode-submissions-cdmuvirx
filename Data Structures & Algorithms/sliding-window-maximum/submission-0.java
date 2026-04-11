class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int [] ans = new int[nums.length - k + 1];
        int l = 0;
        int r = 0;
        while (r < k - 1) {
            pq.add(nums[r++]);
        }
        while (r < nums.length) {
            pq.add(nums[r++]);
            ans[l] = pq.peek();
            pq.remove(nums[l++]);
        }
        return ans;
    }
}
