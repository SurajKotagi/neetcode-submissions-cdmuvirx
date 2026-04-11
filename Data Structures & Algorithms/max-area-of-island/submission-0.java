class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1){
                    int [] area = new int[1];
                    helper(grid, visited, i, j, area);
                    maxArea = Math.max(area[0], maxArea);
                }
            }
        }
        return maxArea;
    }

    public void helper(int[][] grid, int[][] visited, int i , int j, int[] area){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == 0) return;
        if (visited[i][j] == 1) return;
        visited[i][j] = 1;

        area[0]++;
        helper(grid, visited, i+1, j, area);
        helper(grid, visited, i, j+1, area);
        helper(grid, visited, i-1, j, area);
        helper(grid, visited, i, j-1, area);        
    }
}
