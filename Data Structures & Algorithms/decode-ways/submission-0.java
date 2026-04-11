class Solution {
    public int numDecodings(String s) {
        int[] ans = new int[1];
        helper(s , ans);
        return ans[0];
    }
    public void helper(String s, int[] ans){
        if(s.length() == 0){
            ans[0]++;
            return;
        } 
        for(int j = 1; j <= 26; j++){
            String x = j + "";
            if(s.startsWith(x)){
                helper(s.substring(x.length()), ans);
            }
        }
    }
}
