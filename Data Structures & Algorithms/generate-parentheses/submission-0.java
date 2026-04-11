class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper("", 0, 0, ans, n);
        return ans;
    }
    public void helper(String word, int open, int close, List<String> ans, int n){
        if(close == n) {
            ans.add(word);
            return;
        }
        if(open < n){
            open++;
            helper(word+"(", open, close, ans, n);
            open--;
        }
        if(open > close){
            close++;
            helper(word+")", open, close, ans, n);
            close--;
        }

    }
}
