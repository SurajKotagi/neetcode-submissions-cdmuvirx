class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(String s, int idx, List<String> cur, List<List<String>> ans){
        if(idx == s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            String str = s.substring(idx, i+1);
            if(isPalindrome(str)){
                cur.add(str);
                helper(s, i+1, cur, ans);
                cur.remove(cur.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}