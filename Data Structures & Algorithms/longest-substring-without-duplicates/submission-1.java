class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int [127 - 32 + 1];
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while(r < s.length()) {
            char ch = s.charAt(r);
            if(arr[ch - ' '] == 0){
                arr[ch - ' ']++;
                r++;
                maxLen = Math.max(maxLen, r - l);
            } else {
                arr[s.charAt(l) - ' '] = 0;
                l++;
            }
        }
        return maxLen;
    }
}
