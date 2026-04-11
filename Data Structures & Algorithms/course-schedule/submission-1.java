class Solution {


    // Cycle Detection 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();    
        for (int i = 0 ;i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for(int[] pre : prerequisites) {
            map.get(pre[1]).add(pre[0]);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0 ;i < numCourses; i++) {
                if(!dfs(i, visited, map)) return false;
        }
       return true;
    }

    public boolean dfs(int node, Set<Integer> visited, HashMap<Integer, List<Integer>> map){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        for (int next : map.get(node)){
            if(!dfs(next, visited, map)){
                return false;
            }
        }
        visited.remove(node);
        return true;
    }
}
