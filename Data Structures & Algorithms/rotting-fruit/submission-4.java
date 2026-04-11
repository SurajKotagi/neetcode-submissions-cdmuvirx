class Solution {
    class Pair {
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j));
                }
            }
        }

        int mins = 0;
        while (q.size() > 0){
            int sz = q.size();
            mins++;
            for(int i = 0; i < sz; i++){
                Pair cur = q.remove();
                int x = cur.x;
                int y = cur.y;
                int xm1 = x-1;
                int xp1 = x+1;
                int ym1 = y-1;
                int yp1 = y+1;
                if(xm1 >= 0 && grid[xm1][y] == 1){
                    grid[xm1][y] = 2;
                    q.add(new Pair(xm1, y));
                } 
                if(ym1 >= 0 && grid[x][ym1] == 1){
                    grid[x][ym1] = 2;
                    q.add(new Pair(x, ym1));
                } 
                if(xp1 < m && grid[xp1][y] == 1){
                    grid[xp1][y] = 2;
                    q.add(new Pair(xp1, y));
                } 
                if(yp1 < n && grid[x][yp1] == 1){
                    grid[x][yp1] = 2;
                    q.add(new Pair(x, yp1));
                } 
            }
        }
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return (mins == 0) ? mins : mins-1;
    }
}
