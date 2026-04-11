class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] ans = new int[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        int[] mat = new int[numCourses];
        for (int [] pre : prerequisites){
            mat[pre[0]]++;
            map.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(mat[i] == 0)
                q.add(i);
        } 
        
        List<Integer> ansLs = new ArrayList<>();
        while (q.size() > 0) {
            int node = q.remove();
            ansLs.add(node);
            for(int nei : map.get(node)){
                mat[nei]--;
                if(mat[nei] == 0){
                    q.add(nei);
                }
            }
        }
        if(ansLs.size() < numCourses) return new int[0];

        for(int i = 0; i < numCourses; i++){
            ans[i] = ansLs.get(i);
        }
        return ans;
    }

    public boolean dfs(int node, 
                       boolean[] visited, 
                       Map<Integer, List<Integer>> map, 
                       int[] ans, 
                       int idx){
        if (visited[node]) { 
            return false;
        }

        visited[node] = true;
        ans[idx] = node;
        for(int nei : map.get(node)){
            if(!dfs(nei, visited, map, ans, idx+1)){
                return false;
            }
        }
        visited[node] = false;
        return true;
    }
}
