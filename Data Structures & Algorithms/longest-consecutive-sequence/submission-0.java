class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int x : nums) hs.add(x);

        int maxCnt = 0;
        for(int x : nums){
            int cnt = 1;
            if(!hs.contains(x-1)){
                while(hs.contains(x+1)) {
                    cnt++;
                    x++;
                }
                if(cnt > maxCnt) maxCnt = cnt;
            }
        }
        return maxCnt;
    }
}
