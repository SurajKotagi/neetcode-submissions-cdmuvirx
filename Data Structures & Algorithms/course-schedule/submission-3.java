class Solution {
    // Kahns Algorithm (Topological Sort)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] mat = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites){
            map.get(pre[1]).add(pre[0]);
            mat[pre[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>(); 
        for (int i = 0; i < numCourses; i++) {
            if(mat[i] == 0) q.add(i);
        }
        int completedCourses = 0;
        while (q.size() > 0) {
            int node = q.remove();
            completedCourses++;

            for(int nei : map.get(node)){
                mat[nei]--;
                if(mat[nei] == 0) q.add(nei);
            }
        }
        return completedCourses == numCourses;
    }
}
