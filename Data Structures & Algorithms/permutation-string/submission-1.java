class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] s1Cnt = new int[26];
        for(char ch : s1.toCharArray()){
            s1Cnt[ch-'a']++;
        }

        int[] s2Cnt = new int[26];
        int len = 0;
        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            s2Cnt[ch - 'a']++;
            len++;
            if (s2Cnt[ch - 'a'] <= s1Cnt[ch - 'a']){
                if(len == s1.length()) return true;
            } else {
                while(s2Cnt[ch-'a'] > s1Cnt[ch-'a']){
                    s2Cnt[s2.charAt(left) - 'a']--;
                    left++;
                    len--;
                }
            }
        }
        return false;
    }
}
