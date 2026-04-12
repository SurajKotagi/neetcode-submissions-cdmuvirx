class Solution {

    class Pair {
        int freq;
        int availableAt;

        Pair(int freq, int availableAt) {
            this.freq = freq;
            this.availableAt = availableAt;
        }
    }

    public int leastInterval(char[] tasks, int k) {

        // Step 1: Count frequency
        int[] count = new int[26];
        for (char ch : tasks) {
            count[ch - 'A']++;
        }

        // Step 2: Max heap (pick highest freq first)
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
        for (int c : count) {
            if (c > 0) maxPq.add(c);
        }

        // Step 3: Cooldown queue (IMPORTANT: FIFO by time)
        Queue<Pair> q = new LinkedList<>();

        int time = 0;

        while (!maxPq.isEmpty() || !q.isEmpty()) {

            // 🔥 Step 1: release all tasks whose cooldown is over
            while (!q.isEmpty() && q.peek().availableAt <= time) {
                maxPq.add(q.remove().freq);
            }

            // 🔥 Step 2: execute best available task
            if (!maxPq.isEmpty()) {
                int cur = maxPq.remove();

                if (cur > 1) {
                    // next available time = time + k + 1
                    q.add(new Pair(cur - 1, time + k + 1));
                }
            }

            // 🔥 Step 3: move time forward
            time++;
        }

        return time;
    }
}