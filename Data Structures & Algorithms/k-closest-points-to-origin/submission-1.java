class Solution {
    class Pair {
        int idx;
        double dist;

        Pair (int idx, double dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>( (a, b) -> Double.compare(a.dist, b.dist));
        for(int i = 0; i < points.length; i++){
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            q.add(new Pair(i, Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))));
        } 

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            ans[i] = points[q.remove().idx];
        }
        return ans;
    }
}
