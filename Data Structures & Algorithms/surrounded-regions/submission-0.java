class Solution {
    class Pair {
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(board[i][j] == 'O'){
                        Queue<Pair> q= new ArrayDeque<>();
                        q.add(new Pair(i, j));
                        board[i][j] = '1';
                        while(q.size()>0){
                            Pair cur = q.remove();
                            int x = cur.x;
                            int y = cur.y;

                            if(x-1 >= 0 && board[x-1][y]=='O'){
                                board[x-1][y] = '1';
                                q.add(new Pair(x-1, y));
                            } 
                            if(x+1 < m && board[x+1][y]=='O'){
                                board[x+1][y] = '1';
                                q.add(new Pair(x+1, y));
                            } 
                            if(y-1 >= 0 && board[x][y-1]=='O'){
                                board[x][y-1] = '1';
                                q.add(new Pair(x, y-1));
                            } 
                            if(y+1 < n && board[x][y+1]=='O'){
                                board[x][y+1] = '1';
                                q.add(new Pair(x, y+1));
                            } 
                        }
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] =='1'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
