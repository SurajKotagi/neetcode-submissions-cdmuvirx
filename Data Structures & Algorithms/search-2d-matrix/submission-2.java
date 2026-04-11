class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length-1;
        int row = binarySearch1(matrix, l, r, target);
        if(row < 0 || row >= matrix.length) return false;
        return binarySearch2(matrix, row, 0, matrix[0].length-1, target);
    }
    public int binarySearch1(int[][] mat, int l, int r, int target){
        while (l <= r) {
            int mid  = (l + r) / 2;
            if (mat[mid][0] < target) {
                l = mid + 1;
            } else if (mat[mid][0] > target) {
                r = mid - 1;
            } else {    
                return mid;
            }
        }
        return r;
    }

    public boolean binarySearch2(int[][] mat, int row, int l, int r, int target){
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mat[row][mid] < target) {
                l = mid + 1;
            } else if(mat[row][mid] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
