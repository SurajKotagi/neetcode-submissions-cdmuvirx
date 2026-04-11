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
        helper(digits, sb, ans, hm);
        return ans;   
    }

    public void helper(String digits, StringBuilder sb, List<String> ans,
    HashMap<Character, String> hm){
        if(digits.length() == 0){
            if(sb.length() > 0)
                ans.add(sb.toString());
            return;
        }
        char[] arr = hm.get(digits.charAt(0)).toCharArray();
        for(char ch : arr){
            sb.append(ch);
            helper(digits.substring(1), sb, ans, hm);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}