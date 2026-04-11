class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1) return 1;

        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0;
        hm.put(s.charAt(l), 1);
        int r = 1;

        int maxSeq = 1;
        int maxFq = 1;
        while (r < s.length()) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            
            if(hm.get(s.charAt(r)) >= maxFq)
                maxFq = hm.get(s.charAt(r));

            while((r - l + 1) - maxFq > k){
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
            maxSeq = Math.max(maxSeq, r - l);
        }
        return maxSeq;
    }
}
