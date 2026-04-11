class Solution {

    class Pair {
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean [][] visited = new boolean[m][n];

        Queue<Pair> aq = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            visited[i][n-1] = true;
            aq.add(new Pair(i,n-1));
        }
        for(int j = 0; j < n-1; j++){
            visited[m-1][j] = true;
            aq.add(new Pair(m-1,j));
        }
        while(aq.size() > 0){
            int sz = aq.size();
            for(int i = 0; i < sz; i++) {
                Pair cur = aq.remove();
                int x = cur.x;
                int y = cur.y;
                int h = heights[x][y];

                if(x-1 >= 0 && !visited[x-1][y] && heights[x-1][y] >= h){
                    visited[x-1][y] = true;
                    aq.add(new Pair(x-1, y));
                }
                if(y-1 >= 0 && !visited[x][y-1] && heights[x][y-1] >= h){
                    visited[x][y-1] = true;
                    aq.add(new Pair(x, y-1));
                }
                if(x+1 < m && !visited[x+1][y] && heights[x+1][y] >= h){
                    visited[x+1][y] = true;
                    aq.add(new Pair(x+1, y));
                }
                if(y+1 < n && !visited[x][y+1] && heights[x][y+1] >= h){
                    visited[x][y+1] = true;
                    aq.add(new Pair(x, y+1));
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        boolean [][] visited2 = new boolean[m][n];
        for(int i = 0; i < m; i++){
            if(visited[i][0] == true) {
                ans.add(new ArrayList<Integer>(Arrays.asList(i, 0)));
            }
            visited2[i][0] = true;
            aq.add(new Pair(i,0));
        }
        for(int j = 1; j < n; j++){
            if(visited[0][j] == true) {
                ans.add(new ArrayList<Integer>(Arrays.asList(0, j)));
            }
            visited2[0][j] = true;
            aq.add(new Pair(0,j));
        }
        while(aq.size() > 0){
            int sz = aq.size();
            for(int i = 0; i < sz; i++) {
                Pair cur = aq.remove();
                int x = cur.x;
                int y = cur.y;
                int h = heights[x][y];

                if(x-1 >= 0 && !visited2[x-1][y] && heights[x-1][y] >= h){
                    visited2[x-1][y] = true;
                    if(visited[x-1][y] == true) 
                        ans.add(new ArrayList<Integer>(Arrays.asList(x-1, y)));
                    aq.add(new Pair(x-1, y));
                }
                if(y-1 >= 0 && !visited2[x][y-1] && heights[x][y-1] >= h){
                    visited2[x][y-1] = true;
                    if(visited[x][y-1] == true) 
                        ans.add(new ArrayList<Integer>(Arrays.asList(x, y-1)));
                    aq.add(new Pair(x, y-1));
                }
                if(x+1 < m && !visited2[x+1][y] && heights[x+1][y] >= h){
                    visited2[x+1][y] = true;
                    if(visited[x+1][y] == true) 
                        ans.add(new ArrayList<Integer>(Arrays.asList(x+1, y)));
                    aq.add(new Pair(x+1, y));
                }
                if(y+1 < n && !visited2[x][y+1] && heights[x][y+1] >= h){
                    visited2[x][y+1] = true;
                    if(visited[x][y+1] == true) 
                        ans.add(new ArrayList<Integer>(Arrays.asList(x, y+1)));
                    aq.add(new Pair(x, y+1));
                }
            }
        }
        return ans;
    }
}
