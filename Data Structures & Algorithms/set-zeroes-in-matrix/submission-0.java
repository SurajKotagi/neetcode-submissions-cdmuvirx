class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void setZeroes(int[][] mat) {
        List<Pair> arr = new ArrayList<>();
        for(int i = 0; i < mat.length; i++)
            for (int j= 0 ; j < mat[0].length; j++)
                if(mat[i][j] == 0)
                    arr.add(new Pair(i, j));
        
        for (Pair p : arr){
            zeroes(mat, p.x, p.y);
        }
    }

    public void zeroes(int[][] mat ,int r, int c){
        for (int i=0; i < mat.length; i++){
            mat[i][c]=0;
        }
        for (int i=0; i < mat[0].length; i++){
            mat[r][i]=0;
        }
    }
}
