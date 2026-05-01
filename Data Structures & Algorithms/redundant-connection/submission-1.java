class Solution {

    class DisjointSet {
        int[] rank;
        int[] size;
        int[] par;
        public DisjointSet(int n) {
            rank = new int[n + 1]; // for 1 indexed
            size = new int[n + 1];
            par = new int[n + 1];
            
            for (int i = 0; i < n; i++) {
                par[i] = i;
                size[i] = 1; // number of nodes beneath + 1 
            }
        }

        public boolean find(int u, int v) {
            return findUPar(u) == findUPar(v);
        }

        public int findUPar(int node){
            if(par[node] == node) return node;
            par[node] = findUPar(par[node]);
            return par[node];
        }

        public void unionByRank(int u, int v) {
            int up_u = findUPar(u); // ultimate parent of u
            int up_v = findUPar(v);
            
            if(up_u == up_v) return; // already in same component
            
            int rank_up_u = rank[up_u];
            int rank_up_v = rank[up_v];
            if(rank_up_u < rank_up_v){
                par[up_u] = up_v;
            } else if(rank_up_u > rank_up_v) {
                par[up_v] = up_u;
            } else {
                par[up_u] = up_v;
                rank[up_v]++; // rank of the ultimate parent increased
            }
        }

        public void unionBySize(int u, int v) {
            int up_u = findUPar(u); 
            int up_v = findUPar(v);
            
            if(up_u == up_v) return; 
            
            int size_up_u = size[up_u];
            int size_up_v = size[up_v];

            if(size_up_u < size_up_v){
                size[up_v] += size[up_u];
                par[up_u] = up_v;
            } else {
                size[up_u] += size[up_v];
                par[up_v] = up_u;
            }
        }
    }


    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet dsu = new DisjointSet(edges.length);
        for(int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if(dsu.find(u, v)) return edge;
            dsu.unionBySize(u, v);
        }
        return new int[]{-1,-1};
    }
}
