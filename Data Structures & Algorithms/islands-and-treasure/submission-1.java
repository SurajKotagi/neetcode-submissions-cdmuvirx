class Solution {

    class Pair {
        int x;
        int y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0){
                    q.add(new Pair(i , j));
                }
            }
        } 
        int cnt = 1;
        while(q.size() > 0){
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Pair cur = q.remove(); 
                int x = cur.x;
                int y = cur.y;
                if(x-1 >= 0 && grid[x-1][y] == 2147483647){
                    grid[x-1][y] = cnt;
                    q.add(new Pair(x-1, y));
                }
                if(y-1 >= 0 && grid[x][y-1] == 2147483647){
                    grid[x][y-1] = cnt;
                    q.add(new Pair(x, y-1));
                }
                if(x+1 < m && grid[x+1][y] == 2147483647){
                    grid[x+1][y] = cnt;
                    q.add(new Pair(x+1, y));
                }
                if(y+1 < n && grid[x][y+1] == 2147483647){
                    grid[x][y+1] = cnt;
                    q.add(new Pair(x, y+1));
                }
            }
            cnt++;
        }
    }
}
