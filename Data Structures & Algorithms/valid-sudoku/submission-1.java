class Solution {
    public boolean isValidSudoku (char[][] board) {
        for(char [] row : board)
            if(!checkRow(row)) return false;
        
        for(int col = 0; col < board[0].length; col++){
            if(!checkCol(board, col)) return false;
        }
        if(!checkBox(0, 0, board)) return false;
        if(!checkBox(0, 1, board)) return false;
        if(!checkBox(0, 1, board)) return false;
        if(!checkBox(0, 1, board)) return false;
        if(!checkBox(0, 1, board)) return false;
        if(!checkBox(0, 1, board)) return false;
        return true;
    }
    HashSet<Character> hs;
    public boolean checkRow (char [] row) {
        hs = new HashSet<>();
        for(char x : row) {
            if(x != '.'){
                if(hs.contains(x)) return false;
                hs.add(x);
            }
        }
        return true;
    }
    public boolean checkCol (char [][] board, int col) {
        hs = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            char x = board[i][col];
            if(x != '.'){
                if(hs.contains(x)) return false;
                hs.add(x);
            }
        }
        return true;
    }

    public boolean checkBox(int hzStart, int vrStart, char[][] board){
        hs = new HashSet<>();
        for(int row = 3 * hzStart; row < 3 * hzStart + 3; row++){
            for(int col  = 3 * vrStart; col < 3 * vrStart + 3; col++){
                char x = board[row][col];
                if(x != '.'){
                    if(hs.contains(x)) return false;
                    hs.add(x);
                }
            }
        }
        return true;
    }
}
