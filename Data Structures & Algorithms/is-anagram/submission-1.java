class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] countArr = new int[26]; // O(26)
        for (int i = 0;i < s.length(); i++){ // O(n)
            countArr[s.charAt(i) - 'a']++;
            countArr[t.charAt(i) - 'a']--;
        }
        for (int x : countArr){
            if(x!=0) return false;
        }
        return true;
    }
}
