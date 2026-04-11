class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        hzFlip(matrix);
    }
    public void transpose(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n-i; j++) {
                int temp  = mat[i][j];
                mat[i][j] = mat[n-j-1][m-i-1];
                mat[n-j-1][m-i-1] = temp;
            }
        }
    }

    public void hzFlip(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0 ; i < m/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp  = mat[i][j];
                mat[i][j] = mat[m-i-1][j];
                mat[m-i-1][j] = temp;
            }
        }
    }
}
