class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> gp = new ArrayList<>();
        for(int i = 0 ;i < n; i++) {
            gp.add(new ArrayList<>()); 
        }
        for (int [] edge : edges) {
            if(edge[0] == edge[1]) return false;
            gp.get(edge[0]).add(edge[1]);
            gp.get(edge[1]).add(edge[0]);
        }
        // for(int i = 0; i < n;i++) System.out.println(gp.get(i));

        boolean [] vis = new boolean[n];
        boolean valid = dfs(0, gp, vis,-1);
        if(!valid) return false;
        for(int i = 0; i < n; i++) if(!vis[i]) return false;
        return true;
    }
    public boolean dfs(int node, List<List<Integer>> gp, boolean[] vis, int prev){

        vis[node] = true;
        // System.out.println("marked " + node);
        for (int nei : gp.get(node)) {
            if (prev != nei) {
                // System.out.println("checked " + nei + " , vis --> " + vis[nei]);
                if(vis[nei]) return false;
                if(!dfs(nei, gp, vis, node)) return false;
            }
        }
        return true;
    }
}
