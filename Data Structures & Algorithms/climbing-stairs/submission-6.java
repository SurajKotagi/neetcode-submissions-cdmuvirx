class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int min2 = 1;
        int min1 = 2;
        int ans = 0;
        for(int i = 3 ; i <= n; i++){
            ans = (min1 + min2);
            min2 = min1;
            min1 = ans; 
        }
        return ans;
    }
}
