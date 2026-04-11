class Solution {
    public List<List<String>> solveNQueens(int n) {
        int [][] blocked = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        helper(0, blocked, ans, new ArrayList<>(), n);
        return ans; 
    }

    public void helper(int r, int [][] blocked, List<List<String>> ans, List<String> cur, int n){
        if(r == n) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        StringBuilder sb = new StringBuilder(".".repeat(n));
        for(int i = 0; i < n; i++){
            if (blocked[r][i] == 0){
                sb.setCharAt(i, 'Q');
                markDiagonal(blocked, r , i, n);
                markHz(blocked, r, n);
                markVr(blocked, i, n);
                cur.add(sb.toString());
                helper(r+1, blocked, ans, cur, n);
                sb.setCharAt(i, '.');
                unmarkDiagonal(blocked, r , i, n);
                unmarkHz(blocked, r, n);
                unmarkVr(blocked, i, n);
                cur.remove(cur.size()-1);
            } 
        }
    }

    public void markDiagonal(int [][] blocked, int i, int j, int n){
        int x = i, y = j;

        while (x < n && y < n) blocked[x++][y++]++;
        while (i < n && j >= 0) blocked[i++][j--]++;
    }

    public void unmarkDiagonal(int [][] blocked, int i, int j, int n){
        int x = i, y = j;

        while (x < n && y < n) blocked[x++][y++]--;
        while (i < n && j >= 0) blocked[i++][j--]--;
    }

    public void markHz(int [][] blocked, int r, int n) {
        for(int i = 0; i < n; i++) blocked[r][i]++;
    }
    public void markVr(int [][] blocked, int c, int n) {
        for(int i = 0; i < n; i++) blocked[i][c]++;
    }
    public void unmarkHz(int [][] blocked, int r, int n) {
        for(int i = 0; i < n; i++) blocked[r][i]--;
    }
    public void unmarkVr(int [][] blocked, int c, int n) {
        for(int i = 0; i < n; i++) blocked[i][c]--;
    }
}
