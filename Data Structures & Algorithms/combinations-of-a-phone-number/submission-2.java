class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        List<String> ans =  new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0, digits, sb, ans, hm);
        return ans;   
    }

    public void helper(int i, String digits, StringBuilder sb, List<String> ans,
    HashMap<Character, String> hm){
        if(i == digits.length()){
            if(sb.length() > 0)
                ans.add(sb.toString());
            return;
        }
        String str = hm.get(digits.charAt(i));
        for(int j = 0; j < str.length(); j++){
            char ch = str.charAt(j);
            sb.append(ch);
            helper(i+1, digits, sb, ans, hm);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}