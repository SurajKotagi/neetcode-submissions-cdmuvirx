class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        helper(0, nums, ans, new ArrayList<>(), hs);
        return ans;
    }

    public void helper(int i, int[] nums, List<List<Integer>> ans, List<Integer> cur, HashSet<Integer> hs) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if(!hs.contains(j)){
                hs.add(j);
                cur.add(nums[j]);
                helper(i+1, nums, ans, cur, hs);
                cur.remove(cur.size()-1);
                hs.remove(j);
            }
        }
        
    }
}
