class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> gp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            gp.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            gp.get(edge[0]).add(edge[1]);
            gp.get(edge[1]).add(edge[0]);
        }

        int cmpnts = 0;
        boolean [] vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                cmpnts++;
                dfs(i, gp, vis);
            }
        }
        return cmpnts;
    }
    public void dfs(int node, List<List<Integer>> gp, boolean[]vis){
        vis[node] = true;
        for (int nei : gp.get(node)) {
            if(!vis[nei]) dfs(nei, gp, vis); 
        }
    }
}
