class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character, Integer> countT = new HashMap<>();
        for(char ch : t.toCharArray()) countT.put(ch, countT.getOrDefault(ch, 0) + 1);

        int need = t.length();
        int have = 0;

        int [] res = {-1, -1};
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (countT.containsKey(ch) && window.get(ch) <= countT.get(ch)){
                have++;
            }
 
            while (have == need) {
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char lch = s.charAt(l);
                if(countT.containsKey(lch) && window.get(lch) <= countT.get(lch)){
                    have--;
                }
                window.put(lch, window.get(lch)-1);
                l++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(res[0], res[1] + 1);
    }
}
