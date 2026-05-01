class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);
        if(!hs.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int len = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            len++;
            for(int i = 0; i < sz; i++) {
                StringBuilder cur = new StringBuilder(q.remove());
                hs.remove(cur.toString());
                if(cur.toString().equals(endWord)) return len;
                for(int j = 0; j < cur.length(); j++) {
                    char prev = cur.charAt(j);
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        cur.setCharAt(j, ch);
                        if(hs.contains(cur.toString())){
                            // System.out.println(cur);
                            q.add(cur.toString());
                        }
                        cur.setCharAt(j, prev);
                    }
                }
            }
        }
        return 0;
    }
}